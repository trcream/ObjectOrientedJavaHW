package problem1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EmailGenerator extends FileGenerator {

  /**
   * @param csv       CSV file to derive information from to fill letter
   * @param template  Template file to use to generate letter
   * @param outputDirPath Output directory to save newly generated letter to.
   */
  public EmailGenerator(String csv, String template, String outputDirPath) {
    super(csv, template, outputDirPath);
  }

  @Override
  public void parseCsv(String fileLocation) {
    super.parseCsv(fileLocation);
  }

  public void readTemplate(String fileLocation){

    fileLocation = "C:\\Users\\trent\\Desktop\\Masters Programs\\Northeastern\\CS5004\\GroupProject\\Team_repo_Repo6_Arjun_Matthew_Trenton\\HW8\\src\\main\\java\\Problem1\\email-template.txt";
    try {
      BufferedReader reader = new BufferedReader(new FileReader(fileLocation));
      String line;
      while((line = reader.readLine()) != null){
        System.out.println("Read: " + line);
      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

//  @Override
//  createFileName(){
//    // return "firstname_lastname_email".txt
//  }
}
