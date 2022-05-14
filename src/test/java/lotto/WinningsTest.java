package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class WinningsTest {
	@Test
	void 당첨금의합() {
		Winnings winnings = new Winnings(Arrays.asList(
				Winning.MATCH6,
				Winning.MATCH5,
				Winning.MATCH4,
				Winning.MATCH3
		));
		assertThat(winnings.totalMoney()).isEqualTo(2000000000 + 1500000 + 50000 + 5000);
	}
}
