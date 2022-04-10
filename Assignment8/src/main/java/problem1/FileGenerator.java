package problem1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public abstract class FileGenerator {

  /**
   *
   * @param csv CSV file to derive information from to fill letter
   * @param template Template file to use to generate letter
   * @param outputDirPath Output directory to save newly generated letter to.
   */

  public FileGenerator(String csv, String template, String outputDirPath) {

  }

  public void createFileName(){
    // return "firstname_lastname.txt
  }

  public ArrayList<String> parseCsv(String fileLocation){
    // parse CSV file to get information, need to match data to column name
    ArrayList<String> parsedArray = new ArrayList<>();
    try{
      BufferedReader reader = new BufferedReader(new FileReader(fileLocation));
      String line;
      while ((line = reader.readLine()) != null) {
        parsedArray.add(line);
        // Error handling if length is less than 1
      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return parsedArray;
  }

  public void generateFileContent(String csv, String template, String outputDirPath) {
  }

}
