package problem1.Functionality;

import java.util.*;
import java.util.Map.Entry;
import problem1.CSVParser;
import problem1.Todo;

public class DisplayTodo {

  /**
   * displayToDo: This method displays all the current todos.
   */
  public void displayToDo() {
    for(Integer key: CSVParser.toDoList.keySet()){
      System.out.println(CSVParser.toDoList.get(key).dueDate);
    }
  }

  /**
   * showIncomplete: This method helps show all todos that are incomplete.
   */
  public void showIncomplete() {
    for (Integer key : CSVParser.toDoList.keySet()) {
      if (!CSVParser.toDoList.get(key).completed) {
        System.out.println(CSVParser.toDoList.get(key).text);
      }
    }
  }

  /**
   * Method to sort all todos by date in ascending order. If the date is null, then the todo is
   * listed after the todos with dates.
   */
  public void sortByDate() {
    System.out.println("sort Null Method");
    List<Map.Entry<Integer, Todo>> list = new ArrayList<>(CSVParser.toDoList.entrySet());
    Collections.sort(list, new Comparator<Entry<Integer, Todo>>() {
      @Override
      public int compare(Entry<Integer, Todo> o1, Entry<Integer, Todo> o2) {
        if(o1.getValue().getDueDate()==null && o2.getValue().getDueDate()==null) {
          return 0;
        }
        else if(o1.getValue().getDueDate() == null){
          return 1;
        }
        else if(o2.getValue().getDueDate() == null){
          return -1;
        }
        else{
          return o1.getValue().getDueDate().compareTo(o2.getValue().getDueDate()) ;
        }
      }
    });
    //Displaying the sorted values
    for(int i = 0; i <list.size(); i++){
      System.out.println(list.get(i).getValue().dueDate);
    }
  }

  /**
   * sortByPriority: This method sorts all todos by priority
   * Citation - https://www.youtube.com/watch?v=u8D2fydghj4
   */
  public void sortByPriority() {
    System.out.println("Sort by priority");

    //Collections.sort(CSVParser.toDoList, new PriorityComparator());
    List<Map.Entry<Integer, Todo>> list = new ArrayList<>(CSVParser.toDoList.entrySet());

    Collections.sort(list, new Comparator<Map.Entry<Integer, Todo>>() {
      @Override
      public int compare(Map.Entry<Integer, Todo> o1, Map.Entry<Integer, Todo> o2) {
        return o2.getValue().getPriority().compareTo(o1.getValue().getPriority());
      }
    });
    }
}
