package problem1;


import java.util.Objects;

public class Phone implements Validator<String> {
  private Integer length;


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
   * @param input
   * @return
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
