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


  public void LetterGenerator(String fileLocation) throws IOException {
    ArrayList<String> parsedArray = new ArrayList<>();
    parsedArray = super.parseCsv(fileLocation);
    int fileCounter = 0;
    for(int i = 0; i< parsedArray.size(); i++) {
      String[] list = parsedArray.get(i).split("\",\"");

      fileLocation = "C:\\Users\\Arjun Patel\\IdeaProjects\\Team_repo_Repo6_Arjun_Matthew_Trenton\\Assignment8\\src\\main\\java\\problem1\\letter-template.txt" ;
      try {
        BufferedReader reader = new BufferedReader(new FileReader(fileLocation));
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Arjun Patel\\IdeaProjects\\Team_repo_Repo6_Arjun_Matthew_Trenton\\Assignment8\\src\\main\\java\\file\\letter" +  fileCounter+".txt"));
        String line;

        while ((line = reader.readLine()) != null) {
          writer.write(line
              .replaceAll("\\[\\[first_name", list[0].replaceAll("\"","")).replaceAll("]]", "")
              .replaceAll("\\[\\[last_name", list[1]).replaceAll("]]", "")
              .replaceAll("\\[\\[company_name", list[2]).replaceAll("]]", "")
              .replaceAll("\\[\\[address", list[3]).replaceAll("]]", "")
              .replaceAll("\\[\\[city", list[4]).replaceAll("]]", "")
              .replaceAll("\\[\\[county", list[5]).replaceAll("]]", "]]")
              .replaceAll("\\[\\[state", list[6]).replaceAll("]]", "")
              .replaceAll("\\[\\[zip", list[7]).replaceAll("]]", "")
              .replaceAll("\\[\\[email", list[10]).replaceAll("]]", ""));
          System.out.println("Read: " + line);
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
}
