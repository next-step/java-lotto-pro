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
        setLottoNumber(lottoNumber);
    }

    public static LottoNumber getLottoNumberByInt(int lottoNumber) {
        if (lottoNumbers.get(lottoNumber) == null) {
            return new LottoNumber(lottoNumber);
        }
        return lottoNumbers.get(lottoNumber);
    }

    public static LottoNumber getLottoNumberByString(String lottoNumber) {
        int number = parseInt(lottoNumber);
        return getLottoNumberByInt(number);
    }

    protected static boolean validateNumber(int checkValue) {
        return checkValue >= LottoConstants.LOTTO_NUMBER_MIN && checkValue <= LottoConstants.LOTTO_NUMBER_MAX;
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

    private void setLottoNumber(int lottoNumber) {
        if (!validateNumber(lottoNumber)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_CONSTRAINT);
        }
        this.lottoNumber = lottoNumber;
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
