import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoWinningStatistics {

	public final static float EARNING_RATE_BASE = 1.0f;

	private final Map<LottoWinningRank, Long> numOfLottosByRank;

	private LottoWinningStatistics(WinningLotto winningLotto, List<Lotto> lottos) {
		this.numOfLottosByRank = lottos.stream()
			.collect(Collectors.groupingBy(lotto -> rank(winningLotto, lotto), Collectors.counting()));
	}

	private LottoWinningRank rank(WinningLotto winningLotto, Lotto lotto) {
		final int matchingCount = winningLotto.countMatching(lotto);
		final boolean hasBonus = lotto.hasBonus(winningLotto);
		return LottoWinningRank.valueOf(matchingCount, hasBonus);
	}

	public static LottoWinningStatistics of(WinningLotto winningLotto, List<Lotto> lottos) {
		return new LottoWinningStatistics(winningLotto, lottos);
	}

	public long countLottos(LottoWinningRank rank) {
		if (numOfLottosByRank.containsKey(rank)) {
			return numOfLottosByRank.get(rank);
		}
		return 0L;
	}

	public double earningRate() {
		final long prizeKRW = numOfLottosByRank.entrySet().stream()
			.reduce(0L
				, (acc, entry) -> acc + calculatePrizeKRW(entry.getKey(), entry.getValue())
				, Long::sum);

		final long paidKRW = Lotto.PRICE_KRW * countLottos();

		return (double)prizeKRW / paidKRW;
	}

	private long calculatePrizeKRW(LottoWinningRank rank, Long numOfLottos) {
		return numOfLottos * rank.getPrizeKRW();
	}

	private long countLottos() {
		return numOfLottosByRank.values().stream().reduce(0L, Long::sum);
	}
}


