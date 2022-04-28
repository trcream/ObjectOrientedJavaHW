package problem1.Functionality;

import java.util.ArrayList;
import java.util.HashMap;
import problem1.TodoList;
import problem1.CSVParser;

/**
 * This is the CompleteTodo class. This class runs the method completeToDo
 */
public class CompleteTodo implements Functionality {
  public TodoList list;

  public CompleteTodo(TodoList list) {
    this.list = list;
  }
  
  public void run(HashMap<String, ArrayList<String>> arguments){
  //  this.list.getTodo(id).setCompleted(Boolean.TRUE);
  }

  /**
   * @param ID: An Integer of the ID number for todo task
   */
  public void completeToDo(Integer ID) {
    Integer counter = 0;
    System.out.println("ITS RUNNING! " + CSVParser.toDoList.get(1).id);

    for (Integer key : CSVParser.toDoList.keySet()) {
      if (CSVParser.toDoList.get(key).id == ID) {
        System.out.println("Completed: " + CSVParser.toDoList.get(key).text);
        CSVParser.toDoList.get(key).completed = true;
      }
    }
  }
}
