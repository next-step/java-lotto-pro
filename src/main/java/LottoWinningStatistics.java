import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoWinningStatistics {

	public final static float EARNING_RATE_BASE = 1.0f;

	private final Map<Integer, Long> numOfLottosByMatching;

	private LottoWinningStatistics(WinningLotto winningLotto, List<Lotto> lottos) {
		this.numOfLottosByMatching = lottos.stream()
			.collect(Collectors.groupingBy(winningLotto::countMatching, Collectors.counting()));
	}

	public static LottoWinningStatistics of(WinningLotto winningLotto, List<Lotto> lottos) {
		return new LottoWinningStatistics(winningLotto, lottos);
	}

	public Long countLottos(LottoWinningRank rank) {
		final int matchingCount = rank.getMatchingCount();
		if (numOfLottosByMatching.containsKey(matchingCount)) {
			return numOfLottosByMatching.get(matchingCount);
		}
		return 0L;
	}

	public double earningRate() {
		final long prizeKRW = numOfLottosByMatching.entrySet().stream()
			.reduce(0L
				, (acc, entry) -> acc + calculatePrizeKRW(entry.getKey(), entry.getValue())
				, Long::sum);

		final int paidKRW = Lotto.PRICE_KRW * (numOfLottosByMatching.values().stream()
			.reduce(0, (acc, numOfLottos) -> acc + numOfLottos.intValue(), Integer::sum));

		return (double)prizeKRW / paidKRW;
	}

	private long calculatePrizeKRW(int matchingCount, Long numOfLottos) {
		return numOfLottos * LottoWinningRank.valueOf(matchingCount).getPrizeKRW();
	}
}


