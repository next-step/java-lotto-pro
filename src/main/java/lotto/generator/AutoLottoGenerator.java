package lotto.generator;

import lotto.constants.Lotto;
import lotto.model.LottoNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottoGenerator implements LottoGenerator {
  private static final int ZERO = 0;

  @Override
  public LottoNumbers generate() {
    List<Integer> orderedLottoNumbers = getOrderedLottoNumbers();
    Collections.shuffle(orderedLottoNumbers);
    List<Integer> lottoNumbers = peakLottoNumbers(orderedLottoNumbers);
    return new LottoNumbers(lottoNumbers);
  }

  private List<Integer> peakLottoNumbers(List<Integer> lottoNumbers) {
    return lottoNumbers.subList(ZERO, Lotto.LOTTO_NUMBER_RANGE);
  }

  List<Integer> getOrderedLottoNumbers() {
    List<Integer> lottoNumbers = new ArrayList<>();
    for (int i = Lotto.MIN_LOTTO_NUMBER; i <= Lotto.MAX_LOTTO_NUMBER; i++) {
      lottoNumbers.add(i);
    }

    return lottoNumbers;
  }
}
