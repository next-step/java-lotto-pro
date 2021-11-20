package lotto.view;

import lotto.domain.LottoOrder;

public class Customer extends CustomerConsole {
	private static final String MESSAGE_WRITE_ORDER_PRICE = "구매금액을 입력해주세요.";
	private static final String MESSAGE_WRONG_ORDER_PRICE = "구매 금액을 다시 입력해주세요.";
	private static final String MESSAGE_ORDERED_PRICE = "개를 구매했습니다. ";
	private static final String MESSAGE_CHANGES = "원의 잔돈을 돌려드립니다.";

	public static LottoOrder askOrder() {
		System.out.println(MESSAGE_WRITE_ORDER_PRICE);
		try {
			LottoOrder lottoOrder = LottoOrder.byPrice(ask(MESSAGE_WRONG_ORDER_PRICE));
			String message = lottoOrder.getChanges() > LottoOrder.DEFAULT_CHANGES ?
				lottoOrder.getCount() + MESSAGE_ORDERED_PRICE + lottoOrder.getChanges() + MESSAGE_CHANGES :
				lottoOrder.getCount() + MESSAGE_ORDERED_PRICE;
			System.out.println(message);
			return lottoOrder;
		} catch (IllegalArgumentException e) {
			return LottoOrder.byPrice(ask(MESSAGE_WRONG_ORDER_PRICE));
		}
	}
}
