package problem1.Functionality;

import java.util.*;
import problem1.Todo;

public class DisplayTodo implements Functionality<ArrayList<String>> {
  public HashMap<String, Todo> todos;

  public DisplayTodo(HashMap<String, Todo> todos) {
    this.todos = todos;
  }

  public void call(ArrayList<String> displayOptions) {
    System.out.println("Display Todo list");
  }
}
