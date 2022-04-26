package problem1.CommandLine;

import java.util.*;

/**
 * Creates a ParserArgument object for a named (key,value) command line parser argument.
 * @param <T>
 */
public class NamedParserArgument<T> extends ParserArgument<T> {
  public HashSet<T> validValues;

  public NamedParserArgument(String key, String description, Boolean required, T value,
      Boolean allowMultiple, ArrayList<String> requiredArgs,
      ArrayList<String> excludedArgs, HashSet<T> validValues) {
    super(key, description, required, value, allowMultiple, requiredArgs, excludedArgs);
    this.validValues = validValues;
  }

  public NamedParserArgument(String key, String description, Boolean required,
      Boolean allowMultiple, ArrayList<String> requiredArgs,
      ArrayList<String> excludedArgs, HashSet<T> validValues) {
    super(key, description, required, allowMultiple, requiredArgs, excludedArgs);
    this.validValues = validValues;
  }

  public NamedParserArgument(String key, String description, Boolean required,
      Boolean allowMultiple, HashSet<T> validValues) {
    super(key, description, required);
    this.validValues = validValues;
  }

  public NamedParserArgument(String key, String description, Boolean required, HashSet<T> validValues) {
    super(key, description, required);
    this.validValues = validValues;
  }

  public NamedParserArgument(String key, String description, Boolean required) {
    super(key, description, required);
  }

  public NamedParserArgument(String key, String description) {
    super(key, description);
  }

  public void checkRequired(HashMap<String, ArrayList<String>> args) throws InvalidArgumentsException {
    if (this.required && args.get(this.key) == null){
      throw new InvalidArgumentsException("'" + this.key + "' is required.");
    }
  }

  public void checkValidValues(HashMap<String, ArrayList<String>> args) throws InvalidArgumentsException{
    if (this.validValues != null && !this.validValues.contains(args.get(this.key))) {
      throw new InvalidArgumentsException("'" + this.key + "' values can only be " + this.validValues.toString());
    }
  }

  @Override
  public void validate(HashMap<String, ArrayList<String>> args) throws InvalidArgumentsException{
    super.validate(args);
    this.checkValidValues(args);
  }
}
