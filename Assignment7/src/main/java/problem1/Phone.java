package problem1;

import java.util.ArrayList;
import java.util.List;

public class Phone implements Validator<String> {
  private Integer length;

  // constructor
  // getters and setters
  // equals and hashcode
  // string


  public boolean containsOnlyDigits(String input){
    List<Character> list = new ArrayList<Character>(Integer.parseInt(input));
    Integer count = 0;
    for(Character s : list) {
      if (Character.isDigit(s)) {
        count++;
      }
    }
    return count.equals(length);
  }



  @Override
  public boolean isValid(String input) {
    return containsOnlyDigits(input);
  }
}
