package lotto.exception;

public class ManualCountException extends IllegalArgumentException {
    private static final String MANUAL_COUNT_ERROR_TEXT = "수동 로또번호 수는 구입 가능한 범위이거나 0보다 커야합니다.";

    public ManualCountException() {
        super(MANUAL_COUNT_ERROR_TEXT);
    }
}
