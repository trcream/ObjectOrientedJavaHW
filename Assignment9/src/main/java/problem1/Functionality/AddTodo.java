package problem1.Functionality;

import java.util.ArrayList;
import java.util.HashMap;
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
   * Returns a string representation of the object.
   * @return a string representation of the object, encoded as a String.
   */
  @Override
  public String toString() {
    return "AddTodo{}";
  }
}