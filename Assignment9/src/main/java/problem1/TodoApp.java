package problem1;

import java.util.*;
import problem1.CommandLine.CommandLineParser;
import problem1.CommandLine.FlagParserArgument;
import problem1.CommandLine.InvalidArgumentsException;
import problem1.CommandLine.NamedParserArgument;
import problem1.CommandLine.ParserArgument;
import problem1.Functionality.Functionality;

public class TodoApp{
  String MANUAL = "--csv-file <path/to/file>\n"
      + "\t\tThe CSV file containing the todos. This option is required.\n"
      + "--add-todo\n"
      + "\t\tAdd a new todo. If this option is provided, then --todo-text must also be provided.\n"
      + "--todo-text <description of todo>\n"
      + "\t\tA description of the todo.\n"
      + "--completed\n"
      + "\t\t(Optional) Sets the completed status of a new todo to true.\n"
      + "--due <due date>\n"
      + "\t\t(Optional) Sets the due date of a new todo. "
      + "You may choose how the date should be formatted.\n"
      + "--priority <1, 2, or 3>\n"
      + "\t\t(Optional) Sets the priority of a new todo. The value can be 1, 2, or 3.\n"
      + "--category <a category name>\n"
      + "\t\t(Optional) Sets the category of a new todo. The value can be any String. "
      + "Categories do not need to be pre-defined.\n"
      + "--complete-todo <id>\n"
      + "\t\tMark the Todo with the provided ID as complete.\n"
      + "--display\n"
      + "\t\tDisplay todos. "
      + "If none of the following optional arguments are provided, displays all todos.\n"
      + "--show-incomplete\n"
      + "\t\t(Optional) If --display is provided, only incomplete todos should be displayed.\n"
      + "--show-category <category>\n"
      + "\t\t(Optional) If --display is provided, "
      + "only todos with the given category should be displayed.\n"
      + "--sort-by-date\n"
      + "\t\t(Optional) If --display is provided, sort the list of todos by date order (ascending). "
      + "Cannot be combined with --sort-by-priority.\n"
      + "--sort-by-priority\n"
      + "\t\t(Optional) If --display is provided, sort the list of todos by priority (ascending). "
      + "Cannot be combined with --sort-by-date.";

  CommandLineParser commandLineParser;

  ArrayList<ParserArgument> arguments = new ArrayList<>();
  ArrayList<Functionality> functionalities = new ArrayList<>();

  public TodoApp() {
    NamedParserArgument<String> csvFilePathArgument = new NamedParserArgument("csv-file", "The CSV file containing the todos. This option is required.", Boolean.TRUE);
    this.arguments.add(csvFilePathArgument);

    FlagParserArgument displayArgument = new FlagParserArgument("display", "Display todos. If none of the following optional arguments are provided, displays all todos. ", Boolean.FALSE);
    this.arguments.add(displayArgument);

    NamedParserArgument<ArrayList<String>> completeTodoArgument = new NamedParserArgument("complete-todo", "Mark the Todo with the provided ID as complete.", Boolean.TRUE);
    this.arguments.add(completeTodoArgument);

    NamedParserArgument<ArrayList<String>> priorityTodoArgument = new NamedParserArgument("priority", "Mark the Todo with the provided ID as complete.", Boolean.TRUE);
    this.arguments.add(priorityTodoArgument);

    FlagParserArgument sortByDateArgument = new FlagParserArgument("sort-by-date", "If --display is\n"
        + "provided, sort the list of todos\n"
        + "by date order (ascending). Cannot\n"
        + "be combined with --sort-by-\n"
        + "priority.", Boolean.FALSE, new ArrayList<String>(
        Arrays.asList("display")), new ArrayList<String>(
        Arrays.asList("sort-by-priority")));

    this.commandLineParser = new CommandLineParser(this.arguments, this.functionalities);
  }

  public void run(String[] args) {
    try {
      this.commandLineParser.processArgs(args);
    } catch(InvalidArgumentsException e){
      System.out.print(e.getMessage() + "\n\n" + this.MANUAL);
    }
  }
}
