package lotto.domain.lotto;

import java.util.List;

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

  public List<String> getNumbersToString() {
    return this.numbers.getNumbersToString();
  }

  public Integer matchCountOf(Lotto buyLotto) {
    return this.numbers.countOf(buyLotto.numbers)
                       .intValue();
  }
}
