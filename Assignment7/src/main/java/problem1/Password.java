package problem1;


import java.util.Objects;

/**
 * Password - A password is a String has the following properties:
 * ○ Minimum and maximum acceptable length (inclusive).
 * ○ The minimum number of lowercase letters that the password must contain
 * (default = 0, which means that lowercase letters are not required).
 * ○ The minimum number of uppercase letters that the password must contain
 * (default = 0).
 * ○ The minimum number of digits that the password must contain (default = 0).
 * CS 5004, Spring 2022
 * To be valid, a password must meet the length requirements and contain at least the
 * minimum number of each character type. Additionally, a valid password cannot contain a
 * space (“ “). To keep things simple, all other characters are allowed.
 */
public class Password implements Validator<String> {
  private Integer minimumPasswordLength;
  private Integer maximumPasswordLength;
  private Integer minLowerCases = 0;
  private Integer minUpperCases = 0;
  private Integer minDigits = 0;

  /**
   * @param minimumPasswordLength Integer: Minimum Password Length
   * @param maximumPasswordLength Integer: Maximum Password Length
   * @return Boolean
   */
  private Boolean minMaxCheck(Integer minimumPasswordLength, Integer maximumPasswordLength) {
    return minimumPasswordLength <= maximumPasswordLength;
  }

  /**
   * @param minimumPasswordLength Integer: Minimum Password Length
   * @param maximumPasswordLength Integer: Maximum Password Length
   * @param minLowerCases Integer: Minimum amount of lower cases within password
   * @param minUpperCases Integer: Minimum amount of upper cases within password
   * @param minDigits Integer: Minimum amount of digits within password
   * @throws MinMaxValueException Throws exception when minimum or maximum password
   * length is entered incorrectly based on parameters
   * This constructor allows user to change parameters with defaults
   */
  public Password(Integer minimumPasswordLength, Integer maximumPasswordLength,
      Integer minLowerCases, Integer minUpperCases, Integer minDigits) throws
      MinMaxValueException {
    if(minMaxCheck(minimumPasswordLength, maximumPasswordLength)) {
      this.minimumPasswordLength = minimumPasswordLength;
      this.maximumPasswordLength = maximumPasswordLength;
      this.minLowerCases = minLowerCases;
      this.minUpperCases = minUpperCases;
      this.minDigits = minDigits;
    } else {
      throw new MinMaxValueException("The maximum password length cannot be smaller than the min");
    }
  }

  /**
   * @param minimumPasswordLength Integer: Minimum Password Length
   * @param maximumPasswordLength Integer: Maximum Password Length
   * @throws MinMaxValueException Throws exception when minimum or maximum password
   * length is entered incorrectly based on parameters
   * This constructor allows user to not change defaults
   */
  public Password(Integer minimumPasswordLength, Integer maximumPasswordLength) throws
      MinMaxValueException {
    if(minMaxCheck(minimumPasswordLength, maximumPasswordLength)) {
    this.minimumPasswordLength = minimumPasswordLength;
    this.maximumPasswordLength = maximumPasswordLength;
    } else {
      throw new MinMaxValueException("The maximum password length cannot be smaller than the min");
    }
  }

  /**
   * @return Integer: Object's minimum password length
   */
  public Integer getMinimumPasswordLength() {
    return this.minimumPasswordLength;
  }


  /**
   * @param minimumPasswordLength Integer: Set minimum password length
   * @throws MinMaxValueException Throws exception when minimum password
   * length is greater than the max
   */
  public void setMinimumPasswordLength(Integer minimumPasswordLength) throws MinMaxValueException {
    if(minMaxCheck(minimumPasswordLength, this.maximumPasswordLength)) {
      this.minimumPasswordLength = minimumPasswordLength;
    } else {
      throw new MinMaxValueException("The minimum password length cannot be larger than the max");
    }
  }

  /**
   * @return Integer: Object's maximum password length
   */
  public Integer getMaximumPasswordLength() {
    return this.maximumPasswordLength;
  }

  /**
   * @param maximumPasswordLength Integer: set maximum password length
   * @throws MinMaxValueException Throws exception when maximum password length is less than
   * the minimum password length
   */
  public void setMaximumPasswordLength(Integer maximumPasswordLength) throws MinMaxValueException {
    if(minMaxCheck(this.minimumPasswordLength, maximumPasswordLength)) {
      this.maximumPasswordLength = maximumPasswordLength;
    } else {
      throw new MinMaxValueException("The maximum password length cannot be smaller than the min");
    }
  }

  /**
   * @return Integer: Object's minimum lower cases amount
   */
  public Integer getMinLowerCases() {
    return this.minLowerCases;
  }

  /**
   * @param minLowerCases Integer: Set the amount of minimum lower
   * cases
   */
  public void setMinLowerCases(Integer minLowerCases) {
    this.minLowerCases = minLowerCases;
  }

  /**
   * @return Integer: Object's minimum upper cases amount
   */
  public Integer getMinUpperCases() {
    return this.minUpperCases;
  }

  /**
   * @param minUpperCases Integer: Set the amount of minimum upper
   * cases
   */
  public void setMinUpperCases(Integer minUpperCases) {
    this.minUpperCases = minUpperCases;
  }

  /**
   * @return Integer: Object's minimum digits
   */
  public Integer getMinDigits() {
    return this.minDigits;
  }

  /**
   * @param minDigits Integer: Set minimum digits within password
   */
  public void setMinDigits(Integer minDigits) {
    this.minDigits = minDigits;
  }

  /**
   * @param o An Object
   * @return Boolean to state whether if 2 objects are the same
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Password password = (Password) o;
    return Objects.equals(minimumPasswordLength, password.minimumPasswordLength)
        && Objects.equals(maximumPasswordLength, password.maximumPasswordLength)
        && Objects.equals(minLowerCases, password.minLowerCases)
        && Objects.equals(minUpperCases, password.minUpperCases)
        && Objects.equals(minDigits, password.minDigits);
  }

  /**
   * @return Hashcode for object
   */
  @Override
  public int hashCode() {
    return Objects.hash(minimumPasswordLength, maximumPasswordLength, minLowerCases, minUpperCases,
        minDigits);
  }

  /**
   * @return String: Shows the values of all attributes within object
   */
  @Override
  public String toString() {
    return "Password{" +
        "minimumPasswordLength=" + this.minimumPasswordLength +
        ", maximumPasswordLength=" + this.maximumPasswordLength +
        ", minLowerCases=" + this.minLowerCases +
        ", minUpperCases=" + this.minUpperCases +
        ", minDigits=" + this.minDigits +
        '}';
  }

  /**
   * @param input A string for password
   * @return A boolean to state whether the password has a valid length
   * This is a helper method to isValid()
   */
  private boolean isAcceptableLength(String input){
    if (input == null) {
      return Boolean.FALSE;
    } else {
      Integer length = input.length();
      return (length >= minimumPasswordLength && length <= maximumPasswordLength);
    }
  }

  /**
   * @param input A string for password
   * @return A boolean to state whether the password has valid
   * number of minimum lower cases
   * This is a helper method to isValid()
   */
  private boolean hasMinimumLowerCases(String input){
    Integer count = 0;
    for(int i =0; i<input.length(); i++){
      if(Character.isLowerCase(input.charAt(i))){
        count++;
      }
    }
    return count>=this.minLowerCases;
  }


  /**
   * @param input A string for password
   * @return A boolean to state whether the password has valid
   * number of minimum upper cases
   * This is a helper method to isValid()
   */
  private boolean hasMinimumUpperCases(String input){
    Integer count = 0;
    for(int i =0; i<input.length(); i++){
      if(Character.isUpperCase(input.charAt(i))){
        count++;
      }
    }
    return count>=this.minUpperCases;
  }

  /**
   * @param input A string for password
   * @return A boolean to state whether the password has valid
   * number of minimum digits
   * This is a helper method to isValid()
   */
  private boolean hasMinimumDigits(String input) {
    Integer count = 0;
    for(int i =0; i<input.length(); i++){
      if(Character.isDigit(input.charAt(i))){
        count++;
      }
    }
    return count>=this.minDigits;
  }

  /**
   * @param input A string for password
   * @return A boolean to state whether the password has
   * no space
   * This is a helper method to isValid()
   */

  private boolean hasNoSpace(String input) {
    for (int i = 0; i < input.length(); i++) {
      if (String.valueOf(input.charAt(i)).equals(" ")) {
        return false;
      }
    }
    return true;
  }

  /**
   * @param input - General user input to be checked
   * @return A boolean to confirm whether the input is valid for
   * Password
   */
  @Override
  public boolean isValid(String input) {
    return isAcceptableLength(input) &&
        hasMinimumLowerCases(input) &&
        hasMinimumUpperCases(input) &&
        hasMinimumDigits(input) &&
        hasNoSpace(input);
    }
}


// Citation
// https://www.tutorialspoint.com/check-whether-a-character-is-lowercase-or-not-in-java#:~:text=To%20check%20whether%20a%20character,isLowerCase()%20method.