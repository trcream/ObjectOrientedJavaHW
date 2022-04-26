package problem1.Functionality;
import problem1.Todo;

public class AddTodo implements Functionality<Todo> {

  public AddTodo(String csv, String outputDirPath) {
  }

  public void call(Todo newTodo) {
    System.out.println("Adding Todo");
  }
}