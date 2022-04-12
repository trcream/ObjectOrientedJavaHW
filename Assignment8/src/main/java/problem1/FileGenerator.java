package problem1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * File generator is a class that is used to generate files
 */
public class FileGenerator implements FileGeneratorI{
  String csv;
  String template;
  String outputDirPath;

  ArrayList<ArrayList<String>> informationFromCsv = new ArrayList<>();
  HashMap<String, Integer> columnIndices = new HashMap<>();

  /**
   * Constructor for the file generator class
   * @param csv CSV file to derive information from to fill letter
   * @param template Template file to use to generate letter
   * @param outputDirPath Output directory to save newly generated letter to.
   */
  public FileGenerator(String csv, String template, String outputDirPath) {
    this.csv = csv;
    this.template = template;
    this.outputDirPath = outputDirPath;
  }

  /**
   * Returns the csv file path
   * @return - the csv file path
   */
  public String getCsv() {
    return csv;
  }

  /**
   * Returns the template file path
   * @return - the template file path
   */
  public String getTemplate() {
    return template;
  }

  /**
   * Returns the output directory file path
   * @return - the output directory file path
   */
  public String getOutputDirPath() {
    return outputDirPath;
  }

  /**
   * Returns the information from csv array list
   * @return - the information from csv array list
   */
  public ArrayList<ArrayList<String>> getInformationFromCsv() {
    return informationFromCsv;
  }

  /**
   * Returns the column indices hashmap
   * @return - the column indices hashmap
   */
  public HashMap<String, Integer> getColumnIndices() {
    return columnIndices;
  }

  /**
   * Method to create file names
   * @param index - index of the name in the row to be returned
   * @return - the filename
   */
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

  /**
   * Method to generate default file names. Names are returned by matching
   * hashmap key values which correspond to the matching row index values
   * @param index - index of the row in the csv to parse data from
   * @return - generated file name
   */
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
   * Method to create column indices with key values that match the csv headers
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
   * Method to parse csv data into an array list
   * @param fileLocation -csv file to be parsed
   */
  public void parseCsv(String fileLocation){
    try{
      BufferedReader reader = new BufferedReader(new FileReader(csv));
      String line;
      while ((line = reader.readLine()) != null) {
        ArrayList<String> csvRow = new ArrayList(Arrays.asList(line.split("\"*,*\"")));
        //System.out.println(Arrays.deepToString(csvRow.toArray()));
        this.informationFromCsv.add(csvRow);
      }
      reader.close();
      this.createColumnIndices();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Method to read data from template, input the correct data,and then generate the file
   * @param rowIndex - rowIndex to read, input,and write data
   * @param fileName - file name of the file to be generated
   */
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

  /**
   * Method that is used to call the other helper methods to read, input, and generate the desired files
   */
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

  /**
   * Returns whether some other object is "equal to" this one.
   * @return whether some other object is "equal to" this one, encoded as a Boolean.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FileGenerator that = (FileGenerator) o;
    return Objects.equals(csv, that.csv) && Objects.equals(template,
        that.template) && Objects.equals(outputDirPath, that.outputDirPath)
        && Objects.equals(informationFromCsv, that.informationFromCsv)
        && Objects.equals(columnIndices, that.columnIndices);
  }

  /**
   * Method to determine if the hashcode of the object is a match
   * @return - a hashcode value for the object returned as an integer
   */
  @Override
  public int hashCode() {
    return Objects.hash(csv, template, outputDirPath, informationFromCsv, columnIndices);
  }

  /**
   * Returns a string representation of the object.
   * @return a string representation of the object, encoded as a String.
   */
  @Override
  public String toString() {
    return "FileGenerator{" +
        "csv='" + csv + '\'' +
        ", template='" + template + '\'' +
        ", outputDirPath='" + outputDirPath + '\'' +
        ", informationFromCsv=" + informationFromCsv +
        ", columnIndices=" + columnIndices +
        '}';
  }
}
