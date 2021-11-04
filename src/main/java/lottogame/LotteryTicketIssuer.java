package lottogame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import lottogame.exception.InvalidAmountUnitException;
import lottogame.exception.NotEnoughtMoneyException;

public class LotteryTicketIssuer {

	private static final int TICKET_PER_PRICE = 1000;

	private static int getNumOfTicketsToBuy(int money) {
		return money / 1000;
	}

	public static List<LotteryTicket> buyTickets(int money) {
		validatePay(money);
		int numOfTickets = getNumOfTicketsToBuy(money);

		return IntStream.range(0, numOfTickets).collect(ArrayList::new,
			(tickets, i) -> tickets.add(LotteryTicket.makeLotteryTicket()),
			(tickets1, tickets2) -> tickets1.addAll(tickets2));

	}

	private static void validatePay(int money) {
		if (isMoneyTooLittle(money)) {
			throw new NotEnoughtMoneyException("금액을 " + TICKET_PER_PRICE + "원 이상 입력해주세요.");
		}
		if (isNotDividableAmountByPerPrice(money)) {
			throw new InvalidAmountUnitException("금액은 " + TICKET_PER_PRICE + "원 단위로 입력해주세요.");
		}
	}

	private static boolean isNotDividableAmountByPerPrice(int money) {
		if ((money % TICKET_PER_PRICE) > 0) {
			return true;
		}
		return false;
	}

	private static boolean isMoneyTooLittle(int money) {
		if (money < TICKET_PER_PRICE) {
			return true;
		}
		return false;
	}
}
