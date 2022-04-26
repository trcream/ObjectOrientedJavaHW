package problem1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CSVParser {

  public String csv;
  public String outputDirPath;
  public static HashMap<Integer, Todo> toDoList = new HashMap<>();

  ArrayList<ArrayList<String>> informationFromCsv = new ArrayList<>();

  public CSVParser(String csv, String outputDirPath) {
    this.csv = csv;
    this.outputDirPath = outputDirPath;
  }

  public static HashMap<Integer, Todo> getToDoList() {
    return toDoList;
  }

  public String getCsv() {
    return csv;
  }

  public String getOutputDirPath() {
    return outputDirPath;
  }

  /**
   * Method to parse csv data into an array list
   * @param fileLocation -csv file to be parsed
   */
  public static void parseCsv(String fileLocation){
    //public HashMap<Todo> parseCsv(String fileLocation){
    System.out.println("Parse CSV Method");

    try{
      BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\trent\\Desktop\\Masters Programs\\Northeastern\\CS5004\\GroupProject\\Team_repo_Repo6_Arjun_Matthew_Trenton\\Assignment9\\src\\main\\java\\problem1\\todos.csv"));
      String line;
      int counter = 1;
      while ((line = reader.readLine()) != null) {
        LocalDate dueDate;
        Integer priority;
        String category;
        ArrayList<String> csvRow =  new ArrayList<>(Arrays.asList(line.split("\"+,*\"")));

        //Skipping the first row
        if(counter >1) {


          Integer id = Integer.valueOf(csvRow.get(1).replaceAll("\"", ""));
          //System.out.println("Column 1: " + csvRow.get(1).replaceAll("\"",""));

          String text = csvRow.get(2).replaceAll("\"", "");
          //System.out.println("Column 2: " + csvRow.get(2).replaceAll("\"",""));

          Boolean completed = Boolean.valueOf(csvRow.get(3).replaceAll("\"", ""));
          //System.out.println("Column 3: " + csvRow.get(3).replaceAll("\"",""));


          if(csvRow.get(4).contains("?")){
            dueDate = null;
          }
          else {DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
           dueDate = LocalDate.parse(csvRow.get(4).replaceAll("\"", ""),formatter);

            //LocalDate dueDate = LocalDate.of(csvRow.get(4));
            System.out.println("Column 4: " + csvRow.get(4).replaceAll("\"", ""));
          }

          if(csvRow.get(5).contains("?")) {
            priority= null;
          }
          else {
            priority = Integer.valueOf(
                csvRow.get(5).replaceAll("\"", "").replaceAll("[^a-zA-Z0-9]", ""));
            //System.out.println("Column 5: " + csvRow.get(5).replaceAll("\"","").replaceAll("[^a-zA-Z0-9]", ""));
          }

          category = csvRow.get(6).replaceAll("\"","").replaceAll("[^a-zA-Z0-9]", "");
          //System.out.println("Column 6: " + csvRow.get(6).replaceAll("\"","").replaceAll("[^a-zA-Z0-9]", ""));

          

          Todo todo = new Todo(id, text, completed, dueDate, priority, category);
          //Todo todo = new Todo(counter, "test", true, LocalDate.now(), 1, "testing");

          toDoList.put(counter, todo);
          counter++;
        }
        else {
          counter++;
        }
      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
