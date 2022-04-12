package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileGeneratorTest {

  private FileGenerator testFileGenerator;
  private FileGenerator testFileGenerator2;
  String emailTemplateFilePath = "C:\\Users\\trent\\Desktop\\Masters Programs\\Northeastern\\CS5004\\GroupProject\\Team_repo_Repo6_Arjun_Matthew_Trenton\\Assignment8\\src\\main\\java\\inputFiles\\email-template.txt";
  String csvFilePath = "C:\\Users\\trent\\Desktop\\Masters Programs\\Northeastern\\CS5004\\GroupProject\\Team_repo_Repo6_Arjun_Matthew_Trenton\\Assignment8\\src\\main\\java\\inputFiles\\insurance-company-members.csv";
  String csvFilePath2 = "C:\\Users\\trent\\Desktop\\Masters Programs\\Northeastern\\CS5004\\GroupProject\\Team_repo_Repo6_Arjun_Matthew_Trenton\\Assignment8\\src\\main\\java\\inputFiles\\insurance-company-members3.csv";
  String outputFilePath = "C:\\Users\\trent\\Desktop\\Masters Programs\\Northeastern\\CS5004\\GroupProject\\Team_repo_Repo6_Arjun_Matthew_Trenton\\Assignment8\\src\\main\\java\\outputFiles";

  @BeforeEach
  void setUp() {

    testFileGenerator = new FileGenerator(csvFilePath, emailTemplateFilePath, outputFilePath);
    testFileGenerator2 = new FileGenerator(csvFilePath2, emailTemplateFilePath, outputFilePath);
  }

  @Test
  void createFileName() {
    testFileGenerator.parseCsv(csvFilePath);
    testFileGenerator2.parseCsv(csvFilePath2);
    assertEquals("first_name_last_name.txt", testFileGenerator.createFileName(0));
    assertEquals("file_0.txt", testFileGenerator2.createFileName(0));
  }

}