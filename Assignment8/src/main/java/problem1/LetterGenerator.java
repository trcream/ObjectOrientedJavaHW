package problem1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class LetterGenerator extends FileGenerator{
  /**
   * @param csv       CSV file to derive information from to fill letter
   * @param template  Template file to use to generate letter
   * @param outputDirPath Output directory to save newly generated letter to.
   */
  public LetterGenerator(String csv, String template, String outputDirPath) {
    super(csv, template, outputDirPath);
  }

  public String helperFunction(String line){
    if(line == null){
      return "Error. There is a null";
    }
    else {
      return line
          .replaceAll("\\[\\[first_name", "Arjun").replaceAll("]]", "")
          .replaceAll("\\[\\[last_name", "Patel").replaceAll("]]", "")
          .replaceAll("\\[\\[company_name", "ARJUN PATEL LLC").replaceAll("]]", "")
          .replaceAll("\\[\\[address", "4234 Battery St").replaceAll("]]", "")
          .replaceAll("\\[\\[city", "Seattle").replaceAll("]]", "")
          .replaceAll("\\[\\[county", "King").replaceAll("]]", "]]")
          .replaceAll("\\[\\[state", "WA").replaceAll("]]", "")
          .replaceAll("\\[\\[zip", "91234").replaceAll("]]", "")
          .replaceAll("\\[\\[email", "patel.arjun1@northeastern.edu").replaceAll("]]", "");
    }
  }


  public void LetterGenerator(String fileLocation, ArrayList<String>list) throws IOException {
    fileLocation = "C:\\Users\\Arjun Patel\\IdeaProjects\\Team_repo_Repo6_Arjun_Matthew_Trenton\\Assignment8\\src\\main\\java\\problem1\\letter-template.txt";

    try {
      BufferedReader reader = new BufferedReader(new FileReader(fileLocation));

      String line;
      int i =0; //index of list
      int length = list.size();
      //line = reader.readLine();
      while((i <= length)) {
        String firstname = list.get(i);
        String lastname = list.get(i + 1);
        String companyname = list.get(i + 2);
        String address = list.get(i + 3);
        String city = list.get(i + 4);
        String county = list.get(i + 5);
        String state = list.get(i + 6);
        String zip = list.get(i + 7);
        String email = list.get(i + 10);
        BufferedWriter writer = new BufferedWriter(new FileWriter(
            "C:\\Users\\Arjun Patel\\IdeaProjects\\Team_repo_Repo6_Arjun_Matthew_Trenton\\Assignment8\\src\\main\\java\\file\\"+ firstname + "_" + lastname + ".txt"));

        while ((line = reader.readLine()) != null) {
          line
              .replaceAll("\\[\\[first_name", firstname).replaceAll("]]", "")
              .replaceAll("\\[\\[last_name", lastname).replaceAll("]]", "")
              .replaceAll("\\[\\[company_name", companyname).replaceAll("]]", "")
              .replaceAll("\\[\\[address", address).replaceAll("]]", "")
              .replaceAll("\\[\\[city", city).replaceAll("]]", "")
              .replaceAll("\\[\\[county", county).replaceAll("]]", "]]")
              .replaceAll("\\[\\[state", state).replaceAll("]]", "")
              .replaceAll("\\[\\[zip", zip).replaceAll("]]", "")
              .replaceAll("\\[\\[email", email).replaceAll("]]", "");
          System.out.println("Read: " + line);
          writer.write(helperFunction(line));
          writer.newLine();

        }
        reader.close();
        writer.close();
        i = i + 12;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
