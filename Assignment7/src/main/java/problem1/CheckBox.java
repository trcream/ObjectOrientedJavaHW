package problem1;

public class CheckBox implements Validator<Boolean> {

  /**
   * Method to check if the input in the CheckBox is valid
   * @param input - User input as a boolean
   * @return - true or false
   */
  @Override
  public boolean isValid(Boolean input) {
    //Valid input even if nothing is selected
    return input.equals(true) || input.equals(false) || input.equals(null);
}