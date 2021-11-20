package lotto.model;

import lotto.exception.InvalidInputException;

import java.util.Objects;

import static lotto.constants.ErrorMessage.*;

public class TotalLottoQuantity implements LottoQuantity {
  private static final int MIN_QUANTITY = 1;

  private final int totalLottoQuantity;

  public TotalLottoQuantity(int totalLottoQuantity) {
    checkLottoQuantity(totalLottoQuantity);

    this.totalLottoQuantity = totalLottoQuantity;
  }

  public ManualLottoQuantity ofManualLottoQuantity(int quantity) {
    checkManualLottoQuantity(quantity);

    return new ManualLottoQuantity(quantity);
  }

  public AutoLottoQuantity calculateAutoLottoQuantity(ManualLottoQuantity manualLottoQuantity) {
    return new AutoLottoQuantity(manualLottoQuantity.gapWithTotalQuantity(totalLottoQuantity));
  }

  private void checkLottoQuantity(int lottoQuantity) {
    if (lottoQuantity < MIN_QUANTITY) {
      throw new InvalidInputException(LOTTO_QUANTITY_LOWER_ERROR_MESSAGE);
    }
  }

  private void checkManualLottoQuantity(int manualLottoQuantity) {
    if (manualLottoQuantity > totalLottoQuantity) {
      throw new InvalidInputException(MANUAL_LOTTO_QUANTITY_OVER_ERROR_MESSAGE);
    }
  }

  @Override
  public int getQuantity() {
    return totalLottoQuantity;
  }

  @Override
  public String toString() {
    return String.valueOf(totalLottoQuantity);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TotalLottoQuantity that = (TotalLottoQuantity) o;
    return totalLottoQuantity == that.totalLottoQuantity;
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalLottoQuantity);
  }

}