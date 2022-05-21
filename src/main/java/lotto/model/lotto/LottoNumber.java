package lotto.model.lotto;

import java.util.Objects;
import lotto.constant.LottoSetting;

public class LottoNumber {

    private final int lottoNumber;

    public LottoNumber(int number) {
        if (number < LottoSetting.LOTTO_NUMBER_RANGE_MIN || number > LottoSetting.LOTTO_NUMBER_RANGE_MAX) {
            throw new IllegalArgumentException(
                String.format("로또 숫자는 %d ~ %d 사이값만 가능합니다.",
                    LottoSetting.LOTTO_NUMBER_RANGE_MIN,
                    LottoSetting.LOTTO_NUMBER_RANGE_MAX));
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

    @Override
    public String toString() {
        return String.valueOf(this.lottoNumber);
    }

}
