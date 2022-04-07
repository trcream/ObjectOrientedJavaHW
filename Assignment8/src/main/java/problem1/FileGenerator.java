package problem1;

import java.io.BufferedReader;

public class FileGenerator {

  /**
   *
   * @param csv CSV file to derive information from to fill letter
   * @param template Template file to use to generate letter
   * @param outputDirPath Output directory to save newly generated letter to.
   */
  public FileGenerator(BufferedReader csv, BufferedReader template, String outputDirPath) {
  }

  public createFileName(){
    // return "firstname_lastname.txt
  }

  public parseCsv(){
    // parse CSV file to get information, need to match data to column name
  }

  public writeFileContent() {
    // go through template and fill in [[ ]] with right information from csv
  }

  public generate(){
    // create new BufferedWriter
    // Replace strings in template with data from csv
  }
}
