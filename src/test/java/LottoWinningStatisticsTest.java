import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class LottoWinningStatisticsTest {

	@Test
	void statistics() {
		final WinningLotto winningLotto = WinningLotto.from("1,2,3,4,5,6");
		final List<Lotto> lottos = Arrays.asList(
			Lotto.from("1,2,3,10,11,12"),
			Lotto.from("10,11,12,13,14,15")
		);
		final LottoWinningStatistics statistics = LottoWinningStatistics.of(winningLotto, lottos);

		assertThat(statistics.countLottos(3)).isEqualTo(1);
		assertThat(statistics.countLottos(0)).isEqualTo(1);
		assertThat(statistics.earningRate()).isEqualTo(
			(float)LottoWinningCriteria.FOURTH_CLASS.getPrizeKRW() / (Lotto.PRICE_KRW * lottos.size())
		);
	}
}
