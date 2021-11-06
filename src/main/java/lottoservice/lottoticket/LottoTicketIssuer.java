package lottoservice.lottoticket;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lottoservice.exception.NotDivisibleMoneyUnitException;
import lottoservice.exception.NotEnoughtMoneyException;
import lottoservice.exception.InvalidNumberFormatMoneyException;

/**
 * 로또 티켓 발급 클래스
 */
public class LottoTicketIssuer {

	public static final int TICKET_PER_PRICE = 1000;
	private static String ERROR_MESSAGE_INPUT_AMOUNT_TOO_LITTLE = "금액을 " + TICKET_PER_PRICE + "원 이상 입력해주세요.";
	private static String ERROR_MESSAGE_INPUT_AMOUNT_NOT_DIVISIBLE = "금액은 " + TICKET_PER_PRICE + "원 단위로 입력해주세요.";
	private static String ERROR_MESSAGE_INPUT_AMOUNT_NOT_NUMBER = "금액을 숫자로 입력해주세요.";

	private static int getNumOfTicketsToBuy(int inputAmount) {
		return inputAmount / TICKET_PER_PRICE;
	}

	/**
	 * 사용자가 입력한 금액만큼 자동으로 로또 티켓을 생성하여 리턴
	 * @param inputAmount :  티켓 단위 금액(TICKET_PER_PRICE) < inputAmount < int형 최대값 and inputAmount % 1000 = 0 이어야 함
	 * @return LottoTickets : LottoTicket을 리스트형태로 가지고 있는 일급컬렉션
	 */
	public static LottoTickets buyTickets(int inputAmount) {
		validatePay(inputAmount);
		int numOfTickets = getNumOfTicketsToBuy(inputAmount);
		List<LottoTicket> lottoTickets = issuTickets(numOfTickets);
		return new LottoTickets(lottoTickets);
	}

	private static List<LottoTicket> issuTickets(int numOfTickets) {
		return IntStream.range(0, numOfTickets)
			.mapToObj((it)->new LottoTicket())
			.collect(Collectors.toList());
	}

	private static void validatePay(int inputAmount) {
		if (isMoneyTooLittle(inputAmount)) {
			throw new NotEnoughtMoneyException(ERROR_MESSAGE_INPUT_AMOUNT_TOO_LITTLE);
		}

		if (isNotDivisibleMoneyByPerPrice(inputAmount)) {
			throw new NotDivisibleMoneyUnitException(ERROR_MESSAGE_INPUT_AMOUNT_NOT_DIVISIBLE);
		}
	}

	private static boolean isNotDivisibleMoneyByPerPrice(int inputAmount) {
		if ((inputAmount % TICKET_PER_PRICE) > 0) {
			return true;
		}
		return false;
	}

	private static boolean isMoneyTooLittle(int inputAmount) {
		if (inputAmount < TICKET_PER_PRICE) {
			return true;
		}
		return false;
	}

	/* 사용자 입력값을 문자열로 받아 숫자형으로 변환 후  buyTickets(int inputAmount) 호출 */
	public static LottoTickets buyTickets(String inputAmount) {
		int convertedMoney = convertMoneyFormatToNumber(inputAmount);
		return buyTickets(convertedMoney);
	}

	/* int형 양의 정수 최대값 보다 큰 값을 변환하는 경우도 예외 발생 */
	private static int convertMoneyFormatToNumber(String inputAmount) {
		try {
			return Integer.parseInt(inputAmount);
		} catch (NumberFormatException ex) {
			throw new InvalidNumberFormatMoneyException(ERROR_MESSAGE_INPUT_AMOUNT_NOT_NUMBER);
		}
	}
} 
