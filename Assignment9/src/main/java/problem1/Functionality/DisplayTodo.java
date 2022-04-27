package problem1.Functionality;

import java.util.*;
import problem1.CSVParser;
import problem1.Todo;

public class DisplayTodo {

  public void displayToDo() {
    Integer counter = 0;
    System.out.println("Printing from Display ToDo " + CSVParser.toDoList.get(1).id);

    for(Integer key: CSVParser.toDoList.keySet()){
      System.out.println(CSVParser.toDoList.get(key).text);
    }

//    while (true) {
//      System.out.println(CSVParser.getToDoList().get(counter));
//      if (CSVParser.getToDoList().get(counter) != null) {
////        System.out.println(counter);
//        System.out.println("Printing from Display ToDo" + CSVParser.toDoList.get(5).text);
//        counter ++;
//      }
//      break;
//    }
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
