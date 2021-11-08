import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class LottoWinningStatisticsTest {

	@Test
	void countLottos() {
		final WinningLotto winningLotto = WinningLottoBuilder.aWinningLotto()
			.withLottoNumbers("1,2,3,4,5,6")
			.withBonus("45")
			.build();
		final List<Lotto> lottos = Arrays.asList(
			Lotto.from("1,2,3,4,5,6"),
			Lotto.from(String.format("1,2,3,4,5,%s", winningLotto.getBonus())),
			Lotto.from("1,2,3,4,5,10"),
			Lotto.from("1,2,3,4,10,11"),
			Lotto.from("1,2,3,10,11,12"),
			Lotto.from("10,11,12,13,14,15")
		);

		final LottoWinningStatistics statistics = LottoWinningStatistics.of(winningLotto, lottos);
		Arrays.stream(LottoWinningRank.values())
			.forEach(rank -> assertThat(statistics.countLottos(rank)).isEqualTo(1L));
	}

	@Test
	void earningRate() {
		final WinningLotto winningLotto = WinningLottoBuilder.aWinningLotto()
			.withLottoNumbers("1,2,3,4,5,6")
			.withBonus("45")
			.build();
		final List<Lotto> lottos = Stream.iterate(1, num -> num + 1)
			.limit(4)
			.map(num -> Lotto.from("10,11,12,13,14,15"))
			.collect(Collectors.toList());
		lottos.add(Lotto.from("1,2,3,10,11,12"));

		final LottoWinningStatistics statistics = LottoWinningStatistics.of(winningLotto, lottos);
		assertThat(statistics.earningRate()).isEqualTo(1.d);
	}
}
