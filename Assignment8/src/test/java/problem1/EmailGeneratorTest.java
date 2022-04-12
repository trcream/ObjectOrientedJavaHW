package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmailGeneratorTest {

  private EmailGenerator testEmailGenerator;
  private EmailGenerator testEmailGenerator2;
  private EmailGenerator testEmailGenerator3;
  private EmailGenerator testEmailGenerator4;

  String filePath = new File("").getAbsolutePath();

  String emailTemplateFilePath = filePath + "\\src\\main\\java\\inputFiles\\email-template.txt";
  String emailTemplateFilePath2 = filePath + "\\src\\main\\java\\inputFiles\\email-template.txt2";
  String csvFilePath =  filePath + "\\src\\main\\java\\inputFiles\\insurance-company-members.csv";
  String csvFilePath2 = filePath + "\\src\\main\\java\\inputFiles\\insurance-company-members3.csv";
  String outputFilePath = filePath + "\\src\\main\\java\\outputFiles";
  String outputFilePath2 = filePath + "\\src\\main\\java\\outputFiles2";

  @BeforeEach
  void setUp() {

    testEmailGenerator = new EmailGenerator(csvFilePath, emailTemplateFilePath, outputFilePath);
    testEmailGenerator2 = new EmailGenerator(csvFilePath2, emailTemplateFilePath, outputFilePath);
    testEmailGenerator3 = new EmailGenerator(csvFilePath, emailTemplateFilePath2, outputFilePath);
    testEmailGenerator4 = new EmailGenerator(csvFilePath, emailTemplateFilePath, outputFilePath2);
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
    testEmailGenerator2.parseCsv(csvFilePath2);
    assertEquals("first_name_last_name_email_0.txt", testEmailGenerator.createFileName(0));
     assertEquals("email_0.txt", testEmailGenerator2.createFileName(0));
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
  }

  @Test
  void CreateFileName() {

    testEmailGenerator.parseCsv(csvFilePath);
    testEmailGenerator2.parseCsv(csvFilePath2);
    assertEquals("first_name_last_name_email_0.txt", testEmailGenerator.createFileName(0));
    assertEquals("email_0.txt", testEmailGenerator2.createFileName(0));


  }

  @Test
  void testEquals() {
    testEmailGenerator2.getInformationFromCsv();
    assertFalse(testEmailGenerator.equals(testEmailGenerator2));
    assertFalse(testEmailGenerator.equals(testEmailGenerator3));
    assertFalse(testEmailGenerator.equals(testEmailGenerator4));
    assertTrue(testEmailGenerator.equals(testEmailGenerator));
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