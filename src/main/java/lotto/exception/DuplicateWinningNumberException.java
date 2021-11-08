package lotto.exception;

public class DuplicateWinningNumberException extends IllegalArgumentException {
    private static final String DUPLICATE_BONUS_TEXT = "당첨번호에 포함되지 않는 번호로 입력해야 합니다.";

    public DuplicateWinningNumberException() {
        super(DUPLICATE_BONUS_TEXT);
    }
}
