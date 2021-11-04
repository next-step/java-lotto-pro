package study.lotto.model;

public class LottoNumber {

    private static final String MAL_FORMED_LOTTO_NUMBER_MESSAGE = "로또번호는 1부터 45까지의 숫자로 구성되어야 합니다.";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final int lottoNumber;

    private LottoNumber(final int lottoNumber) {
        validate(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber valueOf(final int lottoNumber) {
        return new LottoNumber(lottoNumber);
    }

    public int getValue() {
        return this.lottoNumber;
    }

    private void validate(final int lottoNumber) {
        if (MIN_NUMBER > lottoNumber || lottoNumber > MAX_NUMBER) {
            throw new MalFormedLottoNumberException(MAL_FORMED_LOTTO_NUMBER_MESSAGE);
        }
    }
}
