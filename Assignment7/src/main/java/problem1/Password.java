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
  private Integer minimumLength;
  private Integer maximumLength;

  private static final int MIN_LOWER_CASE = 0;
  private static final int MIN_UPPER_CASE = 0;
  private static final int MIN_DIGITS =0;


  /**
   * @param minimumLength Minimum length of password
   * @param maximumLength Maximum length of password
   */
  public Password(Integer minimumLength, Integer maximumLength) {
    this.minimumLength = minimumLength;
    this.maximumLength = maximumLength;
  }

  /**
   * @return Integer: Minimum length within object
   */
  public Integer getMinimumLength() {
    return this.minimumLength;
  }

  /**
   * @param minimumLength Integer: Minimum length within object
   * Set minimum length within object
   */
  public void setMinimumLength(Integer minimumLength) {
    this.minimumLength = minimumLength;
  }

  /**
   * @return Maximum length within object
   */
  public Integer getMaximumLength() {
    return this.maximumLength;
  }

  /**
   * @param maximumLength
   */
  public void setMaximumLength(Integer maximumLength) {
    this.maximumLength = maximumLength;
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
    return Objects.equals(minimumLength, password.minimumLength)
        && Objects.equals(maximumLength, password.maximumLength);
  }

  @Override
  public int hashCode() {
    return Objects.hash(minimumLength, maximumLength);
  }

  @Override
  public String toString() {
    return "Password{" +
        "minimumLength=" + minimumLength +
        ", maximumLength=" + maximumLength +
        '}';
  }

  /**
   * @param input A string for password
   * @return A boolean to state whether the password has a valid length
   * This is a helper method to isValid()
   */
  public boolean isAcceptableLength(String input){
    Integer length = input.length();
    return (length>= minimumLength && length<= maximumLength);

  }

  /**
   * @param input A string for password
   * @return A boolean to state whether the password has valid
   * number of minimum lower cases
   * This is a helper method to isValid()
   */
  public boolean hasMinimumLowerCases(String input){
    Integer count = 0;
    char [] list = new char[input.length()];

    for(int i =0; i<input.length(); i++){
      list[i] = input.charAt(i);
    }

    for(char s : list) {
      if (Character.isLowerCase(s)) {
        count++;
      }
    }
    return count>=MIN_LOWER_CASE;
  }

  /**
   * @param input A string for password
   * @return A boolean to state whether the password has valid
   * number of minimum upper cases
   * This is a helper method to isValid()
   */
  public boolean hasMinimumUpperCases(String input){
    Integer count = 0;
    char [] list = new char[input.length()];

    for(int i =0; i<input.length(); i++){
      list[i] = input.charAt(i);
    }

    for(char s : list) {
      if (Character.isUpperCase(s)) {
        count++;
      }
    }
    return count>=MIN_UPPER_CASE;
  }

  /**
   * @param input A string for password
   * @return A boolean to state whether the password has valid
   * number of minimum digits
   * This is a helper method to isValid()
   */
  public boolean hasMinimumDigits(String input) {
    Integer count = 0;
    char [] list = new char[input.length()];

    for(int i =0; i<input.length(); i++){
      list[i] = input.charAt(i);
    }

    for(char s : list) {
      if (Character.isDigit(s)) {
        count++;
      }
    }
    return count>=MIN_DIGITS;
  }

  /**
   * @param input A string for password
   * @return A boolean to state whether the password has
   * no space
   * This is a helper method to isValid()
   */
  public boolean hasNoSpace(String input) {
    for (int i = 0; i < input.length(); i++) {
      if (String.valueOf(input.charAt(i)).equals(" ") ) {
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



// https://www.tutorialspoint.com/check-whether-a-character-is-lowercase-or-not-in-java#:~:text=To%20check%20whether%20a%20character,isLowerCase()%20method.