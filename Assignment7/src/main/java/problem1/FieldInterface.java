package problem1;

/**
 * Interface for a field class.
 * @param <T> - Generic data type.
 */

public interface FieldInterface<T> {

  public void updateValue(T input) throws InvalidInputException;
  public Boolean isFilled();
}
