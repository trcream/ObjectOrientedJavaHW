package problem1;

public class FreeText implements Validator<String> {
  public String input;
  public Integer numberOfLines;
  public Integer numberOfCharactersPerLine;

  // constructor
  // getters and setters
  // equals and hashcode
  // string

  public boolean freeTextValid(String input){
    int length = input.length();
    int maximumLength = this.numberOfCharactersPerLine*this.numberOfCharactersPerLine;

    if(length <=maximumLength){
      return true;
    }
    else{
      return false;
    }

  }

  @Override
  public boolean isValid(String input) {
    return freeTextValid(input);
  }
}
