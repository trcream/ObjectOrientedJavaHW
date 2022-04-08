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
    return super.parseCsv(fileLocation);
  }

  public void writeFileContent(String fileLocation ){
    ArrayList<String> parsedArray = new ArrayList<>();
    parsedArray = super.parseCsv(fileLocation);
    int fileCounter = 0;
    for(int i = 0; i< parsedArray.size(); i++) {
      String[] list = parsedArray.get(i).split("\",\"");

      fileLocation = "C:\\Users\\trent\\Desktop\\Masters Programs\\Northeastern\\CS5004\\GroupProject\\Team_repo_Repo6_Arjun_Matthew_Trenton\\Assignment8\\src\\main\\java\\problem1\\email-template.txt" ;
      try {
        BufferedReader reader = new BufferedReader(new FileReader(fileLocation));
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\trent\\Desktop\\Masters Programs\\Northeastern\\CS5004\\GroupProject\\Team_repo_Repo6_Arjun_Matthew_Trenton\\Assignment8\\src\\main\\java\\file\\generatedEmail.txt" +  fileCounter));
        String line;

        while ((line = reader.readLine()) != null) {
          //System.out.println(line.replaceAll("\\[\\[email", "").replaceAll("]]", "trentoncreamer@yahoo.com"));
          line = line.replaceAll("\\[\\[emai", "").replaceAll("l]]", list[10].replaceAll("\"", ""));
          line = line.replaceAll("\\[\\[fi", "")
              .replaceAll("rst_name]]", list[0].replaceAll("\"", ""));
          //System.out.println(line);
          line = line.replaceAll("\\[\\[l", "")
              .replaceAll("ast_name]]", list[1].replaceAll("\"", ""));
          writer.write(line);
          writer.newLine();

        }
        fileCounter +=1;
        System.out.println(fileCounter);
        reader.close();
        writer.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    fileCounter+=1;
    System.out.println(fileCounter);
  }


//  @Override
//  createFileName(){
//    // return "firstname_lastname_email".txt
//  }
}
