package problem1.Functionality;
import java.util.HashMap;
import problem1.Todo;

public class AddTodo implements Functionality<Todo> {
  public String pathToCsv;
  public HashMap<String, Todo> todos;

  public AddTodo(String pathToCsv, HashMap<String, Todo> todos) {
    this.pathToCsv = pathToCsv;
    this.todos = todos;
  }

  public void call(Todo newTodo) {
    System.out.println("Adding Todo");
  }
}