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
  private Integer minDigits= 0;

  public Boolean minMaxCheck(Integer minimumPasswordLength, Integer maximumPasswordLength) {
    return minimumPasswordLength <= maximumPasswordLength;
  }

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

  public Password(Integer minimumPasswordLength, Integer maximumPasswordLength) throws
      MinMaxValueException {
    if(minMaxCheck(minimumPasswordLength, maximumPasswordLength)) {
    this.minimumPasswordLength = minimumPasswordLength;
    this.maximumPasswordLength = maximumPasswordLength;
    } else {
      throw new MinMaxValueException("The maximum password length cannot be smaller than the min");
    }
  }

  public Integer getMinimumPasswordLength() {
    return this.minimumPasswordLength;
  }


  public void setMinimumPasswordLength(Integer minimumPasswordLength) {
    if(minMaxCheck(minimumPasswordLength, this.maximumPasswordLength)) {
      this.minimumPasswordLength = minimumPasswordLength;
    } else {
      throw new MinMaxValueException("The minimum password length cannot be larger than the max");
    }
  }

  public Integer getMaximumPasswordLength() {
    return this.maximumPasswordLength;
  }

  public void setMaximumPasswordLength(Integer maximumPasswordLength) {
    if(minMaxCheck(this.minimumPasswordLength, maximumPasswordLength)) {
      this.maximumPasswordLength = maximumPasswordLength;
    } else {
      throw new MinMaxValueException("The maximum password length cannot be smaller than the min");
    }
  }

  public Integer getMinLowerCases() {
    return this.minLowerCases;
  }

  public void setMinLowerCases(Integer minLowerCases) {
    this.minLowerCases = minLowerCases;
  }

  public Integer getMinUpperCases() {
    return this.minUpperCases;
  }

  public void setMinUpperCases(Integer minUpperCases) {
    this.minUpperCases = minUpperCases;
  }

  public Integer getMinDigits() {
    return this.minDigits;
  }

  public void setMinDigits(Integer minDigits) {
    this.minDigits = minDigits;
  }

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

  @Override
  public int hashCode() {
    return Objects.hash(minimumPasswordLength, maximumPasswordLength, minLowerCases, minUpperCases,
        minDigits);
  }

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
  public boolean isAcceptableLength(String input){
    Integer length = input.length();
    return (length>= minimumPasswordLength && length<= maximumPasswordLength);

  }

  /**
   * @param input A string for password
   * @return A boolean to state whether the password has valid
   * number of minimum lower cases
   * This is a helper method to isValid()
   */
  public boolean hasMinimumLowerCases(String input){
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
  public boolean hasMinimumUpperCases(String input){
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
  public boolean hasMinimumDigits(String input) {
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

  public boolean hasNoSpace(String input) {
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