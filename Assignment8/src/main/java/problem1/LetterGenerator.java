package problem1;

import java.io.BufferedReader;

public class LetterGenerator extends FileGenerator{
  /**
   * @param csv       CSV file to derive information from to fill letter
   * @param template  Template file to use to generate letter
   * @param outputDirPath Output directory to save newly generated letter to.
   */
  public LetterGenerator(BufferedReader csv, BufferedReader template, String outputDirPath) {
    super(csv, template, outputDirPath);
  }

  @Override
  createFileName(){
    // return "firstname_lastname_letter".txt
  }
}
