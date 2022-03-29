package problem1;

public class NegativeDecimalPlacesException extends Exception{

  /**
   *Exception thrown when negative decimal place is added
   * @param message - Message that the user tried to set a negative decimal place
   */
  public NegativeDecimalPlacesException(String message) {
    super(message);
  }
}
