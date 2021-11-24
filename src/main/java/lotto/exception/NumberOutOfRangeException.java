package lotto.exception;

public class NumberOutOfRangeException extends RuntimeException {
  public NumberOutOfRangeException() {
    super();
  }

  public NumberOutOfRangeException(String message) {
    super(message);
  }

}