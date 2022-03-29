package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CheckBoxTest {
  private CheckBox testCheckBox;


  @BeforeEach
  void setUp() {
    testCheckBox = new CheckBox();

  }
  @Test
  void isValid() {
    assertTrue(testCheckBox.isValid(Boolean.TRUE));
    assertTrue(testCheckBox.isValid(Boolean.FALSE));
    assertTrue(testCheckBox.isValid());


  }

  @Test
  void testHashCode() {

  }

  @Test
  void testEquals() {
  }

  @Test
  void testToString() {
    String expectedString = "CheckBox{}";
    assertEquals(expectedString,testCheckBox.toString());


  }
}

