package problem1;

import java.util.Objects;

public class Number implements Validator<String> {

  private Integer maximumValue;
  private Integer minimumValue;
  private Integer maximumDecimalPlaces;

  /**
   * Constructor for the number validator
   * @param maximumValue - maximum value that can be entered
   * @param minimumValue - minimum value that can be entered
   * @param maximumDecimalPlaces - maximum decimal places that can be entered
   */

  public Number(Integer maximumValue, Integer minimumValue, Integer maximumDecimalPlaces) {
    this.maximumValue = maximumValue;
    this.minimumValue = minimumValue;
    this.maximumDecimalPlaces = maximumDecimalPlaces;
  }

  /**
   * Gets the maximum value that can be entered
   * @return - maximum value
   */
  public Integer getMaximumValue() {
    return maximumValue;
  }

  /**
   * Sets the maximum value that can be entered
   * @param maximumValue - maximum value
   */
  public void setMaximumValue(Integer maximumValue) {
    this.maximumValue = maximumValue;
  }

  /**
   * Gets the minimum value that can be entered
   * @return
   */
  public Integer getMinimumValue() {
    return minimumValue;
  }

  /**
   * Sets the minimum value that can be entered
   * @param minimumValue - minimum value
   */
  public void setMinimumValue(Integer minimumValue) {
    this.minimumValue = minimumValue;
  }

  /**
   * Gets the maximum amount of decimal places
   * @return - maximum amount of decimal places
   */
  public Integer getMaximumDecimalPlaces() {
    return maximumDecimalPlaces;
  }

  /**
   * Sets the maximum amount of decimal places
   * @param maximumDecimalPlaces - maximum amount of decimal places
   */
  public void setMaximumDecimalPlaces(Integer maximumDecimalPlaces) {
    this.maximumDecimalPlaces = maximumDecimalPlaces;
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
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  /**
   * Helper method to check that the given string has a length less than 10
   *
   * @param input - User input to be checked as a string
   * @return - true or false
   */
  public boolean checkValue(String input) {
    long stringToNumber = Long.parseLong(input);
      return stringToNumber <= this.maximumValue && stringToNumber >= this.minimumValue;
  }

  /**
   * Helper method to check that a given string, when converted to a number, only has two decimal
   * places
   *
   * @param input - User input to be checked as a string
   * @return - true or false
   */
  public boolean checkDecimalPlaces(String input) {
    String[] splitNumber = input.split("\\.");
    if (splitNumber[1].length() <= this.maximumDecimalPlaces) {
      return true;
    } else {
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
    return checkNumber(input) && checkValue(input) && checkDecimalPlaces(input);

  }

  /**
   * Method that determines if the object is equal to in certain conditions
   * @param o - Object o to compare if the object is equivalent
   * @return - return true or false based upon if the criteria is met
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Number number = (Number) o;
    return Objects.equals(maximumValue, number.maximumValue) && Objects.equals(
        minimumValue, number.minimumValue) && Objects.equals(maximumDecimalPlaces,
        number.maximumDecimalPlaces);
  }

  /**
   * Method to determine if the hashcode of the object is a match
   * @return - true or false depending on if the hash code is equal or not
   */
  @Override
  public int hashCode() {
    return Objects.hash(maximumValue, minimumValue, maximumDecimalPlaces);
  }

  /**
   * Method that converts the object's field information into a string
   * @return - True or false depending on if the string information matches
   */
  @Override
  public String toString() {
    return "Number{" +
        "maximumValue=" + maximumValue +
        ", minimumValue=" + minimumValue +
        ", maximumDecimalPlaces=" + maximumDecimalPlaces +
        '}';
  }
}
