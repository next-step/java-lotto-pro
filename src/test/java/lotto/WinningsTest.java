package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class WinningsTest {
	@ParameterizedTest
	@CsvSource(value = {"6,2000000000", "5,1500000", "4,50000", "3,5000"})
	void 일치개수_당첨금(int match, int expected) {
		assertThat(Winnings.from(match).getMoney()).isEqualTo(expected);
	}
}
