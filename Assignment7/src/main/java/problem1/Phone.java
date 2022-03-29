package problem1;


import java.util.Objects;

/**
 *  A valid phone number is a String that contains only digits and has a specified
 * length supplied by client code. The length must match exactly.
 */
public class Phone implements Validator<String> {
  private Integer length;


  /**
   * @param length Integer: Length of the phone number
   * Constructor for class
   */
  public Phone(Integer length) {
    this.length = length;
  }

  /**
   * @return Integer: Length of phone number
   */
  public Integer getLength() {
    return this.length;
  }

  /**
   * @param length Integer: Set length of phone number
   */
  public void setLength(Integer length) {
    this.length = length;
  }

  /**
   * @param o An Object
   * @return Boolean: States whether if 2 objects are the same
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Phone phone = (Phone) o;
    return Objects.equals(length, phone.length);
  }

  /**
   * @return Hashcode for object
   */
  @Override
  public int hashCode() {
    return Objects.hash(length);
  }

  /**
   * @return String: Shows the values of all attributes within object
   */
  @Override
  public String toString() {
    return "Phone{" +
        "length=" + this.length +
        '}';
  }

  /**
   * @param input String: Phone number
   * @return Boolean: States whether if the input only contains digits
   */
  private boolean containsOnlyDigits(String input){
    Integer count = 0;
    for(int i =0; i<input.length(); i++){
      if(Character.isDigit(input.charAt(i))){
        count++;
      }
    }
    return count.equals(input.length());
  }

  /**
   *
   * @param input String: Phone number
   * @return Boolean: States whether the length matches the required length
   */
  private boolean validLength(String input) {
    Integer count = 0;
    for (int i = 0; i < input.length(); i++) {
      if (Character.isDigit(input.charAt(i))) {
        count++;
      }
    }
    return count.equals(this.length);
  }


  /**
   * @param input - General user input to be checked
   * @return A boolean to confirm whether the input is valid for
   * phone number
   */
  @Override
  public boolean isValid(String input) {
      return containsOnlyDigits(input) && validLength(input);

    }
}
