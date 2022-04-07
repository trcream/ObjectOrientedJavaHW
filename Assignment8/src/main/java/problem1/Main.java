package problem1;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

  public static void main(String[] args) {
    FileGenerator testFileGenerator = new FileGenerator("test", "test", "test");
    //testFileGenerator.fileReader("C:\\Users\\trent\\Desktop\\Masters Programs\\Northeastern\\CS5004\\GroupProject\\Team_repo_Repo6_Arjun_Matthew_Trenton\\HW8\\src\\main\\java\\Problem1\\insurance-company-members.csv");
    EmailGenerator testEmailGenerator = new EmailGenerator("test", "test", "test");
    testEmailGenerator.parseCsv("C:\\Users\\trent\\Desktop\\Masters Programs\\Northeastern\\CS5004\\GroupProject\\Team_repo_Repo6_Arjun_Matthew_Trenton\\Assignment8\\src\\main\\java\\problem1\\insurance-company-members.csv");
    //testEmail.readTemplate("C:\\Users\\trent\\Desktop\\Masters Programs\\Northeastern\\CS5004\\GroupProject\\Team_repo_Repo6_Arjun_Matthew_Trenton\\HW8\\src\\main\\java\\Problem1\\email-template.txt");
  }
}
