package problem1;

import java.time.LocalDate;

public class Todo {

  public Integer id;
  public String text;
  public Boolean completed;
  public LocalDate dueDate;
  public Integer priority;
  public String category;

  public Todo(Integer id, String text, Boolean completed, LocalDate dueDate,
      Integer priority, String category) {
    this.id = id;
    this.text = text;
    this.completed = completed;
    this.dueDate = dueDate;
    this.priority = priority;
    this.category = category;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setText(String text) {
    this.text = text;
  }

  public void setCompleted(Boolean completed) {
    this.completed = completed;
  }

  public void setDueDate(LocalDate dueDate) {
    this.dueDate = dueDate;
  }

  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  public void setCategory(String category) {
    this.category = category;
  }
}



//  public Todo(Integer id, String text, LocalDateTime due, Integer priority, String category) {
//    this.id = id;
//    this.text = text;
//    this.due = due;
//    this.priority = priority;
//    this.category = category;
//    this.completed = Boolean.FALSE;
//  }
//
//  public Todo(Integer id, String text, LocalDateTime due, Integer priority, String category, Boolean completed) {
//    this.id = id;
//    this.text = text;
//    this.due = due;
//    this.priority = priority;
//    this.category = category;
//    this.completed = completed;
//  }


