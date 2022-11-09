package lotto;

import lotto.common.exception.LottoNullException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

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
        Optional.ofNullable(lottoNumbers.get(num))
                .orElseThrow(() -> new LottoNullException("로또의 숫자 범위는 1~45입니다."));

        return lottoNumber;
    }

    public int getLottoNum() {
        return lottoNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNum == that.lottoNum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNum);
    }
}
