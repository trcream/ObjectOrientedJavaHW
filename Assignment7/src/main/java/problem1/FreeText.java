package problem1;

import java.util.Objects;

/**
 * FreeText: This validator will be used for free text fields such as messages or
 * comments. Client code will provide the number of lines in the text field and the number
 * of characters allowed per line. To be valid, input must be no longer than the number of
 * lines multiplied by the number of characters allowed per line.
 */
public class FreeText implements Validator<String> {
  public Integer numberOfLines;
  public Integer numberOfCharactersPerLine;

  /**
   * @param numberOfLines Number of lines in text box
   * @param numberOfCharactersPerLine number of characters per line
   */
  public FreeText(Integer numberOfLines, Integer numberOfCharactersPerLine) {
    this.numberOfLines = numberOfLines;
    this.numberOfCharactersPerLine = numberOfCharactersPerLine;
  }

  /**
   * @return Integer: number of lines within object
   */
  public Integer getNumberOfLines() {
    return this.numberOfLines;
  }

  /**
   * @param numberOfLines Integer: number of lines within object
   * set the number of lines within object
   */
  public void setNumberOfLines(Integer numberOfLines) {
    this.numberOfLines = numberOfLines;
  }

  /**
   * @return Integer: number of characters per line within object
   */
  public Integer getNumberOfCharactersPerLine() {
    return this.numberOfCharactersPerLine;
  }


  /**
   * @param numberOfCharactersPerLine Integer: Number of characters per line
   * set the number of characters per line within object
   */
  public void setNumberOfCharactersPerLine(Integer numberOfCharactersPerLine) {
    this.numberOfCharactersPerLine = numberOfCharactersPerLine;
  }

  /**
   * @param o Object
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
    FreeText freeText = (FreeText) o;
    return Objects.equals(numberOfLines, freeText.numberOfLines)
        && Objects.equals(numberOfCharactersPerLine, freeText.numberOfCharactersPerLine);
  }

  /**
   * @return int: Hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(numberOfLines, numberOfCharactersPerLine);
  }

  /**
   * @return String: String value of number of lines and number of characters per line
   */
  @Override
  public String toString() {
    return "FreeText{" +
        "numberOfLines=" + numberOfLines +
        ", numberOfCharactersPerLine=" + numberOfCharactersPerLine +
        '}';
  }

  public boolean freeTextLength(String input){
    int length = input.length();
    int maximumLength = this.numberOfLines*this.numberOfCharactersPerLine;
    return length <=maximumLength;
  }

  /**
   * @param input - General user input to be checked
   * @return A boolean to confirm whether the input is valid for
   * FreeText
   */
  @Override
  public boolean isValid(String input) {
    return freeTextLength(input);
  }
}
