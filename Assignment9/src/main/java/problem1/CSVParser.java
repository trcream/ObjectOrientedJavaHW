package problem1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Class to parse data from the CSV
 */
public class CSVParser {

  public String csv;
  public String outputDirPath;
  public static HashMap<Integer, Todo> toDoList = new HashMap<>();

  /**
   * Constructor for the CSV parser class
   * @param csv - csv file parse the data from
   * @param outputDirPath -
   */
  public CSVParser(String csv, String outputDirPath) {
    this.csv = csv;
    this.outputDirPath = outputDirPath;
  }

  /**
   * Returns the getToDoList hashmap
   * @return - the getToDoList hashmap
   */
  public static HashMap<Integer, Todo> getToDoList() {
    return toDoList;
  }

  /**
   * Returns the csv file path
   * @return - the csv file path
   */
  public String getCsv() {
    return this.csv;
  }

  /**
   * Returns the output directory file path
   * @return - the output directory file path
   */
  public String getOutputDirPath() {
    return this.outputDirPath;
  }


  /**
   * Method to parse the data from the csv into a hashmap to be used in the rest of the program
   * @param fileLocation - csv file location to be parsed
   * @throws NullPointerException - Exception that is thrown if a text input is null
   */
  public static void parseCsv(String fileLocation) throws NullPointerException{
    try{
      BufferedReader reader = new BufferedReader(new FileReader(fileLocation));
      String line;
      int counter = 0;
      while ((line = reader.readLine()) != null) {
        String text;
        LocalDate dueDate;
        int priority;
        String category;
        boolean completed;
        ArrayList<String> csvRow =  new ArrayList<>(Arrays.asList(line.split("\"+,*\"")));

        //Skipping the first row
        if(counter >0) {
          Integer id = Integer.valueOf(csvRow.get(1).replaceAll("\"", ""));

          //Exception is thrown if a null input is provided for the text field
          if(csvRow.get(2).contains("?")){
            throw new NullPointerException("This text value cannot be null!");

          }
          else {
             text = csvRow.get(2).replaceAll("\"", "");
          }

          if(csvRow.get(3).contains("?")){
             completed = false;
          }
          else {
            completed = Boolean.parseBoolean(csvRow.get(3).replaceAll("\"", ""));
          }

          if(csvRow.get(4).contains("?")){
            dueDate = null;
          }
          else {DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
           dueDate = LocalDate.parse(csvRow.get(4).replaceAll("\"", ""),formatter);
          }
          // Priority value defaults to 3 if none is provided
          if(csvRow.get(5).contains("?")) {
            priority= 3;
          }
          else
            priority = Integer.parseInt(
                csvRow.get(5).replaceAll("\"", "").replaceAll("[^a-zA-Z0-9]", "3"));

          category = csvRow.get(6).replaceAll("\"","").replaceAll("[^a-zA-Z0-9]", "");


          Todo todo = new Todo(id, text, completed, dueDate, priority, category);
          toDoList.put(counter, todo);
        }
        counter++;
      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Returns whether some other object is "equal to" this one.
   * @param o - The object we are comparing to.
   * @return whether some other object is "equal to" this one, encoded as a Boolean.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CSVParser csvParser = (CSVParser) o;
    return Objects.equals(this.csv, csvParser.csv) && Objects.equals(this.outputDirPath,
        csvParser.outputDirPath);
  }

  /**
   * Method to determine if the hashcode of the object is a match
   * @return - a hashcode value for the object returned as an integer
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.csv, this.outputDirPath);
  }

  /**
   * Returns a string representation of the object.
   * @return a string representation of the object, encoded as a String.
   */
  @Override
  public String toString() {
    return "CSVParser{" +
        "csv='" + this.csv + '\'' +
        ", outputDirPath='" + this.outputDirPath + '\'' +
        '}';
  }
}
