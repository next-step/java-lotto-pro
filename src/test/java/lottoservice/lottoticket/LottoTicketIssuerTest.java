package lottoservice.lottoticket;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import lottoservice.exception.NotDivisibleMoneyUnitException;
import lottoservice.exception.NotEnoughtMoneyException;
import lottoservice.exception.InvalidNumberFormatMoneyException;

public class LottoTicketIssuerTest {

	@ParameterizedTest
	@CsvSource(value = {"1000:1", "10000:10"}, delimiter = ':')
	public void buyTickets_금액에_따라_티켓발급(int inputAmount, int numOfTickets) {
		LottoTickets lottoTickets = LottoTicketIssuer.buyTickets(inputAmount);
		Assertions.assertThat(lottoTickets.getNumOfTickets()).isEqualTo(numOfTickets);
	}

	@ParameterizedTest
	@ValueSource(ints = {999, 900, 0, -1, -1000})
	public void buyTickets_금액이_티켓_한장값_미만인_경우_예외처리(int inputAmount) {
		Assertions.assertThatThrownBy(() -> {
			LottoTickets lottoTickets = LottoTicketIssuer.buyTickets(inputAmount);
		}).isInstanceOf(NotEnoughtMoneyException.class);
	}

	@ParameterizedTest
	@ValueSource(ints = {1001, 1100})
	public void buyTickets_금액이_나누어떨어지지_않는경우_예외처리(int inputAmount) {
		Assertions.assertThatThrownBy(() -> {
			LottoTickets lottoTickets = LottoTicketIssuer.buyTickets(inputAmount);
		}).isInstanceOf(NotDivisibleMoneyUnitException.class);
	}

	@ParameterizedTest
	@CsvSource(value = {"1000:1", "10000:10", "00011000:11"}, delimiter = ':')
	public void buyTickets_금액을_문자열로_입력받은경우_처리(String inputAmount, int numOfTickets) {
		LottoTickets lottoTickets = LottoTicketIssuer.buyTickets(inputAmount);
		Assertions.assertThat(lottoTickets.getNumOfTickets()).isEqualTo(numOfTickets);
	}

	@ParameterizedTest
	@ValueSource(strings = {"", "1000f"})
	public void buyTickets_금액을_문자열로_입력받은경우_숫자가아닌경우_예외처리(String inputAmount) {
		Assertions.assertThatThrownBy(() -> {
			LottoTickets lottoTickets = LottoTicketIssuer.buyTickets(inputAmount);
		}).isInstanceOf(InvalidNumberFormatMoneyException.class);
	}

	@ParameterizedTest
	@ValueSource(strings = {"21474830000", "2147484000"})
	public void buyTickets_입력받은_금액이_최대_금액을_초과한경우_예외처리(String inputAmount) {
		Assertions.assertThatThrownBy(() -> {
			LottoTickets lottoTickets = LottoTicketIssuer.buyTickets(inputAmount);
		}).isInstanceOf(InvalidNumberFormatMoneyException.class);
	}
}
