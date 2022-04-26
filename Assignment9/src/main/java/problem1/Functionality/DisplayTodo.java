package problem1.Functionality;

import java.util.*;

public class DisplayTodo extends Functionality<HashMap<String, ArrayList<String>>> {

  public DisplayTodo(String key) {
    super(key);
  }

  public void call(HashMap<String, ArrayList<String>> displayOptions) {
    System.out.println("Display Todo list");
  }
}
