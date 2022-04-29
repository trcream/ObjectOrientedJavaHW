package problem1.Functionality;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WriteCsvTest {
  WriteCsv testWriteCsv;
  String filePath = new File("").getAbsolutePath();
  String testCsvFilePath = filePath + "/src/main/java/problem1/todos.csv";

  @Test
  void constructor() {
    testWriteCsv = new WriteCsv(testCsvFilePath);
    assertEquals(testWriteCsv.csv.pathToFile, testCsvFilePath);
  }
}