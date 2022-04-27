package problem1.Functionality;

import java.util.*;
import problem1.CSVParser;
import problem1.Todo;

public class DisplayTodo implements Functionality<ArrayList<String>> {



  public void displayToDo() {
    Integer counter = 0;
    while (true) {
      if (CSVParser.getToDoList().get(counter) != null) {
        System.out.println(CSVParser.getToDoList().get(counter));
      }
    }
  }

  public void showIncomplete() {
   Integer counter = 0;
   while (true) {
    if (CSVParser.getToDoList().get(counter).completed == false) {
      System.out.println(CSVParser.getToDoList().get(counter));
    }
   }
  }

  public void sortByDate() {
    Integer counter = 0;
    while (true) {
      if (CSVParser.getToDoList().get(counter).completed == false) {
        System.out.println(CSVParser.getToDoList().get(counter));
      }
    }
  }

  public void sortByPriority() {
    Integer counter = 0;
    while (true) {
      if (CSVParser.getToDoList().get(counter).completed == false) {
        System.out.println(CSVParser.getToDoList().get(counter));
      }
    }
  }





}
