package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LetterGeneratorTest {
  private LetterGenerator testLetterGenerator;
  private FileGenerator testFileGenerator;
  private String CSV;
  private FileGenerator testLetterGenerator2;
  private String template;
  private String output;

  @BeforeEach
  void setUp() {
    // Type in your file locations here
    String filepath = new File("").getAbsolutePath();
    String CSV = filepath + "\\src\\main\\java\\inputFiles\\insurance-company-members.csv";
    String template = filepath + "\\src\\main\\java\\inputFiles\\letter-template.txt";
    String output = filepath + "\\src\\test\\java\\testFiles";
    testLetterGenerator = new LetterGenerator(CSV,template,output);

  }

  @Test
  void getCsv() {
    String filepath = new File("").getAbsolutePath();
    assertEquals(filepath + "\\src\\main\\java\\inputFiles\\insurance-company-members.csv",testLetterGenerator.getCsv());

  }

  @Test
  void getTemplate() {
    String filepath = new File("").getAbsolutePath();
    assertEquals(filepath + "\\src\\main\\java\\inputFiles\\letter-template.txt",testLetterGenerator.getTemplate());

  }

  @Test
  void getOutputDirPath() {
    String filepath = new File("").getAbsolutePath();
    assertEquals(filepath + "\\src\\test\\java\\testFiles",testLetterGenerator.getOutputDirPath());

  }

  @Test
  void getInformationFromCsv() {
    testLetterGenerator.parseCsv(CSV);
    testLetterGenerator.getInformationFromCsv();

  }

  @Test
  void getColumnIndices() {
    testLetterGenerator.getColumnIndices();

  }


  @Test
  void createFileName() {
    testLetterGenerator.parseCsv(CSV);
    assertEquals("first_name_last_name_letter.txt",testLetterGenerator.createFileName(0));
    assertEquals("James, Jacob_Butt_letter.txt",testLetterGenerator.createFileName(1));

  }

  @Test
  void generateDefaultFileName() {
    testLetterGenerator.parseCsv(CSV);
    //assertEquals("",testFileGenerator.generateDefaultFileName(1));

  }

  @Test
  void createColumnIndices() {
    testLetterGenerator.parseCsv(CSV);
    testLetterGenerator.createColumnIndices();

  }

  @Test
  void parseCsv() {

  }

  @Test
  void writeFileContent() {
    testLetterGenerator.parseCsv(CSV);

  }



  @Test
  void generate() throws IOException {
    String filepath = new File("").getAbsolutePath();
    // This generates all the files
    testLetterGenerator.generate();

    // Test to see if length of CSV matches expected
    assertEquals(501, testLetterGenerator.informationFromCsv.size());

    // Generate Files
    testLetterGenerator.writeFileContent(1, "zztest.txt");
    testLetterGenerator.writeFileContent(500, "zztest2.txt");


    // Test to see if files are formatted correctly
    // This one should be generated as zztest2 and compare it to the example file
    BufferedReader reader = new BufferedReader(new FileReader(filepath + "\\src\\test\\java\\testFiles\\zztest2.txt"));

    // This is reading the example file
    BufferedReader reader2 = new BufferedReader(new FileReader(
        filepath + "\\src\\test\\java\\testFiles\\zzexampleFile.txt"));
    String line;
    String line2;

    while (((line = reader.readLine()) != null) && ((line2 = reader2.readLine()) != null)) {
      // Expected = example file
      // Actual = output
      assertEquals(line2, line);
    }




  }

  @Test
  void testCreateFileName() {
//    testLetterGenerator.parseCsv(CSV);
//    testFileGenerator.createFileName(1);
  }






}