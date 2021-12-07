package lotto.view;

import lotto.domain.wrapper.LottoOrderRequest;
import lotto.domain.wrapper.LottoTicket;

public class Customer extends CustomerConsole {
	private static final String MESSAGE_WRITE_ORDER_PRICE = "구매금액을 입력해주세요.";
	private static final String MESSAGE_ORDERED_PRICE = "개를 구매했습니다. ";
	private static final String MESSAGE_CHANGES = "원의 잔돈을 돌려드립니다.";
	private static final String MESSAGE_WRITE_LAST_WINNING_TICKET = "지난 주 당첨 번호를 입력해 주세요. (각 숫자는 , 로 구분)";
	private static final String MESSAGE_WRITE_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

	private Customer() {
		throw new AssertionError();
	}

	public static LottoOrderRequest askOrder() {
		System.out.println(MESSAGE_WRITE_ORDER_PRICE);
		return makeOrder();
	}

	public static LottoTicket askLastWinningTicket() {
		System.out.println(MESSAGE_WRITE_LAST_WINNING_TICKET);
		return askBonusNumber(makeLastWinningTicket());
	}

	private static LottoOrderRequest makeOrder() {
		try {
			LottoOrderRequest lottoOrderRequest = LottoOrderRequest.byPrice(ask());
			String message = getMessageOrderedPrice(lottoOrderRequest.getCount(), lottoOrderRequest.getChanges());
			System.out.println(message);
			return lottoOrderRequest;
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

	private static String getMessageOrderedPrice(int count, int changes) {
		return changes > LottoOrderRequest.DEFAULT_CHANGES ?
			count + MESSAGE_ORDERED_PRICE + changes + MESSAGE_CHANGES :
			count + MESSAGE_ORDERED_PRICE;
	}

	private static LottoTicket askBonusNumber(LottoTicket lastWinningTicket) {
		System.out.println(MESSAGE_WRITE_BONUS_NUMBER);
		return addBonusNumber(lastWinningTicket);
	}

	private static LottoTicket addBonusNumber(LottoTicket lastWinningTicket) {
		try {
			return lastWinningTicket.addBonus(ask());
		} catch (IllegalArgumentException e) {
			System.out.println(withErrorPrefix(e.getMessage()));
			return addBonusNumber(lastWinningTicket);
		}
	}
}
