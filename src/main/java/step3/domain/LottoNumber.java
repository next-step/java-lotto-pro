package step3.domain;

public class LottoNumber {

  public static final int MIN_NUMBER = 1;
  public static final int MAX_NUMBER = 45;

  private final int number;

  public LottoNumber(int number) {
    this.number = number;
    validate();
  }

  public void validate() {
    if (this.number > MAX_NUMBER || this.number < MIN_NUMBER) {
      throw new RuntimeException(
          String.format("[ERROR] LottoNumber should be between (%d, %d)", MIN_NUMBER, MAX_NUMBER));
    }
  }

  public int getNumber() {
    return number;
  }
}
