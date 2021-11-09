package lottoservice.lottoticket;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import lottoservice.exception.NotDivisibleMoneyUnitException;
import lottoservice.exception.NotEnoughMoneyException;
import lottoservice.exception.InvalidNumberFormatMoneyException;
import lottoservice.lottonumber.LottoArrangeManipulator;
import lottoservice.lottonumber.LottoNumbersMaker;
import lottoservice.testfactory.TestLottoDataFactory;

public class LottoTicketIssuerTest {

	private LottoTicketIssuer lottoTicketIssuer = new LottoTicketIssuer(
		new LottoNumbersMaker(new LottoArrangeManipulator()));

	@DisplayName("금액에_따라_티켓발급")
	@ParameterizedTest
	@CsvSource(value = {"1000:1", "10000:10"}, delimiter = ':')
	public void buyAutoTickets(int inputAmount, int numOfTickets) {
		LottoTickets lottoTickets = lottoTicketIssuer.buyAutoTickets(inputAmount);
		assertThat(lottoTickets.getNumOfTickets()).isEqualTo(numOfTickets);
	}

	@DisplayName("금액이_티켓_한장값_미만인_경우_예외처리")
	@ParameterizedTest
	@ValueSource(ints = {999, 900, 0, -1, -1000})
	public void buyAutoTickets_not_enough_money(int inputAmount) {
		assertThatThrownBy(() -> {
			LottoTickets lottoTickets = lottoTicketIssuer.buyAutoTickets(inputAmount);
		}).isInstanceOf(NotEnoughMoneyException.class);
	}

	@DisplayName("금액이_나누어떨어지지_않는경우_예외처리")
	@ParameterizedTest
	@ValueSource(ints = {1001, 1100})
	public void buyAutoTickets_not_divisible(int inputAmount) {
		assertThatThrownBy(() -> {
			LottoTickets lottoTickets = lottoTicketIssuer.buyAutoTickets(inputAmount);
		}).isInstanceOf(NotDivisibleMoneyUnitException.class);
	}

	@DisplayName("금액을_문자열로_입력받은경우_처리")
	@ParameterizedTest
	@CsvSource(value = {"1000:1", "10000:10", "00011000:11"}, delimiter = ':')
	public void buyAutoTickets_string_amount(String inputAmount, int numOfTickets) {
		LottoTickets lottoTickets = lottoTicketIssuer.buyAutoTickets(inputAmount);
		assertThat(lottoTickets.getNumOfTickets()).isEqualTo(numOfTickets);
	}

	@DisplayName("금액을_문자열로_입력받은경우_숫자가아닌경우_예외처리")
	@ParameterizedTest
	@ValueSource(strings = {"", "1000f"})
	public void buyAutoTickets_string_amount_cannot_parse(String inputAmount) {
		assertThatThrownBy(() -> {
			LottoTickets lottoTickets = lottoTicketIssuer.buyAutoTickets(inputAmount);
		}).isInstanceOf(InvalidNumberFormatMoneyException.class);
	}

	@DisplayName("입력받은_금액이_최대_금액을_초과한경우_예외처리")
	@ParameterizedTest
	@ValueSource(strings = {"21474830000", "2147484000"})
	public void buyAutoTickets_amount_bigger_than_limit(String inputAmount) {
		assertThatThrownBy(() -> {
			LottoTickets lottoTickets = lottoTicketIssuer.buyAutoTickets(inputAmount);
		}).isInstanceOf(InvalidNumberFormatMoneyException.class);
	}

	@DisplayName("수동으로_로또_한장_발매")
	@Test
	public void buyManualTicket() {
		String numbers = "8, 21, 23, 41, 42, 43";
		LottoTicket lottoTicket = lottoTicketIssuer.buyManualTicket(numbers);

		assertThat(lottoTicket).isEqualTo(TestLottoDataFactory.getLottoTicket(numbers));
	}

	@DisplayName("수동으로_로또_여러장_한번에_발매")
	@Test
	public void buyManualTickets() {
		String first = "8, 21, 23, 41, 42, 43";
		String second = "3, 5, 11, 16, 32, 38";
		LottoTickets lottoTickets = lottoTicketIssuer.buyManualTickets(new ArrayList<>(Arrays.asList(first,second)));

		assertThat(lottoTickets.hasTicket(TestLottoDataFactory.getLottoTicket(first)));
		assertThat(lottoTickets.hasTicket(TestLottoDataFactory.getLottoTicket(second)));
	}
}
