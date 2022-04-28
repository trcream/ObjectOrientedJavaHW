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

    // Filter based on display options given
    // Combining show
    todos.removeIf(todo ->
        (incompleteOnly == Boolean.TRUE && todo.getCompleted() == Boolean.TRUE) ||
            (categoryFilter != null && !todo.getCategory().equals(categoryFilter))
    );

    if (sortByDate == Boolean.TRUE) {
      todos.sort((todo1, todo2) -> {
        if(todo1.getDueDate()==null && todo2.getDueDate()==null) {
          return 0;
        }
        else if(todo1.getDueDate() == null){
          return 1;
        }
        else if(todo2.getDueDate() == null){
          return -1;
        }
        else{
          return todo1.getDueDate().compareTo(todo2.getDueDate()) ;
        }
      });
    }

    if (sortByPriority == Boolean.TRUE) {
      todos.sort((todo1, todo2) -> todo1.getPriority().compareTo(
          todo2.getPriority()));
    }

    for (Todo todo: todos) {
      System.out.println(todo.toString());
    }
  }
}
