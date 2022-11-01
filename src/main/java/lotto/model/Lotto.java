package lotto.model;

import java.util.List;
import lotto.util.LottoGenerator;

public class Lotto {

  private final List<Integer> numbers;

  public Lotto(List<Integer> numbers) {
    this.numbers = numbers;
  }

  public static Lotto createAutoLotto() {
    return new Lotto(LottoGenerator.generateLottoNumbers());
  }

  public static Lotto createManualLotto(List<Integer> numbers) {
    return new Lotto(numbers);
  }

  public List<Integer> getNumbers() {
    return this.numbers;
  }

  public int getMatchingCount(Lotto targetLotto) {
    int count = 0;

    List<Integer> targetLottoNumber = targetLotto.getNumbers();

    for (int number : targetLottoNumber) {
      count = this.countContainNumber(number, count);
    }

    return count;
  }

  public boolean isContainNumber(int number) {
    return this.numbers.contains(number);
  }

  private int countContainNumber(int number, int count) {
    return isContainNumber(number) ? count + 1 : count;
  }
}
