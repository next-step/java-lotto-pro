package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class StatisticsTest {

	private Statistics statistics;

	@BeforeEach
	void setUp() {
		Lotto winningLotto = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6));
		Lottos userLottos = Lottos.from(
			Collections.singletonList(Lotto.from(Arrays.asList(1, 2, 3, 7, 8, 9)))
		);

		statistics = new Statistics(winningLotto, userLottos);
	}

	@Test
	@DisplayName("수익률을 확인할 수 있다.")
	void testEarningRate() {
		assertThat(statistics.earningRate()).isEqualTo(5.0f);
	}

	@ParameterizedTest
	@EnumSource(Rank.class)
	@DisplayName("Rank의 모든 값을 키로 포함한다.")
	void testWinningsCountKey(Rank rank) {
		EnumMap<Rank, Integer> winningCounts = statistics.winningCounts();

		assertThat(winningCounts).containsKey(rank);
	}

	@Test
	@DisplayName("일치하는 개수를 확인 할 수 있다.")
	void testWinningsCount() {
		EnumMap<Rank, Integer> winningCounts = statistics.winningCounts();

		assertThat(winningCounts).containsKey(Rank.FIFTH);
		assertThat(winningCounts.get(Rank.FIFTH)).isEqualTo(1);
	}

	@ParameterizedTest
	@EnumSource(
		value = Rank.class,
		names = {"FOURTH", "THIRD", "FIRST", "LOSS"},
		mode = EnumSource.Mode.INCLUDE
	)
	@DisplayName("당첨되지 않은 등수의 개수는 모두 0개이다.")
	void testNotWinningCountIsAllZero(Rank rank) {
		EnumMap<Rank, Integer> winningCounts = statistics.winningCounts();

		assertThat(winningCounts).containsKey(rank);
		assertThat(winningCounts.get(rank)).isEqualTo(0);
	}
}
