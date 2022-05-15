package step3.lotto.domain;

/**
 * @author : choi-ys
 * @date : 2022/05/15 8:12 오후
 */
public class LottoNumber {

    public static final int LOTTO_NUMBER_START_RANGE = 1;
    public static final int LOTTO_NUMBER_END_RANGE = 45;
    public static final String INVALID_LOTTO_NUMBER_RANGE_ERROR = "1~45 범위의 값만 입력하세요.";

    private int lottoNumber;

    private LottoNumber(int lottoNumber) {

        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber of(int number) {
        validateLottoNumberRange(number);
        return new LottoNumber(number);
    }

    private static void validateLottoNumberRange(int number) {
        if (!isLottoNumberRangeBetween(number)) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE_ERROR);
        }
    }

    private static boolean isLottoNumberRangeBetween(int number) {
        return number >= LOTTO_NUMBER_START_RANGE && number <= LOTTO_NUMBER_END_RANGE;
    }

    public int getLottoNumber() {
        return lottoNumber;
    }
}
