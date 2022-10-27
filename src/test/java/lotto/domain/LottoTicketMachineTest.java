package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

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
		lottoTicketMachine = new LottoTicketMachine(new TestGenerateStrategy());
	}

	@Test
	@DisplayName("로또 티켓 머신 생성")
	void createLottoTicketMachineTest() {
		assertThat(lottoTicketMachine).isInstanceOf(LottoTicketMachine.class);
	}

	@Test
	@DisplayName("천원 이하의 값을 입력 시 InvalidMoneyException 발생")
	void throwInvalidMoneyExceptionTest() {
		Money money = Money.of(500);
		assertThatThrownBy(() -> lottoTicketMachine.buyLottoTickets(money))
			.isInstanceOf(InvalidMoneyException.class);
	}

	@ParameterizedTest
	@CsvSource(value = {"1000:1", "2000:2", "3000:3", "4000:4", "5000:5", "6000:6", "7000:7", "8000:8", "9000:9",
		"10000:10"}, delimiter = ':')
	@DisplayName("입력한 금액에 따라 로또 티켓 구매")
	void buyLottoTicketsTest(int money, int expected) {
		assertThat(lottoTicketMachine.buyLottoTickets(Money.of(money))).hasSize(expected);
	}

	@Test
	@DisplayName("생성 전략에서 지정한 번호로 로또 티켓 생성")
	void generateLottoTicketTest() {
		List<LottoTicket> lottoTickets = lottoTicketMachine.buyLottoTickets(Money.of(1000));
		LottoTicket lottoTicket = lottoTickets.get(0);
		assertThat(lottoTicket.getNumbers()).isEqualTo(new TestGenerateStrategy().generate());

	}
}