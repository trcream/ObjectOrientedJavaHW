package problem1.Functionality;
import problem1.CSVParser;
import problem1.Todo;

public class AddTodo {

  public static void addNewToDo(String text, String completed, String dueDate, String priority,
      String category) {

    //Default null

    Integer counter = 1;

    for (Integer key : CSVParser.toDoList.keySet()) {
      System.out.println(CSVParser.toDoList.get(key).text);
      counter++;
    }

    Todo todo = new Todo(counter, text, completed, dueDate, priority, category);
    CSVParser.toDoList.put(counter, todo);

  }
}