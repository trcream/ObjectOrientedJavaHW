package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
    String CSV = "C:\\Users\\Arjun Patel\\IdeaProjects\\Team_repo_Repo6_Arjun_Matthew_Trenton\\Assignment8\\src\\main\\java\\problem1\\insurance-company-members.csv";
    String template = "C:\\Users\\Arjun Patel\\IdeaProjects\\Team_repo_Repo6_Arjun_Matthew_Trenton\\Assignment8\\src\\main\\java\\problem1\\letter-template.txt";
    String output = "C:\\Users\\Arjun Patel\\IdeaProjects\\Team_repo_Repo6_Arjun_Matthew_Trenton\\Assignment8\\src\\main\\java\\file";
    testLetterGenerator = new LetterGenerator(CSV,template,output);
//    testFileGenerator = new FileGenerator(CSV,template,output);
//    testFileGenerator.parseCsv(CSV);
//    testFileGenerator2 = new FileGenerator(CSV,template,output);
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
    assertEquals("",testFileGenerator.generateDefaultFileName(0));

  }

//  @Test
//  void createColumnIndices() {
      // This cannot return void
      // This should return an integer
//    assertEquals(0,testFileGenerator.createColumnIndices());
//
//  }

  @Test
  void parseCsv() {
    // This cannot be void. This needs to return an Array List
//    testLetterGenerator.parseCsv(CSV);
//
//    //assertEquals("",testFileGenerator2);
//
//    assertEquals(0,testLetterGenerator.writeFileContent(1,"zztest"));
//

  }

//  @Test
//  void writeFileContent() {
//    testFileGenerator.writeFileContent(0,CSV);
//    assertEquals("",testFileGenerator);
//
//  }

  @Test
  void generate() throws IOException {
    // This generates all the files
    testLetterGenerator.generate();

    // Test to see if length of CSV matches expected
    assertEquals(501, testLetterGenerator.informationFromCsv.size());

    //Test to see if files are generated
    assertEquals(1, testLetterGenerator.writeFileContent(1, "zztest"));
    assertEquals(1, testLetterGenerator.writeFileContent(500, "zztest2"));

    // Test to see if files are formatted correctly
    // This one should be generated as zztest2
    BufferedReader reader = new BufferedReader(new FileReader(
        "C:\\Users\\Arjun Patel\\IdeaProjects\\Team_repo_Repo6_Arjun_Matthew_Trenton\\Assignment8\\src\\main\\java\\file\\zztest2"));

    // This one you need to get the last file called Chauncey_Motley.txt
    BufferedReader reader2 = new BufferedReader(new FileReader(
        "C:\\Users\\Arjun Patel\\IdeaProjects\\Team_repo_Repo6_Arjun_Matthew_Trenton\\Assignment8\\src\\main\\java\\file\\Chauncey_Motley.txt"));
    String line;
    String line2;

    while (((line = reader.readLine()) != null) && ((line2 = reader2.readLine()) != null)) {
      assertEquals(line2, line);
    }
  }

  @Test
  void testCreateFileName() {
    assertEquals("file_0.txt",testFileGenerator.createFileName(0));
  }
}