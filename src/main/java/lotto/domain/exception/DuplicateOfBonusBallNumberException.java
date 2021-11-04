package lotto.domain.exception;

public class DuplicateOfBonusBallNumberException extends IllegalArgumentException {

    private static final String DUPLICATE_OF_BONUS_BALL_NUMBER_ERROR_MESSAGE = "보너스볼과 당첨번호가 중복되었습니다.";

    public DuplicateOfBonusBallNumberException() {
        super(DUPLICATE_OF_BONUS_BALL_NUMBER_ERROR_MESSAGE);
    }

}
