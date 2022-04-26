package problem1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CsvParser {
  String pathToFile;
  ArrayList<ArrayList<String>> data = new ArrayList<>();
  HashMap<String, Integer> columnIndices = new HashMap<>();

  /**
   *
   * @param pathToFile
   */
  public CsvParser(String pathToFile){
    this.pathToFile = pathToFile;

    this.parse();
  }

  void parse() {
    try{
      BufferedReader reader = new BufferedReader(new FileReader(this.pathToFile));
      String line;
      while ((line = reader.readLine()) != null) {
        ArrayList<String> csvRow = new ArrayList<>(Arrays.asList(line.split("\"*,*\"")));
        this.data.add(csvRow);
      }
      reader.close();
      this.createColumnIndices();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Helper method to create column indices with key values that match the csv headers
   */
  private void createColumnIndices() {
    for (int i = 0; i < this.data.get(0).size(); i++ ){
      String key = this.data.get(0).get(i);
      if (!key.equals("")) {
        Integer value = i;
        this.columnIndices.put(key, value);
      }
    }
  }

  public ArrayList<ArrayList<String>> getData() {
    return this.data;
  }
}
