package problem1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Password implements Validator<String> {
  private Integer minimumLength;
  private Integer maximumLength;
  private Integer lowerCase;
  private Integer upperCase;
  private Integer digits;

  // constructor
  // getters and setters
  // equals and hashcode
  // string


  public boolean isAcceptableLength(String input){
    Integer length = input.length();
    return (length>= minimumLength && length<= maximumLength);

  }

  public boolean hasMinimumLowerCases(String input){
    Integer count = 0;
    List<Character> list = new ArrayList<Character>(Integer.parseInt(input));
    for(Character s : list) {
      if (Character.isLowerCase(s)) {
        count++;
      }
    }
    return count>=lowerCase;
  }

  public boolean hasMinimumUpperCases(String input){
    Integer count = 0;
    List<Character> list = new ArrayList<Character>(Integer.parseInt(input));
    for(Character s : list) {
      if (Character.isUpperCase(s)) {
        count++;
      }
    }
    return (count>=upperCase);
  }

  public boolean hasMinimumDigits(String input) {
    Integer count = 0;
    List<Character> list = new ArrayList<Character>(Integer.parseInt(input));
    for(Character s : list) {
      if (Character.isDigit(s)) {
        count++;
      }
    }
    return count>=digits;
  }


  public boolean hasNoSpace(String input){
    Integer count = 0;
    List<String> list = new ArrayList<String>(Collections.singleton(input));
    for(String s : list) {
      if (s == " ") {
        return false;
      }
    }
    return true;
  }


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