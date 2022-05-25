package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {
	private final List<List<String>> lottoList = Arrays.asList(
													Arrays.asList("1", "2", "3", "4", "5", "6"),
													Arrays.asList("7", "8", "9", "10", "11", "12")
												);

	@Test
	@DisplayName("수동으로 로또 생성")
	void create_manual_lotto() {
		LottoMachine lottoMachine = new LottoMachine(new AutoNumbers());
		LottoPrice lottoPrice = new LottoPrice(4000);
		Ledger ledger = new Ledger(lottoPrice, lottoList);
		LottoTickets tickets = lottoMachine.generate(ledger);

		assertThat(tickets.getLottTickets()).hasSize(2);
	}

	@Test
	@DisplayName("소지한 금액보다 많은 로또를 구매할 경우 오류")
	void validate_order() {
		LottoMachine lottoMachine = new LottoMachine(new AutoNumbers());
		LottoPrice lottoPrice = new LottoPrice(1000);
		Ledger ledger = new Ledger(lottoPrice, lottoList);

		assertThatThrownBy(() -> lottoMachine.generate(ledger))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
