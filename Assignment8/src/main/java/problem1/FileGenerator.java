package problem1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * File generator is an abstract class that is used to generate files
 */
public abstract class FileGenerator implements FileGeneratorI{

  /**
   * Abstract constructor for the file generator class
   * @param csv CSV file to derive information from to fill letter
   * @param template Template file to use to generate letter
   * @param outputDirPath Output directory to save newly generated letter to.
   */

  public FileGenerator(String csv, String template, String outputDirPath) {

  }

  /**
   * Method to create File Names
   */

  public String createFileName(){
    // return "firstname_lastname.txt
    return "";
  }

  /**
   * Method to parse the line values from a given csv file
   * @param csv - file location of the csv to be parsed
   * @return - Array list of parsed csv values
   */
  public ArrayList<String> parseCsv(String csv){
    // parse CSV file to get information, need to match data to column name
    ArrayList<String> parsedArray = new ArrayList<>();
    try{
      BufferedReader reader = new BufferedReader(new FileReader(csv));
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

  /**
   * Method to set the index values for the requested header fields
   * @param csv - CSV to set the header values to
   */
  public void setHeaderValues(String csv) {

  }

  /**
   * Method to generate emails based upon file input and desired output location
   * @param csv - csv file to parse user data from
   * @param template - template to insert user data into
   * @param outputDirPath - output path to store generated files
   */

  public void generateFileContent(String csv, String template, String outputDirPath) {
  }

}
