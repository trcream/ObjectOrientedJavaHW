package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumberTest {
  private Number testNumber;
  private Number testNumber2;
  private MinMaxValueException testNumber3;

  @BeforeEach
  void setUp() throws NegativeDecimalPlacesException, MinMaxValueException {
    testNumber = new Number(10,2,2);
    testNumber2 = new Number(5,2,2);
    testNumber3 = new MinMaxValueException("You can't have negative decimal places");

  }

  @Test
  void getMaximumValue() {
    assertEquals(10,testNumber.getMaximumValue());
  }

  @Test
  void setMaximumValue() throws MinMaxValueException {
    testNumber.setMaximumValue(9);
    assertEquals(9,testNumber.getMaximumValue());

  }

  @Test
  void getMinimumValue() {
    assertEquals(2,testNumber.getMinimumValue());
  }

  @Test
  void setMinimumValue() throws MinMaxValueException {
    testNumber.setMinimumValue(5);
    assertEquals(5,testNumber.getMinimumValue());
  }

  @Test
  void getMaximumDecimalPlaces() {
    assertEquals(2,testNumber.getMaximumDecimalPlaces());
  }

  @Test
  void setMaximumDecimalPlaces() throws NegativeDecimalPlacesException {
    testNumber.setMaximumDecimalPlaces(4);
    assertEquals(4,testNumber.getMaximumDecimalPlaces());
  }
// Commenting these out because these are helper methods, which are private methods
//  @Test
//  void testCheckNumber() {
//    assertFalse(testNumber.checkNumber(""));
//    assertTrue(testNumber.checkNumber("4.32"));
//    assertTrue(testNumber.checkNumber("4"));
//    assertFalse(testNumber.checkNumber("4a"));
//  }

//  @Test
//  void checkValue() {
//    assertTrue(testNumber.checkValue("4.32"));
//    assertFalse(testNumber.checkValue("11"));
//    assertFalse(testNumber.checkValue("1"));

//  }
//
//  @Test
//  void testCheckDecimalPlaces() {
//    assertTrue(testNumber.checkDecimalPlaces("4.32"));
//    assertFalse(testNumber.checkDecimalPlaces("23.3242"));
//    assertTrue(testNumber.checkDecimalPlaces("23"));
//  }

  @Test
  void testIsValid() {
    assertTrue(testNumber.isValid("4.32"));


  }

  @Test
  void testEquals() {
    Number expectedObject = testNumber;
    assertTrue(testNumber.equals(expectedObject));
    assertFalse(testNumber.equals(testNumber2));

  }

  @Test
  void testHashCode() {
    int expectedHashcode = Objects.hashCode(testNumber);
    assertEquals(expectedHashcode,testNumber.hashCode());

  }

  @Test
  void testToString() {
    String expectedString = "Number{" +
        "maximumValue=" + testNumber.getMaximumValue() +
        ", minimumValue=" + testNumber.getMinimumValue() +
        ", maximumDecimalPlaces=" + testNumber.getMaximumDecimalPlaces() +
        '}';

    assertEquals(expectedString, testNumber.toString());

  }
}

