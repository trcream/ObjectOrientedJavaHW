package problem1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class EmailGenerator extends FileGenerator {

  public String firstName;
  public String lastName;
  public String email;
  public Integer firstNameIndex;
  public Integer lastNameIndex;
  public Integer emailIndex;

  /**
   * @param csv       CSV file to derive information from to fill letter
   * @param template  Template file to use to generate letter
   * @param outputDirPath Output directory to save newly generated letter to.
   */

  public EmailGenerator(String csv, String template, String outputDirPath) {
    super(csv, template, outputDirPath);
    this.firstName = null;
    this.lastName = null;
    this.email = null;
    this.firstNameIndex = null;
    this.lastNameIndex = null;
    this.emailIndex = null;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Integer getFirstNameIndex() {
    return firstNameIndex;
  }

  public void setFirstNameIndex(Integer firstNameIndex) {
    this.firstNameIndex = firstNameIndex;
  }

  public Integer getLastNameIndex() {
    return lastNameIndex;
  }

  public void setLastNameIndex(Integer lastNameIndex) {
    this.lastNameIndex = lastNameIndex;
  }

  public Integer getEmailIndex() {
    return emailIndex;
  }

  public void setEmailIndex(Integer emailIndex) {
    this.emailIndex = emailIndex;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setHeaderValues(String csv){
    int counter = 0;
    //loop through the first line in the list and set the header values;
    ArrayList<String> parsedArray = new ArrayList<>();
    parsedArray = super.parseCsv(csv);
    String[] list = parsedArray.get(0).split("\",\"");
    //Setting header index values
    for(int i = 0; i < list.length; i++){
      //looping through the length of the firs line in the array
      if(list[i].contains("first_name")){
        this.firstNameIndex = counter;
      }
      else if(list[i].contains("last_name")){
        this.lastNameIndex = counter;
      }
      else if(list[i].equals("email")){
        this.emailIndex = counter;
      }
      counter ++;
    }
  }

  @Override
  public ArrayList<String> parseCsv(String fileLocation) {
    return super.parseCsv(fileLocation);
  }

  public void generateFileContent(String csv, String template, String outputDirPath){
    ArrayList<String> parsedArray = new ArrayList<>();
    parsedArray = super.parseCsv(csv);
    //Method to dynamically set all of the header values
    setHeaderValues(csv);
    int fileCounter = 0;
    for(int i = 0; i< parsedArray.size(); i++) {
      String[] list = parsedArray.get(i).split("\",\"");

      try {
        BufferedReader reader = new BufferedReader(new FileReader(template));
        BufferedWriter writer = new BufferedWriter(new FileWriter( outputDirPath + "\\generatedEmail" +  fileCounter));
        String line;

        while ((line = reader.readLine()) != null) {
          //Update below to make general with set header values method
//          this.email = list[10];
//          this.firstName = list[0];
//          this.lastName = list[1];
          //Dynamically setting the headers
          this.email = list[emailIndex];
          this.firstName = list[firstNameIndex];
          this.lastName = list[lastNameIndex];
          // Make the CSV file general
          line = line.replaceAll("\\[\\[emai", "")
              .replaceAll("l]]", this.email.replaceAll("\"", ""))
              .replaceAll("\\[\\[fi", "")
              .replaceAll("rst_name]]", this.firstName.replaceAll("\"", ""))
              .replaceAll("\\[\\[l", "")
              .replaceAll("ast_name]]", this.lastName.replaceAll("\"", ""));
          writer.write(line);
          writer.newLine();

        }
        fileCounter +=1;
//        System.out.println(fileCounter);
        reader.close();
        writer.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

  }


  @Override
  public void createFileName() {
    super.createFileName();
  }
}
