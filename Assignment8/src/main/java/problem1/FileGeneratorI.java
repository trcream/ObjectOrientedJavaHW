package problem1;

import java.util.ArrayList;

/**
 * Interface for the file generator class
 */
public interface FileGeneratorI {

  /**
   * Method to create file names
   * @return - file names
   */
  String createFileName();

  /**
   * Method to parse values based on a given csv file
   * @param csv - file location of the csv to be parsed
   * @return
   */
  ArrayList<String> parseCsv(String csv);

  void setHeaderValues(String csv);

  void generateFileContent(String csv, String template, String outputDirPath);

}
