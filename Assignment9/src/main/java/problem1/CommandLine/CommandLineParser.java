package problem1.CommandLine;

import java.util.*;
import problem1.Functionality.Functionality;

public class CommandLineParser {
  public ArrayList<ParserArgument> arguments;
  public ArrayList<Functionality> functionalities;
  public String argumentPrefix = "--";

  public HashMap<String, ArrayList<String>> processedArgs = new HashMap();
  public HashMap<String, ParserArgument> argumentsMap = new HashMap();
  public HashMap<String, Functionality> functionalitiesMap = new HashMap();

  /**
   *
   * @param arguments
   * @param functionalities
   * @param argumentPrefix
   */
  public CommandLineParser(ArrayList<ParserArgument> arguments,
      ArrayList<Functionality> functionalities, String argumentPrefix) {
    this.arguments = arguments;
    this.functionalities = functionalities;
    this.argumentPrefix = argumentPrefix;

    this.createArgumentsMap();
    this.createFunctionalitiesMap();
  }

  /**
   *
   * @param arguments
   * @param functionalities
   */
  public CommandLineParser(ArrayList<ParserArgument> arguments,
      ArrayList<Functionality> functionalities) {
    this.arguments = arguments;
    this.functionalities = functionalities;

    this.createArgumentsMap();
    this.createFunctionalitiesMap();
  }

  /**
   * Creates HashMap that maps argument key with the ParserArgument object
   */
  private void createArgumentsMap() {
    for (ParserArgument arg: this.arguments){
      this.argumentsMap.put(arg.key, arg);
    }
  }

  /**
   * Creates HashMap that maps functionality key with the Functionality object
   */
  private void createFunctionalitiesMap() {
    for (Functionality functionality: this.functionalities){
      this.functionalitiesMap.put(functionality.key, functionality);
    }
  }

  public void processArgs(String[] args) throws InvalidArgumentsException {
    int i = 0;
    while (i < args.length) {
      String key = args[i];
      if (key.startsWith(this.argumentPrefix)) {
        key = key.replace(this.argumentPrefix, "");
        String value = null;
        String nextArg = null;

        if (i + 1 < args.length) {
          nextArg = args[i + 1];
        }

        if (nextArg != null && !nextArg.startsWith(this.argumentPrefix)) {
          value = nextArg;
          // Move index by one to skip this argument
          i++;
        }

        if (!this.processedArgs.containsKey(key)) {
          this.processedArgs.put(key, new ArrayList());
        }

        if (value != null) {
          this.processedArgs.get(key).add(value);
        }
      }
      i++;
    }

    this.initializeArgs();
    this.validate();
  }

  public void initializeArgs(){
    for (String key: this.processedArgs.keySet()){
      ParserArgument arg = this.argumentsMap.get(key);

      if (arg != null) {
        ArrayList<String> values = this.processedArgs.get(key);

        if (values.size() == 0) {
          arg.setValue(null);
        } else if (arg.allowMultiple) {
          arg.setValue(values);
        } else {
          String firstValue = values.get(0);
          values.clear();
          values.add(firstValue);
          arg.setValue(values);
        }
      }
    }
  }

  public void validate() throws InvalidArgumentsException {
    for (ParserArgument arg: this.arguments){
     arg.validate(this.processedArgs);
    }
  }

  public void printManual() {
    for (ParserArgument arg: this.arguments) {
      arg.printManual();
    }
  }
}
