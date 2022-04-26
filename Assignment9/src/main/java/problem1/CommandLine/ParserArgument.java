package problem1.CommandLine;

import java.util.*;

public abstract class ParserArgument<T> {
  public String key;
  public String description;
  public T value = null;
  public Boolean required;
  public Boolean allowMultiple;
  ArrayList<String> requiredArgs;
  ArrayList<String> excludedArgs;

  public ParserArgument(String key, String description, Boolean required, Boolean allowMultiple, ArrayList<String> requiredArgs, ArrayList<String> excludedArgs) {
    this.key = key;
    this.description = description;
    this.required = required;
    this.allowMultiple = allowMultiple;
    this.requiredArgs = requiredArgs;
    this.excludedArgs = excludedArgs;
  }

  public ParserArgument(String key, String description, Boolean required, ArrayList<String> requiredArgs, ArrayList<String> excludedArgs) {
    this.key = key;
    this.description = description;
    this.required = required;
    this.allowMultiple = Boolean.FALSE;
    this.requiredArgs = requiredArgs;
    this.excludedArgs = excludedArgs;
  }

  public ParserArgument(String key, String description, Boolean required) {
    this.key = key;
    this.description = description;
    this.required = required;
    this.allowMultiple = Boolean.FALSE;
    this.requiredArgs = new ArrayList();
    this.excludedArgs = new ArrayList();
  }

  public ParserArgument(String key, String description) {
    this.key = key;
    this.description = description;
    this.required = Boolean.FALSE;
    this.allowMultiple = Boolean.FALSE;
    this.requiredArgs = new ArrayList();
    this.excludedArgs = new ArrayList();
  }

  public String getKey() {
    return this.key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public T getValue() {
    return this.value;
  }

  public void setValue(T value) {
    this.value = value;
  }

  public Boolean getRequired() {
    return this.required;
  }

  public void setRequired(Boolean required) {
    this.required = required;
  }

  public ArrayList<String> getRequiredArgs() {
    return this.requiredArgs;
  }

  public void setRequiredArgs(ArrayList<String> requiredArgs) {
    this.requiredArgs = requiredArgs;
  }

  public ArrayList<String> getExcludedArgs() {
    return this.excludedArgs;
  }

  public void setExcludedArgs(ArrayList<String> excludedArgs) {
    this.excludedArgs = excludedArgs;
  }

  public void checkRequired(HashMap<String, ArrayList<String>> args) throws InvalidArgumentsException {
    if (this.required && !args.containsKey(this.key)) {
      throw new InvalidArgumentsException("'" + this.key + "' is required.");
    }
  }
  public void checkRequiredArguments(HashMap<String, ArrayList<String>> args) throws InvalidArgumentsException {
    for (String requiredArg: this.requiredArgs){
      if (args.containsKey(this.key) && !args.containsKey(requiredArg)){
        throw new InvalidArgumentsException("'" + this.key + "' requires " + requiredArg+ ".");
      }
    }
  }

  public void checkExcludedArguments(HashMap<String, ArrayList<String>> args) throws InvalidArgumentsException {
    for (String excludedArg: this.excludedArgs){
      if (args.containsKey(this.key) && args.containsKey(excludedArg)){
        throw new InvalidArgumentsException("'" + this.key + "' cannot be used with " + excludedArg + ".");
      }
    }
  }

  public void validate(HashMap<String, ArrayList<String>> args) throws InvalidArgumentsException{
    this.checkRequired(args);
    this.checkRequiredArguments(args);
    this.checkExcludedArguments(args);
  }

  public abstract void printManual();
}
