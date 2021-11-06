package lotto.view;

import lotto.domain.wrapper.LottoOrder;

public class Customer extends CustomerConsole {
	private static final String MESSAGE_WRITE_ORDER_PRICE = "구매금액을 입력해주세요.";
	private static final String MESSAGE_WRONG_ORDER_PRICE = "구매 금액을 다시 입력해주세요.";
	private static final String MESSAGE_ORDERED_PRICE = "개를 구매했습니다.";

	public static LottoOrder askOrder() {
		System.out.println(MESSAGE_WRITE_ORDER_PRICE);
		try {
			LottoOrder lottoOrder = LottoOrder.byPrice(ask(MESSAGE_WRONG_ORDER_PRICE));
			System.out.println(lottoOrder.getCount() + MESSAGE_ORDERED_PRICE);
			return lottoOrder;
		} catch (IllegalArgumentException e) {
			return LottoOrder.byPrice(ask(MESSAGE_WRONG_ORDER_PRICE));
		}
	}
}
