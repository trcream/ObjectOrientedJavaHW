package problem1.Functionality;
import problem1.Todo;

public class AddTodo extends Functionality {

  public AddTodo(String csv, String outputDirPath) {
    super(csv, outputDirPath);
  }

  public void call(Todo newTodo) {
    System.out.println("Adding Todo");
  }

}
