package step3.domain;

public class LottoNumber implements Comparable<LottoNumber> {

  public static final int MIN_NUMBER = 1;
  public static final int MAX_NUMBER = 45;
  private final int number;

  public LottoNumber(int number) {
    validate(number);
    this.number = number;
  }

  public int getNumber() {
    return number;
  }

  public void validate(int number) {
    if (number > MAX_NUMBER || number < MIN_NUMBER) {
      throw new IllegalArgumentException(
          String.format("[ERROR] LottoNumber should be between (%d, %d)", MIN_NUMBER, MAX_NUMBER));
    }
  }

  @Override
  public int compareTo(LottoNumber o) {
    if (this.number > o.getNumber()) {
      return 1;
    }
    return -1;
  }
}
