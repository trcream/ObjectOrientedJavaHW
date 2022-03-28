package problem1;

public class Number implements Validator<String> {

  public static final Integer MAXIMUM_VALUE_LENGTH = 10;
  public static final Integer MAXIMUM_DECIMAL_PLACES = 2;

  /**
   * Constructor for the Number class.
   */
  public Number() {
  }

  /**
   * Helper method to check that the given string is a number
   *
   * @param input - User input to be checked as a string
   * @return - true or false
   */
  public static boolean checkNumber(String input) {
    try {
      Long.parseLong(input);
      System.out.println("This is a number " + input);
      return true;
    } catch (NumberFormatException e) {
      System.out.println("This is not a number " + input);
      return false;
    }
  }

  /**
   * Helper method to check that the given string has a length less than 10
   *
   * @param input - User input to be checked as a string
   * @return - true or false
   */
  public static boolean checkLength(String input) {
    if (input.length() <= MAXIMUM_VALUE_LENGTH) {
      return true;
    } else
      System.out.println("The maximum length is 10");
    return false;
  }

  /**
   * Helper method to check that a given string, when converted to a number, only has two decimal
   * places
   *
   * @param input - User input to be checked as a string
   * @return - true or false
   */
  public static boolean checkDecimalPlaces(String input) {
    String[] splitNumber = input.split("\\.");
    if (splitNumber[1].length() <= MAXIMUM_DECIMAL_PLACES) {
      return true;
    } else {
      System.out.println("The number can hold only a maximum of two decimal places");
      return false;
    }
  }

  /**
   * Method to check that text entered by a user can be converted to the appropriate numeric format.
   * A string must be able to be converted to a number, less than 10 digits, and have less than two
   * decimal places
   *
   * @param input - User string to be validated
   * @return - true or false if the string meets the given criteria
   */
  @Override
  public boolean isValid(String input) {
    //Checking that the input is a number, has the right length and decimal places
    return checkNumber(input) && checkLength(input) && checkDecimalPlaces(input);

  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  @Override
  public String toString() {
    return "Number{}";
  }
}
