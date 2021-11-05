package lotto.domain.lotto;

import java.util.Objects;

public class LottoNumber {
  private final String value;
  private static final Integer LOTTO_START_NUMBER = 1;
  private static final Integer LOTTO_END_NUMBER = 45;
  private LottoNumber(String value) {
    chekInvalidArgument(value.trim());

    this.value = value.trim();
  }

  private void chekInvalidArgument(String value) {
    if (isInvalidLottoNumberRange(value)) {
      throw new IllegalArgumentException("유효하지 않은 로또 번호입니다.");
    }
  }

  private boolean isInvalidLottoNumberRange(String value) {
    return Integer.valueOf(value) < LOTTO_START_NUMBER || Integer.valueOf(value) > LOTTO_END_NUMBER;
  }

  public static LottoNumber valueOf(String value) {
    return new LottoNumber(value);
  }

  public static LottoNumber valueOf(Integer value) {
    return new LottoNumber(String.valueOf(value));
  }

  public String toString() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }

    if (!(o instanceof LottoNumber)) {
      return false;
    }

    LottoNumber lottoNumber = (LottoNumber) o;

    return Objects.equals(value, lottoNumber.value);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }

}
