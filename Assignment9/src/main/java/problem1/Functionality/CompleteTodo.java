package problem1.Functionality;

public class CompleteTodo extends Functionality<Integer> {

  public CompleteTodo(String key) {
    super(key);
  }

  public void call(Integer id) {
    System.out.println("Completing Todo");
  }

}
