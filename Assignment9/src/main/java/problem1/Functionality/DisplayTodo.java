package problem1.Functionality;

import java.util.*;
import problem1.Todo;

public class DisplayTodo implements Functionality<HashMap<String, Todo>> {
  public void call(HashMap<String, Todo> todos) {
    System.out.println("Display Todo list");
  }
}
