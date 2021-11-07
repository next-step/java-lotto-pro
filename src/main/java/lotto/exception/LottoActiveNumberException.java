package lotto.exception;

public class LottoActiveNumberException extends IllegalArgumentException {

    private static final String LOTTO_ACTIVE_NUMBER_MESSAGE = "수동 번호를 얻어오는 과정에 오류가 발생했습니다.";

    public LottoActiveNumberException() {
        super(LOTTO_ACTIVE_NUMBER_MESSAGE);
    }

    public LottoActiveNumberException(String message) {
        super(message);
    }
}
