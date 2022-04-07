package problem1;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

/**
 * Processes and validates command line arguments.
 */
public class CommandLineParser {
  // CLI options
  public static final String EMAIL_ARGUMENT_KEY = "--email";
  public static final String EMAIL_TEMPLATE_ARGUMENT_KEY = "--email-template";
  public static final String LETTER_ARGUMENT_KEY = "--letter";
  public static final String LETTER_TEMPLATE_ARGUMENT_KEY = "--letter-template";
  public static final String OUTPUT_ARGUMENT_KEY = "--output-dir";
  public static final String CSV_ARGUMENT_KEY = "--csv-file";

  private String[] requiredOptions = {OUTPUT_ARGUMENT_KEY, CSV_ARGUMENT_KEY};

  public BufferedReader emailTemplate;
  public BufferedReader letterTemplate;
  public BufferedReader csv;
  public String outputDirPath;

  /**
   * Constructor for the CommandLineParser class
   * @param args The arguments provided by the user.
   * @throws InvalidArgumentsException If the arguments supplied are invalid.
   */
  public CommandLineParser(String[] args) throws InvalidArgumentsException {
    this.processArgs(args);
  }

  /**
   * Removes duplicate options. CLI will only process the first valid option and will ignore other
   * occurrences of the option.
   *
   * Examples:
   *  Before: `--email --email --email-template path/to/file`
   *  After: `--email --email-template path/to/file`
   *
   *  Before: `--email --email-template path/to/file --email-template path/to/`
   *  After: `--email --email-template path/to/file`
   *
   *  Before: `--email --email-template path/to/file --email --email-template path/to/`
   *  After: `--email --email-template path/to/file`
   * @param args The arguments provided by the user.
   * @return arguments with duplicates removed
   */
  private HashMap<String, String> preprocessArgs(String[] args) throws InvalidArgumentsException {
    String OPTION_FLAG = "--";
    HashMap<String, String> processedArgs = new HashMap<String, String>();

    int i = 0;
    while (i < args.length) {
      String key = args[i];
      if (key.startsWith(OPTION_FLAG) && !processedArgs.containsKey(key)) {
        String value = null;
        String nextArg = args[i + 1];

        if (!nextArg.startsWith(OPTION_FLAG)) {
          value = nextArg;
          // Move index by one to skip this argument
          i++;
        }
        processedArgs.put(key, value);
      }
      i++;
    }
    return processedArgs;
  }

  /**
   * Helper method to populate the instance variables.
   * @param args The args supplied by the user.
   * @throws InvalidArgumentsException If an invalid argument is provided at the command line.
   */
  private void processArgs(String[] args) throws InvalidArgumentsException {
    // Remove duplicate options
    HashMap<String, String> processedArgs = this.preprocessArgs(args);

    // check required options
    checkRequiredOptions(processedArgs);
    this.outputDirPath = processedArgs.get(OUTPUT_ARGUMENT_KEY);
    this.csv = this.fetchFile(processedArgs.get(CSV_ARGUMENT_KEY));

    // check that either email option or letter option is given
    if (!processedArgs.containsKey(EMAIL_ARGUMENT_KEY) &&
        !processedArgs.containsKey(LETTER_ARGUMENT_KEY)){
      throw new InvalidArgumentsException("Neither email option or letter option were chosen.");
    }

    // check if email option is given, email-template is also given
    if (processedArgs.containsKey(EMAIL_ARGUMENT_KEY)) {
      if (processedArgs.get(EMAIL_TEMPLATE_ARGUMENT_KEY) == null) {
        throw new InvalidArgumentsException("Email option chosen but no email template given.");
      } else {
        this.emailTemplate = this.fetchFile(processedArgs.get(EMAIL_ARGUMENT_KEY));

        // TODO: Create new EmailGenerator
        // emailGenerator.generate();
      }
    }

    // check if letter option is given, letter-template is also given
    if (processedArgs.containsKey(LETTER_ARGUMENT_KEY)) {
      if (processedArgs.get(LETTER_TEMPLATE_ARGUMENT_KEY) == null) {
        throw new InvalidArgumentsException("Letter option chosen but no letter template given.");
      } else {
        this.letterTemplate = this.fetchFile(processedArgs.get(LETTER_ARGUMENT_KEY));

        // TODO: Create new LetterGenerator
        // letterGenerator.generate();
      }
    }
  }

  /**
   * Check if all required options are given
   * @param args arguments given by user
   * @throws InvalidArgumentsException
   */
  void checkRequiredOptions(HashMap<String, String> args) throws InvalidArgumentsException{
    for (int i = 0; i < this.requiredOptions.length; i++){
      String requiredOption = this.requiredOptions[i];

      if (args.get(requiredOption) == null) {
        throw new InvalidArgumentsException(requiredOption + " option is required.");
      }
    }
  }

  /**
   * Gets the file from given path.
   * @param pathToFile
   * @return
   */
  BufferedReader fetchFile(String pathToFile){
    try {
      return new BufferedReader(new FileReader(pathToFile));
    } catch (FileNotFoundException fnfe) {
      System.out.println("*** OOPS! A file was not found : " + fnfe.getMessage());
      fnfe.printStackTrace();
    }
    return null;
  }
}
