package lotto.domain;

public class Lotto {
  private final LottoNumbers value;

  public Lotto(LottoNumbers value) {
    this.value = value;
  }

  public String toString() {
    return value.toString();
  }
}
