package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lotto.exception.InvalidMoneyException;

@DisplayName("로또 티켓 머신 테스트")
class LottoTicketMachineTest {

	@Test
	@DisplayName("로또 티켓 머신 생성")
	void createLottoTicketMachineTest() {
		LottoTicketMachine lottoTicketMachine = new LottoTicketMachine();
		assertThat(lottoTicketMachine).isInstanceOf(LottoTicketMachine.class);
	}

	@ParameterizedTest
	@CsvSource(value = {"1000:1", "1500:1", "2000:2", "2500:2", "3000:3", "3500:3", "4000:4", "4500:4", "5000:5", "5500:5", "6000:6", "6500:6", "7000:7", "7500:7", "8000:8", "8500:8", "9000:9", "9500:9", "10000:10"}, delimiter = ':')
	@DisplayName("천원 단위로 로또 티켓 구매 - 나머지 버림")
	void getLottoTicketCountTest(int money, int expected) {
		LottoTicketMachine lottoTicketMachine = new LottoTicketMachine();
		assertThat(lottoTicketMachine.lottoTickets(money).size()).isEqualTo(expected);
	}

	@Test
	@DisplayName("천원 이하의 값을 입력 시 InvalidMoneyException 발생")
	void throwInvalidMoneyExceptionTest() {
		LottoTicketMachine lottoTicketMachine = new LottoTicketMachine();
		assertThatThrownBy(() -> lottoTicketMachine.lottoTickets(500))
			.isInstanceOf(InvalidMoneyException.class);
	}


}