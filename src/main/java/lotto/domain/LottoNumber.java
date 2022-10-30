package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import common.constant.ErrorCode;

public class LottoNumber implements Comparable<LottoNumber> {

    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

    private static final Map<Integer, LottoNumber> lottoNumberCache = new HashMap<>();

    static {
        for(int lottoNumber = MIN_LOTTO_NUMBER; lottoNumber <= MAX_LOTTO_NUMBER; lottoNumber++) {
            lottoNumberCache.put(lottoNumber, new LottoNumber(lottoNumber));
        }
    }

    private final int lottoNumber;

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber from(int lottoNumber) {
        validateLottoNumber(lottoNumber);
        return lottoNumberCache.get(lottoNumber);
    }

    /**
     * 주어진 Lotto 내 속한 lottoNumber를 꺼내고자 할 경우 exception 발생
     * @param lottoNumber 꺼내고자 하는 lottoNumber
     * @param lotto lottoNumber가 속했는지 확인할 로또
     * @return 캐싱된 lottoNumber
     */
    public static LottoNumber fromIfNotIn(int lottoNumber, Lotto lotto) {
        if(lotto.isMatchLottoNumber(LottoNumber.from(lottoNumber))) {
            throw new IllegalArgumentException(ErrorCode.보너스_볼은_당첨_로또의_각_숫자와_중복_불가.getErrorMessage());
        }
        return lottoNumberCache.get(lottoNumber);
    }

    private static void validateLottoNumber(int lottoNumber) {
        if(!isInLottoNumberRange(lottoNumber)) {
            throw new IllegalArgumentException(ErrorCode.로또의_각_숫자는_1이상_45이하.getErrorMessage());
        }
    }

    private static boolean isInLottoNumberRange(int lottoNumber) {
        return lottoNumber >= MIN_LOTTO_NUMBER && lottoNumber <= MAX_LOTTO_NUMBER;
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        return Integer.compare(this.lottoNumber, lottoNumber.lottoNumber);
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
        return String.valueOf(lottoNumber);
    }
}
