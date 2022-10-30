package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WinningStatistics {
	private final List<WinningLottoStrategy> winningLottoStrategies = new ArrayList<>();

	public WinningStatistics(WinningLotto winningLotto) {
		winningLottoStrategies.add(new NumberMatchWinningLottoStrategy(winningLotto, 3, 5000));
		winningLottoStrategies.add(new NumberMatchWinningLottoStrategy(winningLotto, 4, 50000));
		winningLottoStrategies.add(new NumberMatchWinningLottoStrategy(winningLotto, 5, 1500000));
		winningLottoStrategies.add(new NumberMatchWinningLottoStrategy(winningLotto, 6, 2000000000));
	}

	public List<MatchResult> getMatchResults(Lottos lottos) {
		return winningLottoStrategies.stream()
			.map(winningLottoStrategy -> new MatchResult(winningLottoStrategy, lottos))
			.collect(Collectors.toList());
	}

	public float getYield() {
		return 0;
	}
}
