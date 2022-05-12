package lotto;

public class NothingToPurchasedLottoException extends RuntimeException {

    public NothingToPurchasedLottoException() {
        super("구매한 Lotto가 없습니다.");
    }
}
