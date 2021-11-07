package lotto.exception;

public class LottoBonusNumberException extends IllegalArgumentException {

    private static final String LOTTO_BONUS_NUMBER_MESSAGE = "보너스 번호가 잘못되었습니다.";

    public LottoBonusNumberException() {
        super(LOTTO_BONUS_NUMBER_MESSAGE);
    }

    public LottoBonusNumberException(String message) {
        super(message);
    }
}
