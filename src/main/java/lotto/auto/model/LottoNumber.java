package lotto.auto.model;

import static lotto.auto.constant.LottoSetting.LOTTO_NUMBER_RANGE_MAX;
import static lotto.auto.constant.LottoSetting.LOTTO_NUMBER_RANGE_MIN;

import java.util.Objects;

public class LottoNumber {

    private final int lottoNumber;

    public LottoNumber(int number) {
        if (number < LOTTO_NUMBER_RANGE_MIN || number > LOTTO_NUMBER_RANGE_MAX) {
            throw new IllegalArgumentException(
                String.format("로또 숫자는 %d ~ %d 사이값만 가능합니다.", LOTTO_NUMBER_RANGE_MIN, LOTTO_NUMBER_RANGE_MAX));
        }

        this.lottoNumber = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

}
