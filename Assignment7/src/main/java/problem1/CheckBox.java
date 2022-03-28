package problem1;

public class CheckBox implements Validator<Field> {

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
  public boolean isValid(Field input) {
    return input.getValue() == null || input.getValue() == Boolean.TRUE || input.getValue() == Boolean.FALSE;
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
    return "CheckBox{}";
  }
}