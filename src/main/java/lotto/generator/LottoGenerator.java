package lotto.generator;

import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;

public interface LottoGenerator {
  int LOTTO_PRICE = 1000;
  int MIN_LOTTO_NUMBER = 1;
  int MAX_LOTTO_NUMBER = 45;
  int LOTTO_NUMBER_RANGE = 6;

  Lotto generate();

  default List<Integer> getLottoNumbers() {
    List<Integer> lottoNumbers = new ArrayList<>();
    for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
      lottoNumbers.add(i);
    }

    return lottoNumbers;
  }
}
