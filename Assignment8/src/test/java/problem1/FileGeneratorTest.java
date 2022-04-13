package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileGeneratorTest {

  private FileGenerator testFileGenerator;
  private FileGenerator testFileGenerator2;
  String filepath = new File("").getAbsolutePath();
  String emailTemplateFilePath = filepath + "/src/main/java/inputFiles/email-template.txt";
  String csvFilePath = filepath + "/src/main/java/inputFiles/insurance-company-members.csv";
  String csvFilePath2 = filepath + "/src/main/java/inputFiles/insurance-company-members3.csv";
  String outputFilePath = filepath + "/src/main/java/outputFiles";

  @BeforeEach
  void setUp() {

    testFileGenerator = new FileGenerator(csvFilePath, emailTemplateFilePath, outputFilePath);
    testFileGenerator2 = new FileGenerator(csvFilePath2, emailTemplateFilePath, outputFilePath);
  }

  @Test
  void createFileName() {
    testFileGenerator.parseCsv(csvFilePath);
    testFileGenerator2.parseCsv(csvFilePath2);
    assertEquals("first_name_last_name_0.txt", testFileGenerator.createFileName(0));
    assertEquals("file_0.txt", testFileGenerator2.createFileName(0));
  }

}