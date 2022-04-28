package problem1.Functionality;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import problem1.CSVParser;
import problem1.Todo;
import problem1.TodoList;

/**
 * Class that adds todos from the command line
 */
public class AddTodo  implements Functionality{
  public TodoList list;

  public AddTodo(TodoList list) {
    this.list = list;
  }

  public void run(HashMap<String, ArrayList<String>> arguments) {
//    String text = arguments.get("text").get(0);
//    String completed = arguments.get("completed").get(0);
//    String dueDate = arguments.get("due").get(0);
//    String priority = arguments.get("priority").get(0);
//    String category = arguments.get("category").get(0);
//
//    this.addNewToDo(text, completed,dueDate, priority, category);
  }

  /**
   * Method that takes in user input as strings, converts the string to the right data types, and then
   * adds the toDo to the system.
   * @param text - text as a string from the command line
   * @param completed - completed as a string from the command line
   * @param dueDate - dueDate as a string from the command line
   * @param priority - priority as a string from the command line
   * @param category - category as a string from the command line
   * @throws NullPointerException - thrown if the user input is null for the text field
   */
  public void addNewToDo(String text, String completed, String dueDate, String priority,
      String category){
    //Converting the data types from strings
    boolean completedConverted;
    DateTimeFormatter formatter;
    LocalDate dateConverted;
    int priorityConverted;
    formatter = DateTimeFormatter.ofPattern("M/d/yyyy");

    Integer counter = 1;

    // Data Validation
    if(completed != null){
      completedConverted = Boolean.parseBoolean(completed);
    }
    else{
      completedConverted = false;
    }
    if(dueDate !=null){
      dateConverted = LocalDate.parse(dueDate,formatter);
    }
    else{
      dateConverted = null;
    }
    if(priority != null){
      priorityConverted = Integer.parseInt(priority);
    }
    else{
      priorityConverted = 3;
    }
    //Counting to the end of the file
    for (Integer key : CSVParser.toDoList.keySet()) {
      counter++;
    }

    // Putting the parsed data into a Todo object
    Todo todo = new Todo(counter, text, completedConverted, dateConverted, priorityConverted, category);
    // Putting the todo object in the hashmap
    CSVParser.toDoList.put(counter, todo);

    //Only here to check the values of the updated - we can delete later
    for (Integer key : CSVParser.toDoList.keySet()) {
      System.out.println("Id: " + CSVParser.toDoList.get(key).id);
      System.out.println("Text: " +CSVParser.toDoList.get(key).text);
      System.out.println("Completed: " + CSVParser.toDoList.get(key).completed);
      System.out.println("Due Date: " + CSVParser.toDoList.get(key).dueDate);
      System.out.println("Priority: " +CSVParser.toDoList.get(key).priority);
      System.out.println("Category: " + CSVParser.toDoList.get(key).category + "\n");
    }
  }

  /**
   * Returns a string representation of the object.
   * @return a string representation of the object, encoded as a String.
   */
  @Override
  public String toString() {
    return "AddTodo{}";
  }
}