package lotto.domain;


public class LottoNumber {
    private final static int LOTTO_NUMBER_MIN_VALUE = 1;
    private final static int LOTTO_NUMBER_MAX_VALUE = 45;

    private static final String ERROR_LOTTO_NUMBER_OUT_OF_RANGE_MESSAGE = "[ERROR] 로또 번호는 1 ~ 45 사이의 숫자로 구성되어야합니다.";
    private final Integer number;

    public LottoNumber(Integer number) {
        if (!isValidRangeLottoNumber(number)) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_OUT_OF_RANGE_MESSAGE);
        }

        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    private boolean isValidRangeLottoNumber(Integer number) {
        return  number >= LOTTO_NUMBER_MIN_VALUE && number <= LOTTO_NUMBER_MAX_VALUE;
    }

    @Override
    public String toString() {
        return number.toString();
    }
}

