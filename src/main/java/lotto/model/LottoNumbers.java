package lotto.model;

import lotto.constants.Lotto;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static lotto.constants.ErrorMessage.*;

public class LottoNumbers {
  private final List<Integer> lottoNumbers;

  public LottoNumbers(List<Integer> lottoNumbers) {
    checkLottoNumbers(lottoNumbers);
    this.lottoNumbers = lottoNumbers;
  }

  private void checkLottoNumbers(List<Integer> lottoNumbers) {
    checkLottoNumbersRange(lottoNumbers);
    for (Integer lottoNumber : lottoNumbers) {
      checkLottoNumberValidation(lottoNumber);
    }
    checkLottoNumbersDuplicate(lottoNumbers);
  }

  private void checkLottoNumbersDuplicate(List<Integer> lottoNumbers) {
    Set<Integer> set = new LinkedHashSet<>(lottoNumbers);
    if (set.size() != Lotto.LOTTO_NUMBER_RANGE) {
      throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE_ERROR);
    }
  }

  private void checkLottoNumbersRange(List<Integer> lottoNumbers) {
    if (lottoNumbers.size() != Lotto.LOTTO_NUMBER_RANGE) {
      throw new IllegalArgumentException(LOTTO_NUMBERS_RANGE_ERROR);
    }
  }

  private void checkLottoNumberValidation(Integer lottoNumber) {
    if (!(lottoNumber >= Lotto.MIN_LOTTO_NUMBER && lottoNumber <= Lotto.MAX_LOTTO_NUMBER)) {
      throw new IllegalArgumentException(ILLEGAL_LOTTO_NUMBER_ERROR);
    }
  }

  public int countOfMatch(LottoNumbers targetLottoNumbers) {
    int count = 0;
    for (Integer lottoNumber : targetLottoNumbers.lottoNumbers) {
      count += matchCount(lottoNumber);
    }
    return count;
  }

  private int matchCount(Integer lottoNumber) {
    if (lottoNumbers.contains(lottoNumber)) {
      return 1;
    }
    return 0;
  }

  public boolean hasBonusNumber(int bonusNumber) {
    return lottoNumbers.contains(bonusNumber);
  }

  @Override
  public String toString() {
    return lottoNumbers.toString();
  }
}
