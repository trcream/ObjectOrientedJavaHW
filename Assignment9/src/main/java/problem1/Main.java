package problem1;

import problem1.Functionality.DisplayTodo;

public class Main {
  /**
   * Main method for running program and handling arguments from the user
   * @param args - arguments provided by the user
   */
  public static void main(String[] args) {
//     TodoApp app = new TodoApp();
//     String[] testArgs = {"--csv-file", "path/to/file","--add-todo", "--todo-text", "Test todo", "--todo-text", "Test todo 2", "--priority", "3"};
//     app.run(testArgs);

    CSVParser testCSVParser = new CSVParser("C:\\Users\\trent\\Desktop\\Masters Programs\\Northeastern\\CS5004\\GroupProject\\Team_repo_Repo6_Arjun_Matthew_Trenton\\Assignment9\\src\\main\\java\\problem1\\todos.csv", "");
    testCSVParser.parseCsv("C:\\Users\\trent\\Desktop\\Masters Programs\\Northeastern\\CS5004\\GroupProject\\Team_repo_Repo6_Arjun_Matthew_Trenton\\Assignment9\\src\\main\\java\\problem1\\todos.csv");
    //System.out.println("Printing from main " + testCSVParser.toDoList.get(5).text);
    DisplayTodo testDisplay = new DisplayTodo();
    testDisplay.displayToDo();

  }
}
