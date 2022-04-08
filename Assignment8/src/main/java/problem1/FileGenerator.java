package problem1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCounty() {
    return county;
  }

  public void setCounty(String county) {
    this.county = county;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  public String getPhone1() {
    return phone1;
  }

  public void setPhone1(String phone1) {
    this.phone1 = phone1;
  }

  public String getPhone2() {
    return phone2;
  }

  public void setPhone2(String phone2) {
    this.phone2 = phone2;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getWeb() {
    return web;
  }

  public void setWeb(String web) {
    this.web = web;
  }

  public void createFileName(){
    // return "firstname_lastname.txt
  }

  //Update return type

  public ArrayList<String> parseCsv(String fileLocation){
    // parse CSV file to get information, need to match data to column name
    fileLocation = "C:\\Users\\trent\\Desktop\\Masters Programs\\Northeastern\\CS5004\\GroupProject\\Team_repo_Repo6_Arjun_Matthew_Trenton\\Assignment8\\src\\main\\java\\problem1\\insurance-company-members.csv";
    ArrayList<String> parsedArray = new ArrayList<>();
    try{
      BufferedReader reader = new BufferedReader(new FileReader(fileLocation));
      String line;
      while ((line = reader.readLine()) != null) {
        parsedArray.add(line);
        // Error handling if length is less than 1
      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return parsedArray;
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