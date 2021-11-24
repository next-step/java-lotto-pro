package lotto.generator;

import lotto.model.LottoNumber;
import lotto.model.LottoNumbers;
import lotto.model.LottoQuantity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.constants.Lotto.*;

public class AutoLottoGenerator {
  private static final int ZERO = 0;

  public List<LottoNumbers> generate(LottoQuantity lottoQuantity) {
    List<LottoNumbers> lottoNumbers = new ArrayList<>();

    for (int i = 0; i < lottoQuantity.getQuantity(); i++) {
      lottoNumbers.add(makeLottoNumbers());
    }

    return lottoNumbers;
  }

  private LottoNumbers makeLottoNumbers() {
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