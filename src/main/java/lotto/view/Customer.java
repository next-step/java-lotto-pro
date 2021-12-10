package lotto.view;

import lotto.domain.wrapper.LottoMoney;
import lotto.domain.wrapper.LottoNumber;
import lotto.domain.wrapper.LottoOrderCount;
import lotto.domain.wrapper.LottoTicket;

public class Customer extends CustomerConsole {
	private static final String MESSAGE_WRITE_ORDER_PRICE = "구매금액을 입력해주세요.";
	private static final String MESSAGE_ORDERED_PRICE = "개를 구매했습니다. ";
	private static final String MESSAGE_WRITE_LAST_WINNING_TICKET = "지난 주 당첨 번호를 입력해 주세요. (각 숫자는 , 로 구분)";
	private static final String MESSAGE_WRITE_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

	private Customer() {
		throw new AssertionError();
	}

	public static LottoOrderCount askOrder() {
		System.out.println(MESSAGE_WRITE_ORDER_PRICE);
		return makeOrder();
	}

	public static LottoTicket askLastWinningTicket() {
		System.out.println(MESSAGE_WRITE_LAST_WINNING_TICKET);
		return makeLastWinningTicket();
	}

	public static LottoNumber askBonusNumber() {
		System.out.println(MESSAGE_WRITE_BONUS_NUMBER);
		return addBonusNumber();
	}


	private static LottoOrderCount makeOrder() {
		try {
			LottoOrderCount lottoOrderCount = new LottoOrderCount(new LottoMoney(ask()));
			String message = getMessageOrderedPrice(lottoOrderCount);
			System.out.println(message);
			return lottoOrderCount;
		} catch (IllegalArgumentException e) {
			System.out.println(withErrorPrefix(e.getMessage()));
			return makeOrder();
		}
	}

	private static LottoTicket makeLastWinningTicket() {
		try {
			return new LottoTicket(ask());
		} catch (IllegalArgumentException e) {
			System.out.println(withErrorPrefix(e.getMessage()));
			return makeLastWinningTicket();
		}
	}

	private static String getMessageOrderedPrice(LottoOrderCount lottoOrderCount) {
		return lottoOrderCount.get() + MESSAGE_ORDERED_PRICE;
	}

	private static LottoNumber addBonusNumber() {
		try {
			return new LottoNumber(ask());
		} catch (IllegalArgumentException e) {
			System.out.println(withErrorPrefix(e.getMessage()));
			return addBonusNumber();
		}
	}
}
