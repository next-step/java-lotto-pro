package lotto.domain.exception;

public class DuplicateOfBonusBallNumberException extends IllegalArgumentException {

    private static final String DUPLICATE_OF_BONUS_BALL_NUMBER_ERROR_MESSAGE = "숫자가 6개가 아닙니다.";

    public DuplicateOfBonusBallNumberException() {
        super(DUPLICATE_OF_BONUS_BALL_NUMBER_ERROR_MESSAGE);
    }

}
