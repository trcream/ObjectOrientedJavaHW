package problem1;

import java.time.LocalDate;

public class Todo {
  public Integer DEFAULT_PRIORITY = 3;

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
    if (priority != null) {
      this.priority = priority;
    } else {
      this.priority = this.DEFAULT_PRIORITY;
    }
    this.category = category;
  }

  public void setCompleted(Boolean completed) {
    this.completed = completed;
  }

  public Integer getId() {
    return id;
  }

  public String getText() {
    return text;
  }

  public Boolean getCompleted() {
    return completed;
  }

  public LocalDate getDueDate() {
    return dueDate;
  }

  public Integer getPriority() {
    return priority;
  }

  public String getCategory() {
    return category;
  }

  @Override
  public String toString() {
    return "Todo{" +
        "id=" + id +
        ", text='" + text + '\'' +
        ", completed=" + completed +
        ", dueDate=" + dueDate +
        ", priority=" + priority +
        ", category='" + category + '\'' +
        '}';
  }
}