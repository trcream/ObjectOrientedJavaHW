package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmailGeneratorTest {

  private EmailGenerator testEmailGenerator;
  private EmailGenerator testEmailGenerator2;

  String emailTemplateFilePath = "C:\\Users\\trent\\Desktop\\Masters Programs\\Northeastern\\CS5004\\GroupProject\\Team_repo_Repo6_Arjun_Matthew_Trenton\\Assignment8\\src\\main\\java\\inputFiles\\email-template.txt";
  String csvFilePath = "C:\\Users\\trent\\Desktop\\Masters Programs\\Northeastern\\CS5004\\GroupProject\\Team_repo_Repo6_Arjun_Matthew_Trenton\\Assignment8\\src\\main\\java\\inputFiles\\insurance-company-members.csv";
  String csvFilePath2 = "C:\\Users\\trent\\Desktop\\Masters Programs\\Northeastern\\CS5004\\GroupProject\\Team_repo_Repo6_Arjun_Matthew_Trenton\\Assignment8\\src\\main\\java\\inputFiles\\insurance-company-members.csv";
  String outputFilePath = "C:\\Users\\trent\\Desktop\\Masters Programs\\Northeastern\\CS5004\\GroupProject\\Team_repo_Repo6_Arjun_Matthew_Trenton\\Assignment8\\src\\main\\java\\outputFiles";

  @BeforeEach
  void setUp() {

    testEmailGenerator = new EmailGenerator(csvFilePath, emailTemplateFilePath, outputFilePath);
    testEmailGenerator2 = new EmailGenerator(csvFilePath2, emailTemplateFilePath, outputFilePath);


  }

  @Test
  void testGetCsv() {
    assertEquals(csvFilePath, testEmailGenerator.getCsv());
  }

  @Test
  void testGetTemplate() {
    assertEquals(emailTemplateFilePath, testEmailGenerator.getTemplate());
  }

  @Test
  void testGetOutputDirPath() {
    assertEquals(outputFilePath, testEmailGenerator.getOutputDirPath());
  }

  @Test
  void testCreateFileName() {
    testEmailGenerator.parseCsv(csvFilePath);
     assertEquals("first_name_last_name_email.txt", testEmailGenerator.createFileName(0));

  }

  @Test
  void testGenerateDefaultFileName() {
    testEmailGenerator.parseCsv(csvFilePath);
    assertEquals("James, Jacob_Butt", testEmailGenerator.generateDefaultFileName(1));
  }

  @Test
  void testCreateColumnIndices() {
  }

  @Test
  void testParseCsv() {
    testEmailGenerator.parseCsv(csvFilePath);
    assertEquals(501, testEmailGenerator.informationFromCsv.size());

  }

  @Test
  void testWriteFileContent() {

  }

  @Test
  void testGenerate() {
    //Generate first!
  }

  @Test
  void CreateFileName() {
//    testEmailGenerator.parseCsv(csvFilePath);

  }

  @Test
  void testEquals() {
    assertTrue(testEmailGenerator.equals(testEmailGenerator));
    //assertFalse(testEmailGenerator.equals(testEmailGenerator2));
    assertFalse(testEmailGenerator.equals(null));

  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(testEmailGenerator.csv, testEmailGenerator.template, testEmailGenerator.outputDirPath, testEmailGenerator.informationFromCsv, testEmailGenerator.columnIndices);
    assertEquals(expectedHashCode, testEmailGenerator.hashCode());

  }

  @Test
  void testToString() {
    String expectedString = "FileGenerator{" +
        "csv='" + testEmailGenerator.getCsv() + '\'' +
        ", template='" + testEmailGenerator.getTemplate() + '\'' +
        ", outputDirPath='" + testEmailGenerator.getOutputDirPath() + '\'' +
        ", informationFromCsv=" + testEmailGenerator.getInformationFromCsv() +
        ", columnIndices=" + testEmailGenerator.getColumnIndices() +
        '}';

    assertEquals(expectedString, testEmailGenerator.toString());
  }
}