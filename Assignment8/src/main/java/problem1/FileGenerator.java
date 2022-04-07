package problem1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileGenerator {

  private String firstName;
  private String lastName;
  private String companyName;
  private String address;
  private String city;
  private String county;
  private String state;
  private String zip;
  private String phone1;
  private String phone2;
  private String email;
  private String web;

  /**
   *
   * @param csv CSV file to derive information from to fill letter
   * @param template Template file to use to generate letter
   * @param outputDirPath Output directory to save newly generated letter to.
   */
  //Double check no buffered reader in constructor
  public FileGenerator(String csv, String template, String outputDirPath) {


  }

  public void createFileName(){
    // return "firstname_lastname.txt
  }

  //Update return type

  public void parseCsv(String fileLocation){
    // parse CSV file to get information, need to match data to column name
    fileLocation = "C:\\Users\\trent\\Desktop\\Masters Programs\\Northeastern\\CS5004\\GroupProject\\Team_repo_Repo6_Arjun_Matthew_Trenton\\Assignment8\\src\\main\\java\\problem1\\insurance-company-members.csv";

    try{
      BufferedReader reader = new BufferedReader(new FileReader(fileLocation));
      String line;
      while ((line = reader.readLine()) != null) {
        //System.out.println("Read: " + line);
        String[] list = line.split("\",\"");
        //String firstname = list[0].replaceAll("\"", "");
        //System.out.println("First name: " + firstname);
        System.out.println("First name: " + list[0].replaceAll("\"", ""));
        System.out.println("Last name: " + list[1].replaceAll("\"", ""));
        System.out.println("Company: " + list[2].replaceAll("\"", ""));
        System.out.println("Address: " + list[3].replaceAll("\"", ""));
        System.out.println("City: " + list[4].replaceAll("\"", ""));
        System.out.println("County: " + list[5].replaceAll("\"", ""));
        System.out.println("Sate: " + list[6].replaceAll("\"", ""));
        System.out.println("Zip: " + list[7].replaceAll("\"", ""));
        System.out.println("Phone1: " + list[8].replaceAll("\"", ""));
        System.out.println("Phone2: " + list[9].replaceAll("\"", ""));
        System.out.println("Email: " + list[10].replaceAll("\"", ""));
        System.out.println("Web: " + list[11].replaceAll("\"", ""));

      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  //Update return type

  public void writeFileContent() {
    // go through template and fill in [[ ]] with right information from csv
  }

  //Update return type
  public void generate(){
    // create new BufferedWriter
    // Replace strings in template with data from csv
  }
}
