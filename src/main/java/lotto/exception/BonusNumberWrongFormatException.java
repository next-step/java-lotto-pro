package lotto.exception;

public class BonusNumberWrongFormatException extends RuntimeException {

    public BonusNumberWrongFormatException(Throwable cause) {
        super("당첨 보너스 번호는 숫자만 입력이 가능합니다.", cause);
    }
}
