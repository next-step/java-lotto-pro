package lotto.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lotto.util.LottoGenerator;

public class Lotto {

  private final List<LottoNumber> numbers;

  public Lotto(List<Integer> numbers) {
    List<LottoNumber> lottoNumbers = numbers.stream().map(LottoNumber::from)
        .collect(Collectors.toList());
    this.numbers = lottoNumbers;
  }

  public static Lotto createAutoLotto() {
    return new Lotto(LottoGenerator.generateLottoNumbers());
  }

  public static Lotto createManualLotto(List<Integer> numbers) {
    return new Lotto(numbers);
  }

  public List<LottoNumber> getNumbers() {
    return this.numbers;
  }

  public int getMatchingCount(Lotto targetLotto) {
    int count = 0;

    List<LottoNumber> targetLottoNumber = targetLotto.getNumbers();

    for (LottoNumber number : targetLottoNumber) {
      count = this.countContainNumber(number, count);
    }

    return count;
  }

  public boolean isContainNumber(LottoNumber number) {
    return this.numbers.contains(number);
  }

  private int countContainNumber(LottoNumber number, int count) {
    return isContainNumber(number) ? count + 1 : count;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Lotto lotto = (Lotto) o;
    return Objects.equals(numbers, lotto.numbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numbers);
  }
}
