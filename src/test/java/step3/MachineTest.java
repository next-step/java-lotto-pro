package step3;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static step3.machine.create.LottoMachineType.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import step3.lotto.LottoPapers;
import step3.machine.Bought;
import step3.machine.create.Machine;

public class MachineTest {

	@ParameterizedTest
	@CsvSource(value = {"1000:1", "2000:2", "1500:1", "3200:3"}, delimiter = ':')
	void 천원당_로또번호가_생성되는지_확인(int money, int result) {

		// when
		Machine lottoMachine = lottoFactory(AUTO);
		Bought bought = new Bought(new Money(money));
		LottoPapers lottoPapers = lottoMachine.createLotto(bought.buyAutoCount());

		// then
		assertThat(lottoPapers.size()).isEqualTo(result);
	}

	@ParameterizedTest
	@MethodSource(value = "manualLottoNumbers")
	void 수동으로_입력시_구매수_확인(List<String> manualLottoNumbers, int size) {

		// when
		Machine lottoMachine = lottoFactory(MANUAL);
		LottoPapers manualLottoPapers = lottoMachine.createLotto(manualLottoNumbers);

		// then
		assertThat(manualLottoPapers.size()).isEqualTo(size);
	}

	static Stream<Arguments> manualLottoNumbers() {
		return Stream.of(
			Arguments.of(Arrays.asList("1,2,32,34,5,6", "7,8,9,10,11,12", "13,14,15,16,17,18"), 3),
			Arguments.of(Arrays.asList("1,2,36,34,5,6"), 1)
		);
	}

}
