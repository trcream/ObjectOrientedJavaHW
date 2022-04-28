package problem1.Functionality;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import problem1.Csv;
import problem1.Todo;
import problem1.TodoList;

public class ParseCsv{
  public String pathToFile;
  public Csv csv;

  public ParseCsv(String pathToFile){
    this.pathToFile = pathToFile;
    this.csv = new Csv(pathToFile);
  }

  public TodoList createTodoList(){
    TodoList list = new TodoList();

    if (this.csv != null) {
      ArrayList<ArrayList<String>> data = this.csv.getData();
      for (int i = 1; i < data.size() ; i++) {
        String text = this.csv.getValue(i, "text");
        Boolean completed = Boolean.parseBoolean(this.csv.getValue(i, "completed"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");

        String rawDueDateValue = this.csv.getValue(i, "due");
        LocalDate due =
            rawDueDateValue != null ? LocalDate.parse(rawDueDateValue, formatter) : null;
        String rawPriorityValue = this.csv.getValue(i, "priority");
        Integer priority = rawPriorityValue != null ? Integer.parseInt(rawPriorityValue) : null;
        String category = this.csv.getValue(i, "category");

        Todo newTodo = new Todo(i, text, completed, due, priority, category);
        list.add(newTodo);
      }
    }

    return list;
  }

  public String getPathToFile() {
    return this.pathToFile;
  }

  public Csv getCsv() {
    return this.csv;
  }
}