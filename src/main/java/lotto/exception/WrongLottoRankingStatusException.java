package lotto.exception;

public class WrongLottoRankingStatusException extends RuntimeException {
    private static final long serialVersionUID = 6L;

    public WrongLottoRankingStatusException(String message) {
        super(message);
    }
}
