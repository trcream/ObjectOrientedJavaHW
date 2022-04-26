package problem1.Functionality;

import problem1.Todo;

public class AddTodo extends Functionality<Todo> {

  public AddTodo(String key) {
    super(key);
  }

  public void call(Todo newTodo) {
    System.out.println("Adding Todo");
  }

}
