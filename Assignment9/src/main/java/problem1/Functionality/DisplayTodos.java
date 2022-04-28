package problem1.Functionality;

import java.util.*;
import problem1.TodoList;

public class DisplayTodos implements Functionality{
  public TodoList list;

  public DisplayTodos(TodoList list) {
    this.list = list;
  }

  public void run(HashMap<String, ArrayList<String>> arguments) {
    Boolean showIncomplete = Boolean.FALSE;
    String showCategory = null;
    Boolean sortByDate = Boolean.FALSE;
    Boolean sortByPriority = Boolean.FALSE;

    if (arguments.containsKey("show-incomplete")){
      showIncomplete = Boolean.TRUE;
    }

    if (arguments.get("show-category") != null){
      showCategory = arguments.get("show-category").get(0);
    }

    if (arguments.containsKey("sort-by-date")) {
      sortByDate = Boolean.TRUE;
    }

    if (arguments.containsKey("sort-by-priority")) {
      sortByPriority = Boolean.TRUE;
    }

    this.list.display(showIncomplete, showCategory, sortByDate, sortByPriority);
  }
}
