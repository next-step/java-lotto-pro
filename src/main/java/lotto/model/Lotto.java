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

  public int countMatchingNumber(Lotto targetLotto) {
    int count = 0;

    List<Integer> targetLottoNumber = targetLotto.getNumbers();

    for (Integer i : targetLottoNumber) {
      if (this.numbers.contains(i)) {
        count++;
      }
    }

    return count;
  }

}
