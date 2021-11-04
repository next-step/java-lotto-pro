package lottogame;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LotteryTicketIssuerTest {

	@ParameterizedTest
	@CsvSource(value = {"1000:1","10000:10"}, delimiter = ':')
	public void buyTickets_금액에_따라_티켓발급(int money, int numOfTickets){
		List<LotteryTicket> lotteryTickets = LotteryTicketIssuer.buyTickets(money);
		Assertions.assertThat(lotteryTickets.size()).isEqualTo(numOfTickets);
	}

	@ParameterizedTest
	@ValueSource(ints = {999,900,0,-1,-1000})
	public void buyTickets_금액이_티켓_한장값_미만인_경우(int money){
		Assertions.assertThatThrownBy(()->{
			List<LotteryTicket> lotteryTickets = LotteryTicketIssuer.buyTickets(money);
		});
	}
}
