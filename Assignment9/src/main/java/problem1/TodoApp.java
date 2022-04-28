package problem1;

import java.util.*;
import problem1.CommandLine.CommandLineParser;
import problem1.CommandLine.FlagParserArgument;
import problem1.CommandLine.InvalidArgumentsException;
import problem1.CommandLine.NamedParserArgument;
import problem1.CommandLine.ParserArgument;

import problem1.Functionality.AddTodo;
import problem1.Functionality.CompleteTodo;
import problem1.Functionality.DisplayTodos;
import problem1.Functionality.ParseCsv;
import problem1.Functionality.WriteCsv;

public class TodoApp{
  CommandLineParser commandLineParser;
  ArrayList<ParserArgument> arguments = new ArrayList();
  Csv cachedCsv;
  TodoList todoList;

  // Functionalities
  ParseCsv parseCsv;
  AddTodo addTodo;
  CompleteTodo completeTodo;
  DisplayTodos displayTodos;
  WriteCsv writeCsv;

  public TodoApp() {
    NamedParserArgument csvFilePathArgument =
        new NamedParserArgument("csv-file",
            "The CSV file containing the todos. This option is required.",
            "path/to/file",
            Boolean.TRUE);
    this.arguments.add(csvFilePathArgument);

    FlagParserArgument addToDoArgument =
        new FlagParserArgument("add-todo",
            "Add a new todo. If this option is provided, then --todo-text must also be provided.",
            Boolean.FALSE,
            new ArrayList(Arrays.asList("todo-text")),
            new ArrayList());
    this.arguments.add(addToDoArgument);

    NamedParserArgument toDoTextArgument =
        new NamedParserArgument("todo-text",
            "A description of the todo.",
            "description of todo",
            Boolean.FALSE,
            Boolean.FALSE,
            new ArrayList(Arrays.asList("add-todo")),
            new ArrayList());
    this.arguments.add(toDoTextArgument);

    FlagParserArgument completedArgument =
        new FlagParserArgument("completed",
            "Sets the completed status of a new todo to true.",
            Boolean.FALSE,
            new ArrayList(Arrays.asList("add-todo")),
            new ArrayList());
    this.arguments.add(completedArgument);

    NamedParserArgument dueDateArgument =
        new NamedParserArgument("due",
            "Sets the due date of a new todo. You may choose how the date should be formatted.",
            "due date",
            Boolean.FALSE,
            Boolean.FALSE,
            new ArrayList(Arrays.asList("add-todo")),
            new ArrayList()
            );
    this.arguments.add(dueDateArgument);

    NamedParserArgument priorityArgument =
        new NamedParserArgument("priority",
            "Mark the Todo with the provided ID as complete.",
            "1, 2, or 3",
            Boolean.FALSE,
            Boolean.FALSE,
            new ArrayList(Arrays.asList("add-todo")),
            new ArrayList(),
            new HashSet(Arrays.asList("1","2","3")));
    this.arguments.add(priorityArgument);

    NamedParserArgument categoryArgument =
        new NamedParserArgument("category",
            "Sets the category of a new todo. The value can be any String. Categories do not need to be pre-defined.",
            "a category name",
            Boolean.FALSE,
            Boolean.FALSE,
            new ArrayList(Arrays.asList("add-todo")),
            new ArrayList());
    this.arguments.add(categoryArgument);

    NamedParserArgument completeTodoArgument =
        new NamedParserArgument("complete-todo",
            "Mark the Todo with the provided ID as complete.",
            "id",
            Boolean.FALSE,
            Boolean.TRUE);
    this.arguments.add(completeTodoArgument);

    FlagParserArgument displayArgument =
        new FlagParserArgument("display",
            "Display todos. If none of the following optional arguments are provided, displays all todos.",
            Boolean.FALSE);
    this.arguments.add(displayArgument);

    FlagParserArgument showIncompleteArgument =
        new FlagParserArgument("show-incomplete",
            "If --display is provided, only incomplete todos should be displayed.",
            Boolean.FALSE,
            new ArrayList(Arrays.asList("display")),
            new ArrayList());
    this.arguments.add(showIncompleteArgument);

    NamedParserArgument showCategoryArgument =
        new NamedParserArgument("show-category",
            "If --display is provided, only todos with the given category should be displayed.",
            "category",
            Boolean.FALSE,
            Boolean.FALSE,
            new ArrayList(Arrays.asList("display")),
            new ArrayList());
    this.arguments.add(showCategoryArgument);

    FlagParserArgument sortByDateArgument =
        new FlagParserArgument("sort-by-date",
            "If --display is provided, sort the list of todos by date order (ascending). Cannot be combined with --sort-by-priority.",
            Boolean.FALSE,
            new ArrayList(Arrays.asList("display")),
            new ArrayList(Arrays.asList("sort-by-priority")));
    this.arguments.add(sortByDateArgument);

    FlagParserArgument sortByPriorityArgument =
        new FlagParserArgument("sort-by-priority",
            "If --display is provided, sort the list of todos by priority (ascending). Cannot be combined with --sort-by-date.",
            Boolean.FALSE,
            new ArrayList(Arrays.asList("display")),
            new ArrayList(Arrays.asList("sort-by-date")));
    this.arguments.add(sortByPriorityArgument);

    this.commandLineParser = new CommandLineParser(this.arguments);
  }

  public void run(String[] args) {
    try {
      HashMap<String, ArrayList<String>> arguments = this.commandLineParser.processArgs(args);

      String pathToCsv = arguments.get("csv-file").get(0);

      if (this.cachedCsv == null || this.cachedCsv.pathToFile != pathToCsv){
        this.parseCsv = new ParseCsv(pathToCsv);
        this.cachedCsv = this.parseCsv.getCsv();
        this.todoList = this.parseCsv.createTodoList();

        this.addTodo = new AddTodo(this.todoList);
        this.completeTodo = new CompleteTodo(this.todoList);
        this.displayTodos = new DisplayTodos(this.todoList);
        this.writeCsv = new WriteCsv(pathToCsv, this.cachedCsv);
      }

      if (arguments.containsKey("add-todo")) {
        this.addTodo.run(arguments);
      }

      if (arguments.containsKey("complete-todo")) {
        this.completeTodo.run(arguments);
      }

      if (arguments.containsKey("display")) {
        this.displayTodos.run(arguments);
      }

      this.writeCsv.write(this.todoList);
    } catch(InvalidArgumentsException e){
      System.out.print(e.getMessage() + "\n\n");
      this.commandLineParser.printManual();
    }
  }
}
