package problem1;

<<<<<<< HEAD
import java.io.File;
=======

>>>>>>> main
public class Main {
  /**
   * Main method for running program and handling arguments from the user
   * @param args - arguments provided by the user
   */
  public static void main(String[] args) {
<<<<<<< HEAD
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
=======
//     TodoApp app = new TodoApp();
//     String[] testArgs = {"--csv-file", "path/to/file","--add-todo", "--todo-text", "Test todo", "--todo-text", "Test todo 2", "--priority", "3"};
//     app.run(testArgs);

    CSVParser testCSVParser = new CSVParser("C:\\Users\\trent\\Desktop\\Masters Programs\\Northeastern\\CS5004\\GroupProject\\Team_repo_Repo6_Arjun_Matthew_Trenton\\Assignment9\\src\\main\\java\\problem1\\todos.csv", "");
    testCSVParser.parseCsv("C:\\Users\\trent\\Desktop\\Masters Programs\\Northeastern\\CS5004\\GroupProject\\Team_repo_Repo6_Arjun_Matthew_Trenton\\Assignment9\\src\\main\\java\\problem1\\todos.csv");
    //System.out.println("Printing from main " + testCSVParser.toDoList.get(5).text);
    DisplayTodo testDisplay = new DisplayTodo();
    testDisplay.displayToDo();

>>>>>>> main
  }
}
