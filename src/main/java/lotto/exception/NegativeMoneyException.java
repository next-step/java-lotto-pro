package lotto.exception;

public class NegativeMoneyException extends IllegalArgumentException {

    public NegativeMoneyException() {
        super("로또 1장의 가격(1000원) 이상의 금액을 입력해주세요");
    }
}
