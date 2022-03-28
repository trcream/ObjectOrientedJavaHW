package problem1;

public class CheckBox implements Validator<Boolean> {

  /**
   * Constructor for the CheckBox class
   */

  public CheckBox() {
  }

  /**
   * Method to check if the input in the CheckBox is valid
   *
   * @param input - User input as a boolean
   * @return - true or false
   */
  @Override
  public boolean isValid(Boolean input) {
    return input.equals(true) || input.equals(false);
  }

  /**
   * Overloaded method that returns true when the value is null
   * @return - true or false
   */
  public boolean isValid() {
    return true;
  }


  /**
   * Method to determine if the hashcode of the object is a match
   * @return - true or false depending on if the hash code is equal or not
   */
  @Override
  public int hashCode() {
    return super.hashCode();
  }

  /**
   * Method that determines if the object is equal to in certain conditions
   * @param obj - Object o to compare if the object is equivalent
   * @return - return true or false based upon if the criteria is met
   */
  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  /**
   * Method that converts the object's field information into a string
   * @return - True or false depending on if the string information matches
   */
  @Override
  public String toString() {
    return "CheckBox{}";
  }
}