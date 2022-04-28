package problem1;

import java.io.File;
public class Main {
  /**
   * Main method for running program and handling arguments from the user
   * @param args - arguments provided by the user
   */
  public static void main(String[] args) {
    TodoApp app = new TodoApp();

    String filePath = new File("").getAbsolutePath();
    String testCsv = filePath + "/src/main/java/problem1/todos.csv";

    String[] testArgs = {
        "--csv-file", testCsv,
        "--add-todo",
        "--todo-text", "Test todo",
        "--completed",
        "--due", "3/21/2022",
        "--priority", "2",
        "--display",
        "--show-incomplete",
        "--show-category", "home",
        "--sort-by-date",
        "--complete-todo", "2",
        "--complete-todo", "3"
    };
    app.run(testArgs);

    System.out.println("Next test");

    String[] test2Args = {
        "--csv-file", testCsv,
        "--add-todo",
        "--todo-text", "Test todo",
        "--completed",
        "--due", "3/21/2022",
        "--priority", "2",
        "--display"
    };
    app.run(test2Args);

    //  TODO: REMOVE TESTS ABOVE AND UNCOMMENT BELOW
    // app.run(args);
  }
}
