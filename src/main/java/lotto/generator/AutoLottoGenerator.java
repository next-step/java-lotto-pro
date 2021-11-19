package lotto.generator;

import lotto.constants.Lotto;
import lotto.model.LottoNumber;
import lotto.model.LottoNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.constants.Lotto.*;

public class AutoLottoGenerator implements LottoGenerator {
  private static final int ZERO = 0;

  @Override
  public LottoNumbers generate() {
    List<LottoNumber> lottoNumberCandidates = getLottoNumberCandidates();
    Collections.shuffle(lottoNumberCandidates);

    LottoNumbers lottoNumbers = new LottoNumbers(peakLottoNumbers(lottoNumberCandidates));

    lottoNumbers.sort();

    return lottoNumbers;
  }

  private List<LottoNumber> peakLottoNumbers(List<LottoNumber> lottoNumbers) {
    return lottoNumbers.subList(ZERO, LOTTO_NUMBER_RANGE);
  }

  List<LottoNumber> getLottoNumberCandidates() {
    List<LottoNumber> lottoNumbers = new ArrayList<>();
    for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
      lottoNumbers.add(new LottoNumber(i));
    }

    return lottoNumbers;
  }

}