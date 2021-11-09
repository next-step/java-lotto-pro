package step3;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import step3.lotto.LottoPapers;
import step3.machine.AutoLottoMachine;
import step3.machine.AutoMachineValidation;
import step3.machine.Machine;

public class MachineTest {

	@ParameterizedTest
	@CsvSource(value = {"1000:1", "2000:2", "1500:1", "3200:3"}, delimiter = ':')
	void 금액당_로또_구매_갯수_확인(int money, int result) {
		Machine machine = new AutoLottoMachine(new AutoMachineValidation());
		LottoPapers lottoPapers = machine.createLottoPapers(new Money(money));
		assertThat(lottoPapers.size()).isEqualTo(result);
	}
}
