package lotto.model;

import java.util.Objects;

public class AutoLottoQuantity implements LottoQuantity {
  private final int autoLottoQuantity;

  public AutoLottoQuantity(int autoLottoQuantity) {
    this.autoLottoQuantity = autoLottoQuantity;
  }

  @Override
  public int getQuantity() {
    return autoLottoQuantity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AutoLottoQuantity that = (AutoLottoQuantity) o;
    return autoLottoQuantity == that.autoLottoQuantity;
  }

  @Override
  public int hashCode() {
    return Objects.hash(autoLottoQuantity);
  }

  @Override
  public String toString() {
    return String.valueOf(autoLottoQuantity);
  }

}
