package lotto.model;

import java.util.List;
import lotto.util.LottoGenerator;

public class Lotto {

  private final List<Integer> numbers;

  public Lotto() {
    numbers = LottoGenerator.generateLottoNumbers();
  }

  public Lotto(List<Integer> numbers) {
    this.numbers = numbers;
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

  private int countContainNumber(int number, int count) {
    return this.numbers.contains(number) ? count+1 : count;
  }


}
