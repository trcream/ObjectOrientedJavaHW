package problem1.CommandLine;

import java.util.*;

public class CommandLineParser {
  public ArrayList<ParserArgument> arguments;
  public String argumentPrefix = "--";

  public HashMap<String, ArrayList<String>> processedArgs = new HashMap();
  public HashMap<String, ParserArgument> argumentsMap = new HashMap();

  /**
   *
   * @param arguments
   * @param argumentPrefix
   */
  public CommandLineParser(ArrayList<ParserArgument> arguments,String argumentPrefix) {
    this.arguments = arguments;
    this.argumentPrefix = argumentPrefix;

    this.createArgumentsMap();
  }

  /**
   *
   * @param arguments
   */
  public CommandLineParser(ArrayList<ParserArgument> arguments) {
    this.arguments = arguments;

    this.createArgumentsMap();
  }

  /**
   * Creates HashMap that maps argument key with the ParserArgument object
   */
  private void createArgumentsMap() {
    for (ParserArgument arg: this.arguments){
      this.argumentsMap.put(arg.key, arg);
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
