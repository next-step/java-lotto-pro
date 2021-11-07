package lotto.exception;

public class LottoMatchNumberException extends IllegalArgumentException {

    private static final String LOTTO_MATCH_NUMBER_MESSAGE = "당첨 번호가 잘못되었습니다.";

    public LottoMatchNumberException() {
        super(LOTTO_MATCH_NUMBER_MESSAGE);
    }

    public LottoMatchNumberException(String message) {
        super(message);
    }
}
