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

  @Override
  public String toString() {
    return "RadioButton{}";
  }
}
