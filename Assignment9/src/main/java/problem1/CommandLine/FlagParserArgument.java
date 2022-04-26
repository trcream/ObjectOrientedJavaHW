package problem1.CommandLine;

import java.util.*;

public class FlagParserArgument extends ParserArgument<String> {
  public FlagParserArgument(String key, String description, Boolean required,
      ArrayList<String> requiredArgs,
      ArrayList<String> excludedArgs) {
    super(key, description, required, requiredArgs, excludedArgs);
  }

  public FlagParserArgument(String key, String description, Boolean required) {
    super(key, description, required);
  }

  public FlagParserArgument(String key, String description) {
    super(key, description);
  }

  public void checkRequired(HashMap<String, ArrayList<String>> args) throws InvalidArgumentsException {
    if (this.required && !args.containsKey(this.key)) {
      throw new InvalidArgumentsException("'" + this.key + "' is required.");
    }
  }
}
