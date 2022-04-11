package problem1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * File generator is an abstract class that is used to generate files
 */
public class FileGenerator implements FileGeneratorI{
  String csv;
  String template;
  String outputDirPath;

  ArrayList<ArrayList<String>> informationFromCsv = new ArrayList<>();
  HashMap<String, Integer> columnIndices = new HashMap<>();

  /**
   * Abstract constructor for the file generator class
   * @param csv CSV file to derive information from to fill letter
   * @param template Template file to use to generate letter
   * @param outputDirPath Output directory to save newly generated letter to.
   */
  public FileGenerator(String csv, String template, String outputDirPath) {
    this.csv = csv;
    this.template = template;
    this.outputDirPath = outputDirPath;
  }

  public String createFileName(Integer index){
    // By default, use first name and last name keys
    String defaultName = this.generateDefaultFileName(index);

    // If generating default file name produce empty file name
    if (defaultName.equals("")) {
      return "file_" + index + ".txt";
    } else {
      return defaultName + ".txt";
    }
  }

  public String generateDefaultFileName(Integer index) {
    ArrayList<String> row = this.informationFromCsv.get(index);

    String firstName = null;
    String lastName = null;
    String fileName = "";

    for (String key:  this.columnIndices.keySet()) {
      if (key.toLowerCase().matches("first.*name")){
        firstName = row.get(this.columnIndices.get(key));
      }

      if (key.toLowerCase().matches("last.*name")){
        lastName = row.get(this.columnIndices.get(key));
      }
    }

    if (firstName != null) {
      fileName = fileName.concat(firstName);
    }

    if (lastName != null) {
      if (fileName.length() > 0){
        fileName = fileName.concat("_");
      }

      fileName = fileName.concat(lastName);
    }

    return fileName;
  }

  private String getValue(Integer index, String key) {
    return this.informationFromCsv.get(index).get(this.columnIndices.get(key));
  }

  /**
   *
   */
  public void createColumnIndices() {
    for (int i = 0; i < this.informationFromCsv.get(0).size(); i++ ){
      String key = this.informationFromCsv.get(0).get(i);
      if (!key.equals("")) {
        Integer value = i;
        this.columnIndices.put(key, value);
      }
    }
  }

  /**
   *
   * @param fileLocation
   */
  public void parseCsv(String fileLocation){
    try{
      BufferedReader reader = new BufferedReader(new FileReader(csv));
      String line;
      while ((line = reader.readLine()) != null) {
        ArrayList<String> csvRow = new ArrayList(Arrays.asList(line.split("\"*,*\"")));
        System.out.println(Arrays.deepToString(csvRow.toArray()));
        this.informationFromCsv.add(csvRow);
      }
      reader.close();
      this.createColumnIndices();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void writeFileContent(Integer rowIndex, String fileName) {
    try {
      BufferedReader reader = new BufferedReader(new FileReader(this.template));
      BufferedWriter writer = new BufferedWriter(new FileWriter( outputDirPath + "/" + fileName));
      String line;
      Pattern pattern = Pattern.compile("\\[\\[(.*?)\\]\\]");

      while ((line = reader.readLine()) != null) {
        Matcher matcher = pattern.matcher(line);

        while (matcher.find()){
          String key = matcher.group(1);
          String value = this.getValue(rowIndex, key);

          line = line.replace(matcher.group(), value);
        }

        writer.write(line);
        writer.newLine();

      }
      reader.close();
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void generate(){
    this.parseCsv(this.csv);
//    System.out.println(Arrays.deepToString(this.informationFromCsv.toArray()));
    System.out.println("Printing columnIndices Hashmap");
    System.out.println(Arrays.asList(this.columnIndices));

    if (this.informationFromCsv.size() > 1) {
      // Ignore column headers, skip first row
      for (int i = 1; i < this.informationFromCsv.size(); i++) {
        String fileName = this.createFileName(i);

        this.writeFileContent(i, fileName);
      }
    }
  }

}
