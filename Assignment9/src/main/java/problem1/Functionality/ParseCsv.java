package problem1.Functionality;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import problem1.Todo;

public class ParseCsv implements Functionality<String> {
  public String csv;
  public String outputDirPath;

  HashMap<Integer, Todo> toDoList = new HashMap<>();
  ArrayList<ArrayList<String>> informationFromCsv = new ArrayList<>();

  public ParseCsv(String key, String csv, String outputDirPath) {

    this.csv = csv;
    this.outputDirPath = outputDirPath;
  }

  public void testMethod(){
    System.out.println("Test Method");

  }

  /**
   * Method to parse csv data into an array list
   * @param fileLocation -csv file to be parsed
   */
  public void call(String fileLocation){
    System.out.println("Parse CSV Method");

    try{
      BufferedReader reader = new BufferedReader(new FileReader(this.csv));
      String line;
      int i = 1;
      while ((line = reader.readLine()) != null) {
        //System.out.println("Parse While Loop");
        ArrayList<String> csvRow = new ArrayList<>(Arrays.asList(line.split("\"*,*\"")));
        System.out.println(csvRow.get(4));

//        String text = csvRow.get(1);
//        System.out.println(text);
        //Boolean completed = Boolean.valueOf(csvRow.get(2));
        //LocalDate dueDate = LocalDate.parse(csvRow.get(3));
        //Integer priority = Integer.valueOf(csvRow.get(4));
        //String category = csvRow.get(5);


        // ToDo todo = new ToDo(i, text, completed, dueDate, priority, category);
        Todo todo = new Todo(i, "test", true, LocalDate.now(), 1, "testing");
        toDoList.put(i, todo);

        i++;
      }
      reader.close();
      //this.createColumnIndices();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
