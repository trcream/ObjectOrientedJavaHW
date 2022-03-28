package problem1;

public class RadioButton implements Validator<Field> {

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
  public boolean isValid(Field input){
    //Returning as a valid input as long as the button is selected as true or false
    return input.getValue() == Boolean.TRUE || input.getValue() == Boolean.FALSE;
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
    return "RadioButton{}";
  }
}
