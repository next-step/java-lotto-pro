package lotto.generator;

import lotto.model.Lotto;

import java.util.Collections;
import java.util.List;

public class AutoLottoGenerator implements LottoGenerator {
  private static final int ZERO = 0;

  @Override
  public Lotto generate() {
    List<Integer> lottoNumbers = peakLottoNumbers(shuffle(getLottoNumbers()));
    return new Lotto(lottoNumbers);
  }

  private List<Integer> peakLottoNumbers(List<Integer> lottoNumbers) {
    return lottoNumbers.subList(ZERO, LOTTO_NUMBER_RANGE);
  }

  private List<Integer> shuffle(List<Integer> lottoNumbers) {
    Collections.shuffle(lottoNumbers);
    return lottoNumbers;
  }
}
