package lotto.domain.lotto;

public class Lotto {
  public static final Integer PRICE = 1000;
  private final LottoNumbers numbers;

  private Lotto(LottoNumbers numbers) {
    this.numbers = numbers;
  }

  public static Lotto valueOf(String ... numbers) {
    return new Lotto(LottoNumbers.valueOf(numbers));
  }
  
  public static Lotto valueOf(LottoNumbers numbers) {
    return new Lotto(numbers);
  }

  public LottoNumbers getNumbers() {
    return this.numbers;
  }

  public Integer matchCount(Lotto latestWinLotto) {
    return latestWinLotto.numbers.countOf(this.numbers)
                                  .intValue();
  }
}
