package problem1.Functionality;

public class CompleteTodo implements Functionality<String> {
  public void call(String id) {
    System.out.println("Completing Todo");
  }
}
