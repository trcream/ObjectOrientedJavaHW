package problem1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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
    ArrayList<String> parsedValues = new ArrayList<>();
    for(int i = 0; i< parsedArray.size(); i++){
      String[] list = parsedArray.get(i).split("\",\"");
      parsedValues.add(list[0].replaceAll("\"", ""));
      parsedValues.add(list[1].replaceAll("\"", ""));
      parsedValues.add(list[10].replaceAll("\"", ""));
    }
    return parsedValues;
  }

  public void writeFileContent(String fileLocation ){
    ArrayList<String> parsedArray = new ArrayList<>();
    parsedArray = super.parseCsv(fileLocation);
    for(int i = 0; i< parsedArray.size(); i++) {
      String[] list = parsedArray.get(i).split("\",\"");

      fileLocation = "C:\\Users\\trent\\Desktop\\Masters Programs\\Northeastern\\CS5004\\GroupProject\\Team_repo_Repo6_Arjun_Matthew_Trenton\\Assignment8\\src\\main\\java\\problem1\\email-template.txt";
      try {
        BufferedReader reader = new BufferedReader(new FileReader(fileLocation));
        BufferedWriter writer = new BufferedWriter(new FileWriter("testing.txt"));

        String line;

        while ((line = reader.readLine()) != null) {
          //System.out.println(line.replaceAll("\\[\\[email", "").replaceAll("]]", "trentoncreamer@yahoo.com"));
          line = line.replaceAll("\\[\\[emai", "").replaceAll("l]]", list[1].replaceAll("\"", ""));
          //System.out.println(line.replaceAll("\\[\\[first_name", "").replaceAll("]]", "trenton"));
          line = line.replaceAll("\\[\\[fi", "")
              .replaceAll("rst_name]]", list[1].replaceAll("\"", ""));
          //System.out.println(line.replaceAll("\\[\\[last_name", "").replaceAll("]]", "Creamer"));
          line = line.replaceAll("\\[\\[l", "")
              .replaceAll("ast_name]]", list[10].replaceAll("\"", ""));

          writer.write(line);
          writer.newLine();

        }
        reader.close();
        writer.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

  }

//  public void writeFileContent(String fileLocation, String firstName, String lastName, String email ){
//    fileLocation = "C:\\Users\\trent\\Desktop\\Masters Programs\\Northeastern\\CS5004\\GroupProject\\Team_repo_Repo6_Arjun_Matthew_Trenton\\Assignment8\\src\\main\\java\\problem1\\email-template.txt";
//
//    try {
//      BufferedReader reader = new BufferedReader(new FileReader(fileLocation));
//      BufferedWriter writer = new BufferedWriter(new FileWriter("testing.txt"));
//
//      String line;
//
//      while((line = reader.readLine()) != null){
//        //System.out.println(line.replaceAll("\\[\\[email", "").replaceAll("]]", "trentoncreamer@yahoo.com"));
//        line = line.replaceAll("\\[\\[emai", "").replaceAll("l]]", firstName);
//        //System.out.println(line.replaceAll("\\[\\[first_name", "").replaceAll("]]", "trenton"));
//        line = line.replaceAll("\\[\\[fi", "").replaceAll("rst_name]]", lastName);
//        //System.out.println(line.replaceAll("\\[\\[last_name", "").replaceAll("]]", "Creamer"));
//        line = line.replaceAll("\\[\\[l", "").replaceAll("ast_name]]", email);
//
//        writer.write(line);
//        writer.newLine();
//
//      }
//      reader.close();
//      writer.close();
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//
//  }


//  @Override
//  createFileName(){
//    // return "firstname_lastname_email".txt
//  }
}
