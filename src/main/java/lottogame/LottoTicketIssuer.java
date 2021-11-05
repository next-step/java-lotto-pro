package lottogame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import lottogame.exception.NotDivisibleMoneyUnitException;
import lottogame.exception.NotEnoughtMoneyException;
import lottogame.exception.InvalidNumberFormatMoneyException;

public class LottoTicketIssuer {

	private static final int TICKET_PER_PRICE = 1000;

	private static int getNumOfTicketsToBuy(int money) {
		return money / TICKET_PER_PRICE;
	}

	public static LottoTickets buyTickets(int money) {
		validatePay(money);
		int numOfTickets = getNumOfTicketsToBuy(money);
		List<LottoTicket> lottoTickets = issuTickets(numOfTickets);
		return new LottoTickets(lottoTickets);
	}

	private static List<LottoTicket> issuTickets(int numOfTickets) {
		return IntStream.range(0, numOfTickets)
			.collect(ArrayList::new,
				(tickets, i) -> tickets.add(new LottoTicket()),
				(tickets1, tickets2) -> tickets1.addAll(tickets2));
	}

	private static void validatePay(int money) {
		if (isMoneyTooLittle(money)) {
			throw new NotEnoughtMoneyException("금액을 " + TICKET_PER_PRICE + "원 이상 입력해주세요.");
		}

		if (isNotDivisibleMoneyByPerPrice(money)) {
			throw new NotDivisibleMoneyUnitException("금액은 " + TICKET_PER_PRICE + "원 단위로 입력해주세요.");
		}
	}

	private static boolean isNotDivisibleMoneyByPerPrice(int money) {
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

	public static LottoTickets buyTickets(String money) {
		int convertedMoney = convertMoneyFormatToNumber(money);
		return buyTickets(convertedMoney);
	}

	/* int형 양의 정수 최대값 보다 큰 값을 변환하는 경우도 예외 발생 */
	private static int convertMoneyFormatToNumber(String money) {
		try {
			return Integer.parseInt(money);
		} catch (NumberFormatException ex) {
			throw new InvalidNumberFormatMoneyException("금액을 숫자로 입력해주세요.");
		}
	}
}
