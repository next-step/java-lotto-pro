package lotto.lotto;

public class FailureCreatingLottoGeneratorException extends RuntimeException {

    public FailureCreatingLottoGeneratorException() {
        super("LottoGenerator 생성 실패했습니다.");
    }
}
