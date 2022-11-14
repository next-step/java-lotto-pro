package lotto.model.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import lotto.model.constants.ErrorMessage;
import lotto.model.constants.LottoConstants;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();
    private int lottoNumber;

    static {
        for (int i = LottoConstants.LOTTO_NUMBER_MIN; i <= LottoConstants.LOTTO_NUMBER_MAX; i++) {
            lottoNumbers.put(i, new LottoNumber(i));
        }
    }

    private LottoNumber(int lottoNumber) {
        validateNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber getLottoNumberByInt(int lottoNumber) {
        if (lottoNumbers.get(lottoNumber) == null) {
            validateNumber(lottoNumber);
        }
        return lottoNumbers.get(lottoNumber);
    }

    public static LottoNumber getLottoNumberByString(String lottoNumber) {
        int number = parseInt(lottoNumber);
        return getLottoNumberByInt(number);
    }

    protected static void validateNumber(int checkValue) {
        if (checkValue < LottoConstants.LOTTO_NUMBER_MIN || checkValue > LottoConstants.LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_CONSTRAINT);
        }
    }

    protected static int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_NOT_STRING);
        }
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.lottoNumber, o.lottoNumber);
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
