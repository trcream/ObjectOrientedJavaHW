package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileGeneratorTest {

  private FileGenerator testFileGenerator;
  private FileGenerator testFileGenerator2;

  String filePath = new File("").getAbsolutePath();

  String emailTemplateFilePath = filePath + "\\src\\main\\java\\inputFiles\\email-template.txt";
  String csvFilePath = filePath + "\\src\\main\\java\\inputFiles\\insurance-company-members.csv";
  String csvFilePath2 = filePath + "\\src\\main\\java\\inputFiles\\insurance-company-members3.csv";
  String outputFilePath = filePath + "\\src\\main\\java\\outputFiles";

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