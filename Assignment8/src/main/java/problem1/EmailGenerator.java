package problem1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
  public ArrayList<String> parseCsv(String fileLocation) {
    ArrayList<String> parsedArray = new ArrayList<>();
    System.out.println("Printing from Email Generator");
    parsedArray = super.parseCsv(fileLocation);
    for(int i = 0; i< parsedArray.size(); i++){
      String[] list = parsedArray.get(i).split("\",\"");
      System.out.println("First name: " + list[0].replaceAll("\"", ""));
      System.out.println("Last name: " + list[1].replaceAll("\"", ""));
      System.out.println("Email: " + list[10].replaceAll("\"", ""));
    }
    return parsedArray;

  }

  public void writeFileContent(String fileLocation){
    try {
      BufferedReader reader = new BufferedReader(new FileReader(fileLocation));
      String line;

      while((line = reader.readLine()) != null){
       String[] tempArr = line.split(" ");
        for(int i =0; i< tempArr.length; i++){
          System.out.println(tempArr[i].replaceAll("\\[\\[email", "").replaceAll("]]", "trentoncreamer@yahoo.com"));
          //System.out.println(tempArr[i].replaceAll("\\\\[|\\\\]", "trentcreamer@yahoo.com"));

//          System.out.println(tempArr[i].replaceAll("first_name", "Trenton"));
//          System.out.println(tempArr[i].replaceAll("last_name", "Creamer"));
        }

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
