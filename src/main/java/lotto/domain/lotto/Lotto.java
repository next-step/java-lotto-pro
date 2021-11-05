package lotto.domain.lotto;

public class Lotto {
  private static final Integer PRICE = 1000;
  private final LottoNumbers value;

  public Lotto(LottoNumbers value) {
    this.value = value;
  }

  public Lotto() {
    this.value = LottoNumbers.valueOf();
  }

  public static Lotto valueOf(String ... values) {
    checkLottoNumberCount(values);

    return new Lotto(LottoNumbers.valueOf(values));
  }

  private static void checkLottoNumberCount(String... values) {
    if (values.length != 6) {
      throw new IllegalArgumentException("로또 번호의 갯수가 6개가 아닙니다.");
    }
  }

  public String toString() {
    return value.toString();
  }

  public static Integer getPrice() {
    return Lotto.PRICE;
  }

  public Integer matchCount(Lotto latestWinLotto) {
    return latestWinLotto.value.countOf(this.value)
                                .intValue();
  }
}
