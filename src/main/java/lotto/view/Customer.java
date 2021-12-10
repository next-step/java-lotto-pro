package lotto.view;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.wrapper.LottoMoney;
import lotto.domain.wrapper.LottoNumber;
import lotto.domain.wrapper.LottoOrderCount;
import lotto.domain.wrapper.LottoTicket;

public class Customer extends CustomerConsole {
	private static final String MESSAGE_WRITE_ORDER_PRICE = "구매금액을 입력해주세요.";
	private static final String MESSAGE_WRITE_LAST_WINNING_TICKET = "지난 주 당첨 번호를 입력해 주세요. (각 숫자는 , 로 구분)";
	private static final String MESSAGE_WRITE_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
	private static final String MESSAGE_WRITE_MANUAL_ORDER_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
	private static final String MESSAGE_WRITE_MANUAL_TICKET_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";

	private Customer() {
		throw new AssertionError();
	}

	public static LottoOrderCount askOrder() {
		System.out.println(MESSAGE_WRITE_ORDER_PRICE);
		return makeOrder();
	}

	public static LottoTicket askLastWinningTicket() {
		System.out.println(MESSAGE_WRITE_LAST_WINNING_TICKET);
		return makeLottoTicket();
	}

	public static LottoNumber askBonusNumber() {
		System.out.println(MESSAGE_WRITE_BONUS_NUMBER);
		return addBonusNumber();
	}

	public static LottoOrderCount askManualOrderCount() {
		System.out.println(MESSAGE_WRITE_MANUAL_ORDER_COUNT);
		return makeManualLottoOrderCount();
	}

	public static List<LottoTicket> askManualLottoTickets(LottoOrderCount orderCount) {
		System.out.println(MESSAGE_WRITE_MANUAL_TICKET_NUMBERS);
		return makeManualTicketsHandle(orderCount);
	}

	private static LottoOrderCount makeManualLottoOrderCount() {
		try {
			return new LottoOrderCount(Integer.valueOf(ask()));
		}
		catch (NumberFormatException e) {
			System.out.println(withErrorPrefix(e.getMessage()));
			return makeManualLottoOrderCount();
		}
		catch (IllegalArgumentException e) {
			System.out.println(withErrorPrefix(e.getMessage()));
			return makeManualLottoOrderCount();
		}
	}

	private static List<LottoTicket> makeManualTicketsHandle(LottoOrderCount orderCount) {
		try {
			return makeManualTickets(orderCount);
		} catch (IllegalArgumentException e) {
			System.out.println(withErrorPrefix(e.getMessage()));
			return makeManualTickets(orderCount);
		}
	}

	private static List<LottoTicket> makeManualTickets(LottoOrderCount orderCount) {
		List<LottoTicket> lottoTickets = new ArrayList<>();
		while (lottoTickets.size() < orderCount.get()) {
			lottoTickets.add(makeLottoTicket());
		}
		return lottoTickets;
	}

	private static LottoOrderCount makeOrder() {
		try {
			LottoOrderCount lottoOrderCount = new LottoOrderCount(new LottoMoney(ask()));
			return lottoOrderCount;
		} catch (IllegalArgumentException e) {
			System.out.println(withErrorPrefix(e.getMessage()));
			return makeOrder();
		}
	}

	private static LottoTicket makeLottoTicket() {
		try {
			return new LottoTicket(ask());
		} catch (IllegalArgumentException e) {
			System.out.println(withErrorPrefix(e.getMessage()));
			return makeLottoTicket();
		}
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
