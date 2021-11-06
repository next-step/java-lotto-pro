import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class LottoWinningStatisticsTest {

	private final String bonus = "45";
	private final WinningLotto winningLotto = WinningLottoBuilder.aWinningLotto()
		.withLottoNumbers("1,2,3,4,5,6")
		.withBonus(bonus)
		.build();
	private final List<Lotto> lottos = Arrays.asList(
		Lotto.from("1,2,3,4,5,6"),
		Lotto.from(String.format("1,2,3,4,5,%s", bonus)),
		Lotto.from("1,2,3,4,5,10"),
		Lotto.from("1,2,3,4,10,11"),
		Lotto.from("1,2,3,10,11,12"),
		Lotto.from("10,11,12,13,14,15")
	);
	private final LottoWinningStatistics statistics = LottoWinningStatistics.of(winningLotto, lottos);

	@ParameterizedTest
	@EnumSource(LottoWinningRank.class)
	void countLottos(LottoWinningRank rank) {
		assertThat(statistics.countLottos(rank)).isEqualTo(1L);
	}

	@Test
	void earningRate() {
		final long prizeKRW = Arrays.stream(LottoWinningRank.values())
			.reduce(0L, (acc, rank) -> acc + rank.getPrizeKRW(), Long::sum);
		assertThat(statistics.earningRate()).isEqualTo(
			(double)prizeKRW / (Lotto.PRICE_KRW * lottos.size())
		);
	}
}
