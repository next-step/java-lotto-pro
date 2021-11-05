package step3;

import static org.assertj.core.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MachineTest {
	@ParameterizedTest
	@CsvSource(value = {"1000:1","2000:2","1500:1","3200:3"}, delimiter = ':')
	void 금액당_로또_구매_갯수_확인(int money, int result) {
		Machine machine = new Machine(new Money(money));
		Set<LottoNumbers> lottos = machine.createLotto();
		assertThat(lottos.size()).isEqualTo(result);
	}
}
