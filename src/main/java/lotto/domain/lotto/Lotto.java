package lotto.domain.lotto;

import java.util.List;
import java.util.Objects;

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
  
  public boolean containLottoNumber(LottoNumber bonusNumber) {
    return this.numbers.contains(bonusNumber);
  }

  public static Lotto gererate() {
    return Lotto.valueOf(LottoNumbers.generate());
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Lotto)) {
      return false;
    }
    Lotto lotto = (Lotto) o;
    return Objects.equals(numbers, lotto.numbers);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(numbers);
  }
}
