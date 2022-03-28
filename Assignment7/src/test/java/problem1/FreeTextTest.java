package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FreeTextTest {

  private Field testField;
  private FreeText testFreeText;
  private FreeText testFreeText2;

  @BeforeEach
  void setUp() {
    testFreeText = new FreeText(3, 50);
    testFreeText2 = new FreeText(1, 15);

    testField = new Field<>("FreeText", false, testFreeText);
    //testField.setValue("Setting the values to be tested");
  }

  @Test
  void getNumberOfLines() {
    assertEquals(3, testFreeText.getNumberOfLines());
  }

  @Test
  void setNumberOfLines() {
    testFreeText.setNumberOfLines(5);
    assertEquals(5, testFreeText.getNumberOfLines());
  }

  @Test
  void getNumberOfCharactersPerLine() {
    assertEquals(50, testFreeText.getNumberOfCharactersPerLine());
  }

  @Test
  void setNumberOfCharactersPerLine() {
    testFreeText.setNumberOfCharactersPerLine(100);
    assertEquals(100, testFreeText.getNumberOfCharactersPerLine());
  }

  @Test
  void testEqualsSameObject() {
    assertTrue(testFreeText.equals(testFreeText));
  }

  @Test
  void testEqualsDifferentObject() {
    assertFalse(testFreeText.equals(testFreeText2));
  }

  @Test
  void testEqualsNullObject() {
    assertFalse(testFreeText.equals(null));
  }

  @Test
  void testHashCode() {
    int expectedHash = Objects.hash(testFreeText.getNumberOfLines(), testFreeText.getNumberOfCharactersPerLine());
    assertEquals(expectedHash, testFreeText.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "FreeText{" +
        "numberOfLines=" + testFreeText.getNumberOfLines() +
        ", numberOfCharactersPerLine=" + testFreeText.getNumberOfCharactersPerLine() +
        '}';
    assertEquals(expectedString, testFreeText.toString());
  }

  @Test
  void isValid() {

    assertEquals(true,testFreeText.isValid("Testing the Free Text Validator"));
    assertEquals(false, testFreeText2.isValid("This should not pass this test"));
    assertEquals(true, testField.getValidator().isValid(("Testing the Free Text Validator")));

  }
}