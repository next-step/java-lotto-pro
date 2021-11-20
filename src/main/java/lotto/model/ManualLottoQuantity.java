package lotto.model;

import lotto.constants.ErrorMessage;
import lotto.exception.NumberOutOfRangeException;

import java.util.Objects;

public class ManualLottoQuantity implements LottoQuantity {
  private static final int MINIMUM_QUANTITY = 0;
  private final int manualLottoQuantity;

  public ManualLottoQuantity(int manualLottoQuantity) {
    checkManualLottoQuantity(manualLottoQuantity);

    this.manualLottoQuantity = manualLottoQuantity;
  }

  private void checkManualLottoQuantity(int manualLottoQuantity) {
    if (manualLottoQuantity < MINIMUM_QUANTITY) {
      throw new NumberOutOfRangeException(ErrorMessage.MANUAL_LOTTO_QUANTITY_LOWER_ERROR_MESSAGE);
    }
  }

  public int gapWithTotalQuantity(int lottoQuantity) {
    return lottoQuantity - manualLottoQuantity;
  }

  @Override
  public int getQuantity() {
    return manualLottoQuantity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ManualLottoQuantity that = (ManualLottoQuantity) o;
    return manualLottoQuantity == that.manualLottoQuantity;
  }

  @Override
  public int hashCode() {
    return Objects.hash(manualLottoQuantity);
  }

  @Override
  public String toString() {
    return String.valueOf(manualLottoQuantity);
  }

}
