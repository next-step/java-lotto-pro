package lotto.model;

import lotto.exception.InvalidInputException;

import java.util.Objects;

import static java.math.BigInteger.ZERO;
import static lotto.constants.ErrorMessage.*;

public class LottoQuantity {
  private static final int MIN_LOTTO_QUANTITY = 0;
  private final int lottoQuantity;

  public LottoQuantity(int lottoQuantity) {
    checkLottoQuantity(lottoQuantity);

    this.lottoQuantity = lottoQuantity;
  }

  public static LottoQuantity of(int lottoQuantity) {
    return new LottoQuantity(lottoQuantity);
  }

  private void checkLottoQuantity(int lottoQuantity) {
    if (lottoQuantity < MIN_LOTTO_QUANTITY) {
      throw new InvalidInputException(LOTTO_QUANTITY_LOWER_ERROR_MESSAGE);
    }
  }

  public int getQuantity() {
    return lottoQuantity;
  }

  @Override
  public String toString() {
    return String.valueOf(lottoQuantity);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LottoQuantity that = (LottoQuantity) o;
    return lottoQuantity == that.lottoQuantity;
  }

  @Override
  public int hashCode() {
    return Objects.hash(lottoQuantity);
  }

  public boolean isZero() {
    return lottoQuantity == ZERO.intValue();
  }
}