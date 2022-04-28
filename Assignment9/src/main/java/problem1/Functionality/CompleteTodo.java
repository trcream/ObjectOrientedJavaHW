package problem1.Functionality;

import java.util.ArrayList;
import java.util.HashMap;
import problem1.Todo;
import problem1.TodoList;

public class CompleteTodo implements Functionality {
  public TodoList list;

  public CompleteTodo(TodoList list) {
    this.list = list;
  }

  public void run(HashMap<String, ArrayList<String>> arguments){
//    this.list.getTodo(id).setCompleted(Boolean.TRUE);
  }
}
