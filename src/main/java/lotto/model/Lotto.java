package lotto.model;

import java.util.List;
import lotto.util.LottoGenerator;

public class Lotto {

  private final List<Integer> numbers;

  public Lotto() {
    numbers = LottoGenerator.generateLottoNumbers();
  }

  public List<Integer> getNumbers() {
    return this.numbers;
  }

}
