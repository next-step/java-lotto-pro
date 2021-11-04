package lotto.domain;

public class LottoNumber {
  private final String value;

  public LottoNumber(String value) {
    this.value = value;
  }

  public static LottoNumber valueOf(String value) {
    return new LottoNumber(value);
  }

  public static LottoNumber valueOf(Integer value) {
    return new LottoNumber(String.valueOf(value));
  }

  public String toString() {
    return value;
  }
}
