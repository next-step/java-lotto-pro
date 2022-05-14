package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class StatisticsTest {
	@Test
	void 총수익율() {
		LottoCharge charge = new LottoCharge(14000);
		Winnings winnings = new Winnings(Arrays.asList(Winning.MATCH3, Winning.MATCH3));
		assertThat(Statistics.of(charge, winnings).revenueRate()).isEqualTo(0.71);
	}
}
