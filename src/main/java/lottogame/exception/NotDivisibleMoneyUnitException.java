package lottogame.exception;

/**
 * 구매 금액이 티켓 단위 가격으로 나누어 떨어지지 않는 경우 예외
 */

public class NotDivisibleMoneyUnitException extends InvalidMoneyException {

	public NotDivisibleMoneyUnitException(String message) {
		super(message);
	}
}
