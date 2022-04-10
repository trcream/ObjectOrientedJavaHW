package problem1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Email generator is a class that is used to generate emails to users
 */
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

  /**
   * Gets the first name
   * @return - the first name
   */

  public String getFirstName() {
    return firstName;
  }

  /**
   * Sets the first name
   * @param firstName - the first name
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Gets the last name
   * @return - the last name
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Sets the last name
   * @param lastName - the last name
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Gets the first name index
   * @return  - the first name index
   */
  public Integer getFirstNameIndex() {
    return firstNameIndex;
  }

  /**
   * Sets the first name index
   * @param firstNameIndex - the first name index
   */
  public void setFirstNameIndex(Integer firstNameIndex) {
    this.firstNameIndex = firstNameIndex;
  }

  /**
   * Gets the last name index
   * @return - the last name index
   */
  public Integer getLastNameIndex() {
    return lastNameIndex;
  }

  /**
   * Sets the last name index
   * @param lastNameIndex - the last name index
   */
  public void setLastNameIndex(Integer lastNameIndex) {
    this.lastNameIndex = lastNameIndex;
  }

  /**
   * Gets the email index
   * @return - the email index
   */
  public Integer getEmailIndex() {
    return emailIndex;
  }

  /**
   * Sets the email index
   * @param emailIndex - the email index
   */
  public void setEmailIndex(Integer emailIndex) {
    this.emailIndex = emailIndex;
  }

  /**
   * Gets the email value
   * @return - the email value
   */
  public String getEmail() {
    return email;
  }

  /**
   * Sets the email value
   * @param email - the email value
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Method to set the index values for the requested header fields
   * @param csv - CSV to set the header values to
   */
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

  /**
   * Method to parse the line values from a given csv file
   * @param csv - csv to be parsed
   * @return - Array list of parsed csv values
   */
  @Override
  public ArrayList<String> parseCsv(String csv) {
    return super.parseCsv(csv);
  }

  /**
   * Method to generate emails based upon file input and desired output location
   * @param csv - csv file to parse user data from
   * @param template - email template to insert user data into
   * @param outputDirPath - output path to store generated files
   */

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

//  /**
//   * Method to create file names based on name and number of emails generated
//   * @return - file names
//   */
//  @Override
//  public String createFileName() {
//    return super.createFileName();
//  }

  /**
   * Returns whether some other object is "equal to" this one.
   * @return whether some other object is "equal to" this one, encoded as a Boolean.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EmailGenerator that = (EmailGenerator) o;
    return Objects.equals(firstName, that.firstName) && Objects.equals(lastName,
        that.lastName) && Objects.equals(email, that.email) && Objects.equals(
        firstNameIndex, that.firstNameIndex) && Objects.equals(lastNameIndex,
        that.lastNameIndex) && Objects.equals(emailIndex, that.emailIndex);
  }

  /**
   * Returns a hash code value for the object.
   * @return a hash code value for the object, encoded as an Integer.
   */
  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName, email, firstNameIndex, lastNameIndex, emailIndex);
  }

  /**
   * Returns a string representation of the object.
   * @return a string representation of the object, encoded as a String.
   */
  @Override
  public String toString() {
    return "EmailGenerator{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", email='" + email + '\'' +
        ", firstNameIndex=" + firstNameIndex +
        ", lastNameIndex=" + lastNameIndex +
        ", emailIndex=" + emailIndex +
        "} " + super.toString();
  }
}
