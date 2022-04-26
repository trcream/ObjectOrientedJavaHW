package problem1.Functionality;

public abstract class Functionality<T> {
  public String key;

  public Functionality(String key){
    this.key = key;
  }

  public abstract void call(T parameter);
}
