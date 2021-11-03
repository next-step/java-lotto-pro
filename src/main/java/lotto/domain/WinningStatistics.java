package lotto.domain;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.List;

public class WinningStatistics {
	private final List<WinningRecord> winningRecords;

	private WinningStatistics() {
		this.winningRecords = new ArrayList<>();
	}

	public static WinningStatistics create() {
		return new WinningStatistics();
	}

	public void buildStatistics(Lottos lottos) {
		List<Lotto> winningLottos = extractWinningLottos(lottos);

		for (WinningRank winningRank : WinningRank.getPlaceRanks()) {
			int count = countNumberOfWinningRank(winningLottos, winningRank);
			this.winningRecords.add(WinningRecord.of(winningRank, count));
		}
	}

	public List<WinningRecord> getWinningRecords() {
		return winningRecords;
	}

	private int countNumberOfWinningRank(List<Lotto> winningLottos, WinningRank winningRank) {
		return (int)winningLottos.stream()
								 .map(Lotto::getWinningNumbers)
								 .filter(numbers -> numbers.getSize() == winningRank.getWinningNumberCount())
								 .count();
	}

	private List<Lotto> extractWinningLottos(Lottos lottos) {
		return lottos.getValues()
					 .stream()
					 .filter(Lotto::isWinning)
					 .collect(toList());
	}
}
