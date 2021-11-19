package lotto.model;

import lotto.constants.ErrorMessage;
import lotto.exception.InvalidInputException;
import lotto.generator.LottoGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static lotto.constants.ErrorMessage.*;

public class LottoQuantity {
  private static final int MIN_LOTTO_QUANTITY = 1;
  private final int lottoQuantity;

  public LottoQuantity(int lottoQuantity) {
    checkLottoQuantity(lottoQuantity);

    this.lottoQuantity = lottoQuantity;
  }

  private void checkLottoQuantity(int lottoQuantity) {
    if (lottoQuantity < MIN_LOTTO_QUANTITY) {
      throw new InvalidInputException(LOTTO_QUANTITY_LOWER_ERROR_MESSAGE);
    }
  }

  public int getLottoQuantity() {
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

}