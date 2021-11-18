package lotto.model;

import java.util.Comparator;
import java.util.List;

public class LottoNumbers {
  private static final int ZERO = 0;

  private final List<LottoNumber> lottoNumbers;

  public LottoNumbers(List<LottoNumber> lottoNumbers) {
    this.lottoNumbers = lottoNumbers;
  }

  public List<LottoNumber> getLottoNumbers() {
    return lottoNumbers;
  }

  public void sort() {
    lottoNumbers.sort(Comparator.comparingInt(LottoNumber::getLottoNumber));
  }

  public int countNumberOfMatches(LottoNumbers toCompareLottoNumbers) {
    int count = ZERO;
    for (LottoNumber lottoNumber : lottoNumbers) {
      if (toCompareLottoNumbers.hasMatchNumber(lottoNumber)) count++;
    }

    return count;
  }

  public boolean hasBonusNumber(LottoNumber bonusNumber) {
    return lottoNumbers.contains(bonusNumber);
  }

  private boolean hasMatchNumber(LottoNumber lottoNumber) {
    return lottoNumbers.contains(lottoNumber);
  }

  @Override
  public String toString() {
    return lottoNumbers.toString();
  }
}
