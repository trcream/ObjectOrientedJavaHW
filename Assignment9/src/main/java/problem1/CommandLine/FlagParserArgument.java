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

  public void printManual() {
    System.out.println("--" + this.key);
    System.out.println("\t\t" + this.description);
  }
}
