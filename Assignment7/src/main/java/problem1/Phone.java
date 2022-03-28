package problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Phone implements Validator<String> {
  public Integer length;


  public Phone(Integer length) {
    this.length = length;
  }

  public Integer getLength() {
    return this.length;
  }

  public void setLength(Integer length) {
    this.length = length;
  }

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

  @Override
  public int hashCode() {
    return Objects.hash(length);
  }

  @Override
  public String toString() {
    return "Phone{" +
        "length=" + length +
        '}';
  }

  /**
   * @param input
   * @return
   */
  public boolean containsOnlyDigits(String input){
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
    return count>=length;
  }


  /**
   * @param input - General user input to be checked
   * @return A boolean to confirm whether the input is valid for
   * phone number
   */
  @Override
  public boolean isValid(String input) {
    return containsOnlyDigits(input);
  }
}
