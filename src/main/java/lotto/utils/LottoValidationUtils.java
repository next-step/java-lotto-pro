package lotto.utils;

import lotto.domain.LottoNumbers;

public class LottoValidationUtils {

    private LottoValidationUtils() {
        throw new UnsupportedOperationException();
    }

    public static void validateNumberRange(Integer number) {
        if (number < LottoNumbers.MIN_NUMBER || number > LottoNumbers.MAX_NUMBER) {
            throw new IllegalArgumentException("로또번호는 1에서 45사이의 숫자여만 합니다.");
        }
    }

}
