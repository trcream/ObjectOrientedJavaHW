package problem1;

import java.time.LocalDateTime;

public class Todo {
  private Integer id;
  private String text;
  private Boolean completed;
  private LocalDateTime due;
  private Integer priority;
  private String category;

  public Todo(Integer id, String text, LocalDateTime due, Integer priority, String category) {
    this.id = id;
    this.text = text;
    this.due = due;
    this.priority = priority;
    this.category = category;
    this.completed = Boolean.FALSE;
  }

  public Todo(Integer id, String text, LocalDateTime due, Integer priority, String category, Boolean completed) {
    this.id = id;
    this.text = text;
    this.due = due;
    this.priority = priority;
    this.category = category;
    this.completed = completed;
  }

  public Todo(Integer id, String text) {
    this.id = id;
    this.text = text;
    // Change "3" to this.DEFAULT_PRIORITY
    this.priority = 3;
  }

  public Integer getId() {
    return this.id;
  }

  public String getText() {
    return this.text;
  }

  public LocalDateTime getDue() {
    return this.due;
  }

  public Integer getPriority() {
    return this.priority;
  }

  public String getCategory() {
    return this.category;
  }

  public Boolean getCompleted() {
    return this.completed;
  }

  public void setCompleted(Boolean completed) {
    this.completed = completed;
  }
}
