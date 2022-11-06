package lotto;

import java.util.HashMap;
import java.util.Map;

import static lotto.common.Constants.LOTTO_MAX_NUM;
import static lotto.common.Constants.LOTTO_MIN_NUM;

public class LottoNumber {
    private static Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();
    private final int lottoNum;

    static {
        for (int i = LOTTO_MIN_NUM; i <= LOTTO_MAX_NUM; i++) {
            lottoNumbers.put(i, new LottoNumber(i));
        }
    }

    private LottoNumber(int num) {
        this.lottoNum = num;
    }

    public static LottoNumber of(int num) {
        LottoNumber lottoNumber = lottoNumbers.get(num);
        if (lottoNumber == null) {
            throw new IllegalArgumentException("로또의 숫자 범위는 1~45입니다.");
        }
        return lottoNumber;
    }

    public int getLottoNum() {
        return lottoNum;
    }
}
