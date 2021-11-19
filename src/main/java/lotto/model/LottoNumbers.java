package lotto.model;

import lotto.constants.ErrorMessage;
import lotto.constants.Lotto;
import lotto.exception.DuplicateNumberException;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumbers {
  private static final int ZERO = 0;

  private final List<LottoNumber> lottoNumbers;

  public LottoNumbers(List<LottoNumber> lottoNumbers) {
    checkLottoNumbers(lottoNumbers);
    this.lottoNumbers = lottoNumbers;
  }

  private void checkLottoNumbers(List<LottoNumber> lottoNumbers) {
    Set<LottoNumber> lottoNumbersSet = new HashSet<>(lottoNumbers);

    if (lottoNumbersSet.size() < Lotto.LOTTO_NUMBER_RANGE) {
      throw new DuplicateNumberException(ErrorMessage.LOTTO_NUMBER_DUPLICATE_ERROR_MESSAGE);
    }
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