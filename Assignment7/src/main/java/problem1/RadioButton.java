package problem1;

public class RadioButton implements Validator<Boolean> {

  /**
   * Constructor for the radio button class
   */
  public RadioButton() {
  }

  /**
   * Method to determine if the input in the RadioButton is valid
   * @param input - User input as a Boolean to be checked
   * @return - true or false
   */
  @Override
  public boolean isValid(Boolean input){
    //Returning as a valid input as long as the button is selected as true or false
    return input.equals(false) || input.equals(true);
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
    return "RadioButton{}";
  }
}
