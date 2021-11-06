package lotto.domain.lotto;

public class Lotto {
  public static final Integer PRICE = 1000;
  private final LottoNumbers value;

  public Lotto(LottoNumbers value) {
    this.value = value;
  }

  public Lotto() {
    this.value = LottoNumbers.valueOf();
  }

  public static Lotto valueOf(String ... values) {
    return new Lotto(LottoNumbers.valueOf(values));
  }

  public String toString() {
    return value.toString();
  }

  public Integer matchCount(Lotto latestWinLotto) {
    return latestWinLotto.value.countOf(this.value)
                                .intValue();
  }
}
