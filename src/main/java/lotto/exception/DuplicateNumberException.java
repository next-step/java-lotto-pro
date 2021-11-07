package lotto.exception;

public class DuplicateNumberException extends IllegalArgumentException {
    private static final String DUPLICATE_NUMBER_TEXT = "중복된 숫자는 입력할 수 없습니다.";

    public DuplicateNumberException() {
        super(DUPLICATE_NUMBER_TEXT);
    }
}
