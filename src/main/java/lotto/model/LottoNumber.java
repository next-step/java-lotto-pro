package lotto.model;

import lotto.constants.ErrorMessage;
import lotto.exception.NumberOutOfRangeException;

import java.util.Objects;

import static lotto.constants.Lotto.MAX_LOTTO_NUMBER;
import static lotto.constants.Lotto.MIN_LOTTO_NUMBER;

public class LottoNumber {
  private final int lottoNumber;

  public LottoNumber(int lottoNumber) {
    checkLottoNumberRange(lottoNumber);

    this.lottoNumber = lottoNumber;
  }

  private void checkLottoNumberRange(int lottoNumber) {
    if (lottoNumber < MIN_LOTTO_NUMBER || lottoNumber > MAX_LOTTO_NUMBER) {
      throw new NumberOutOfRangeException(ErrorMessage.NUMBER_OUT_OF_RANGE_ERROR);
    }
  }

  public int getLottoNumber() {
    return lottoNumber;
  }

  @Override
  public String toString() {
    return String.valueOf(lottoNumber);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LottoNumber that = (LottoNumber) o;
    return lottoNumber == that.lottoNumber;
  }

  @Override
  public int hashCode() {
    return Objects.hash(lottoNumber);
  }
}
