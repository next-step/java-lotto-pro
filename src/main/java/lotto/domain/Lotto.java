package lotto.domain;

public class Lotto {
  private final LottoNumbers value;

  public Lotto(LottoNumbers value) {
    this.value = value;
  }

  public static Lotto valueOf(String ... values) {
    return new Lotto(LottoNumbers.valueOf(values));
  }

  public String toString() {
    return value.toString();
  }
}
