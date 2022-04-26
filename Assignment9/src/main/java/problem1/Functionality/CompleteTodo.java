package problem1.Functionality;

import java.util.HashMap;
import problem1.Todo;

public class CompleteTodo implements Functionality<String> {
  public HashMap<String, Todo> todos;

  public CompleteTodo(HashMap<String, Todo> todos) {
    this.todos = todos;
  }

  public void call(String id) {
    System.out.println("Completing Todo");
  }
}
