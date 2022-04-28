package problem1;

import java.util.*;

public class TodoList {
  private HashMap<Integer, Todo> list;

  public TodoList() {
    this.list = new HashMap();
  }

  public TodoList(HashMap<Integer, Todo> list) {
    this.list = list;
  }

  public void add(Todo newTodo){
    this.list.put(newTodo.id, newTodo);
  }

  public Integer getSize() {
    return this.list.size();
  }

  public ArrayList<Todo> getList() {
    return new ArrayList(this.list.values());
  }

  public Todo getTodo(Integer id){
    return this.list.get(id);
  }

  public void display(Boolean incompleteOnly, String categoryFilter, Boolean sortByDate, Boolean sortByPriority){
    ArrayList<Todo> todos = new ArrayList(this.list.values());

    // Filter
    // Sort

    for (Todo todo: todos) {
      System.out.println(todo.toString());
    }
  }
}
