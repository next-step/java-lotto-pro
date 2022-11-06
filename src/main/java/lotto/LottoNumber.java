package lotto;

import static lotto.common.Constants.LOTTO_MAX_NUM;
import static lotto.common.Constants.LOTTO_MIN_NUM;

public class LottoNumber {
    int lottoNum;

    public LottoNumber(int num) {
        if (num < LOTTO_MIN_NUM || num > LOTTO_MAX_NUM) {
            throw new IllegalArgumentException("로또의 숫자 범위는 1~45입니다.");
        }
        this.lottoNum = num;
    }

    public int getLottoNum() {
        return lottoNum;
    }
}
