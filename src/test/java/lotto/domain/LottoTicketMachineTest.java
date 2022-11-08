package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lotto.exception.InvalidMoneyException;

@DisplayName("로또 티켓 머신 테스트")
class LottoTicketMachineTest {

	LottoTicketMachine lottoTicketMachine;

	@BeforeEach
	void init() {
		lottoTicketMachine = LottoTicketMachine.getInstance();
	}

	@Test
	@DisplayName("로또 티켓 머신 생성")
	void createLottoTicketMachineTest() {
		assertThat(lottoTicketMachine).isInstanceOf(LottoTicketMachine.class);
	}

	@Test
	@DisplayName("천원 이하의 값을 입력 시 InvalidMoneyException 발생")
	void throwInvalidMoneyExceptionTest() {
		Money moneyLessThan1_000 = Money.from(500);
		assertThatThrownBy(() -> lottoTicketMachine.ticketCount(moneyLessThan1_000))
			.isInstanceOf(InvalidMoneyException.class);
	}

	@ParameterizedTest
	@CsvSource(value = {"1000:1", "2000:2", "3000:3", "4000:4", "5000:5", "6000:6", "7000:7", "8000:8", "9000:9",
		"10000:10"}, delimiter = ':')
	@DisplayName("입력한 금액에 따라 로또 티켓 수 반환")
	void buyLottoTicketsTest(int money, int expected) {
		Money inputMoney = Money.from(money);
		assertThat(lottoTicketMachine.ticketCount(inputMoney).count()).isEqualTo(expected);
	}

	@Test
	@DisplayName("로또 번호 리스트를 통해 로또 티켓 생성")
	void createLottoTicketTest() {
		TestGenerateStrategy strategy = new TestGenerateStrategy();
		List<LottoNumbers> lottoNumbersList = List.of(strategy.generate(), strategy.generate());

		LottoTickets lottoTickets = lottoTicketMachine.lottoTickets(lottoNumbersList);
		assertThat(lottoTickets.getLottoTickets())
			.hasSize(2)
			.containsExactly(LottoTicket.from(Set.of(1, 2, 3, 4, 5, 6)), LottoTicket.from(Set.of(1, 2, 3, 4, 5, 6)));
	}
}