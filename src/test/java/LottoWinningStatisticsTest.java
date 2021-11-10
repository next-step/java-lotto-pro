import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class LottoWinningStatisticsTest {

	@Test
	void countLottos() {
		final WinningLotto winningLotto = WinningLottoBuilder.aWinningLotto()
			.withLottoNumbers("1,2,3,4,5,6")
			.withBonus("45")
			.build();
		final Lottos lottos = LottosFactory.manuallyFrom(Arrays.asList(
			"1,2,3,4,5,6",
			String.format("1,2,3,4,5,%s", winningLotto.getBonus()),
			"1,2,3,4,5,10",
			"1,2,3,4,10,11",
			"1,2,3,10,11,12",
			"10,11,12,13,14,15"
		));

		final LottoWinningStatistics statistics = LottoWinningStatistics.from(winningLotto, lottos);
		Arrays.stream(LottoWinningRank.values())
			.forEach(rank -> assertThat(statistics.countLottos(rank)).isEqualTo(1L));
	}

	@Test
	void earningRate() {
		final WinningLotto winningLotto = WinningLottoBuilder.aWinningLotto()
			.withLottoNumbers("1,2,3,4,5,6")
			.withBonus("45")
			.build();
		final Lottos lottos = LottosFactory.manuallyFrom(Arrays.asList(
			"1,2,3,10,11,12",
			"10,11,12,13,14,15",
			"10,11,12,13,14,15",
			"10,11,12,13,14,15",
			"10,11,12,13,14,15"
		));

		final LottoWinningStatistics statistics = LottoWinningStatistics.from(winningLotto, lottos);
		assertThat(statistics.earningRate()).isEqualTo(1.d);
	}
}
