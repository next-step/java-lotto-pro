package lotto.auto.model;

import static lotto.auto.constant.LottoSetting.LOTTO_NUMBER_RANGE_MAX;
import static lotto.auto.constant.LottoSetting.LOTTO_NUMBER_RANGE_MIN;

public class LottoNumber {

    private final int lottoNumber;

    public LottoNumber(int number) {
        if (number < LOTTO_NUMBER_RANGE_MIN || number > LOTTO_NUMBER_RANGE_MAX) {
            throw new IllegalArgumentException(
                String.format("로또 숫자는 %d ~ %d 사이값만 가능합니다.", LOTTO_NUMBER_RANGE_MIN, LOTTO_NUMBER_RANGE_MAX));
        }

        this.lottoNumber = number;
    }

}
