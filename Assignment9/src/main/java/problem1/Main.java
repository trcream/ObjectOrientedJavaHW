package problem1;

public class Main {
  /**
   * Main method for running program and handling arguments from the user
   * @param args - arguments provided by the user
   */
  public static void main(String[] args) {
     TodoApp app = new TodoApp();

     String[] testArgs = {"--csv-file", "path/to/file","--add-todo", "--todo-text", "Test todo", "--todo-text", "Test todo 2", "--priority", "3"};
     app.run(testArgs);
  }
}
