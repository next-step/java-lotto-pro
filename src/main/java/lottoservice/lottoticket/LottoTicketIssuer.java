package lottoservice.lottoticket;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import lottoservice.exception.NotDivisibleMoneyUnitException;
import lottoservice.exception.NotEnoughtMoneyException;
import lottoservice.exception.InvalidNumberFormatMoneyException;

/**
 * 로또 티켓 발급 클래스
 */
public class LottoTicketIssuer {

	public static final int TICKET_PER_PRICE = 1000;

	private static int getNumOfTicketsToBuy(int money) {
		return money / TICKET_PER_PRICE;
	}

	/**
	 * 사용자가 입력한 금액만큼 자동으로 로또 티켓을 생성하여 리턴
	 * @param money :  1000 < money < 2147483000 and money % 1000 = 0 이어야 함
	 * @return LottoTickets : LottoTicket을 리스트형태로 가지고 있는 일급컬렉션
	 */
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

	/* 사용자 입력값을 문자열로 받아 숫자형으로 변환 후  buyTickets(int money) 호출 */
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
