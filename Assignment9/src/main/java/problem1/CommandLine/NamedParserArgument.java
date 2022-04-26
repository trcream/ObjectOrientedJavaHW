package problem1.CommandLine;

import java.util.*;

/**
 * Creates a ParserArgument object for a named (key,value) command line parser argument.
 */
public class NamedParserArgument extends ParserArgument<ArrayList<String>> {
  public HashSet<String> validValues = null;
  public String valueDescription;

  public NamedParserArgument(String key, String description, String valueDescription, Boolean required,
      Boolean allowMultiple, ArrayList<String> requiredArgs,
      ArrayList<String> excludedArgs, HashSet<String> validValues) {
    super(key, description, required, allowMultiple, requiredArgs, excludedArgs);
    this.validValues = validValues;
    this.valueDescription = valueDescription;
  }

  public NamedParserArgument(String key, String description,String valueDescription, Boolean required,
      Boolean allowMultiple, ArrayList<String> requiredArgs,
      ArrayList<String> excludedArgs) {
    super(key, description, required, allowMultiple, requiredArgs, excludedArgs);
    this.valueDescription = valueDescription;
  }

  public NamedParserArgument(String key, String description, String valueDescription, Boolean required,ArrayList<String> requiredArgs,
      ArrayList<String> excludedArgs) {
    super(key, description, required, Boolean.FALSE, requiredArgs, excludedArgs);
    this.valueDescription = valueDescription;
  }

  public NamedParserArgument(String key, String description, String valueDescription, Boolean required,
      Boolean allowMultiple, HashSet<String> validValues) {
    super(key, description, required);
    this.valueDescription = valueDescription;
    this.allowMultiple = allowMultiple;
    this.validValues = validValues;
  }

  public NamedParserArgument(String key, String description, String valueDescription, Boolean required,
      Boolean allowMultiple) {
    super(key, description, required);
    this.valueDescription = valueDescription;
    this.allowMultiple = allowMultiple;
  }

  public NamedParserArgument(String key, String description, String valueDescription, Boolean required, HashSet<String> validValues) {
    super(key, description, required);
    this.valueDescription = valueDescription;
    this.validValues = validValues;
  }

  public NamedParserArgument(String key, String description,String valueDescription, Boolean required) {
    super(key, description, required);
    this.valueDescription = valueDescription;
  }

  public NamedParserArgument(String key, String description, String valueDescription) {
    super(key, description);
    this.valueDescription = valueDescription;
  }

//  public void checkRequired(HashMap<String, ArrayList<String>> args) throws InvalidArgumentsException {
//    ArrayList<String> value = args.get(this.key);
//    if (this.required && (value == null || value.size() == 0)){
//      throw new InvalidArgumentsException("'" + this.key + "' is required.");
//    }
//  }

  public void checkIfValueGiven(HashMap<String, ArrayList<String>> args) throws InvalidArgumentsException{
    if (args.containsKey(this.key) && this.value == null){
      throw new InvalidArgumentsException("'" + this.key + "' expects to be given a value.");
    }
  }

  public void checkValidValues() throws InvalidArgumentsException{
    if (this.validValues != null && this.value != null){
      for (String value: this.value) {
        if (!this.validValues.contains(value)){
          throw new InvalidArgumentsException("'" + this.key + "' values can only be " + this.validValues);
        }
      }
    }
  }

  @Override
  public void validate(HashMap<String, ArrayList<String>> args) throws InvalidArgumentsException{
    super.validate(args);
    this.checkValidValues();
    this.checkIfValueGiven(args);
  }

  public void printManual() {
    System.out.println("--" + this.key + " <" + this.valueDescription + ">");
    System.out.println("\t\t" + this.description);
  }
}
