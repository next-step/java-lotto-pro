package step3.winner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import step3.LottoNumbers;
import step3.LottoPapers;

public class Winner {

	private final Map<Rank, Integer> ranks;
	private final int WINNING_COUNT = 1;

	private Winner(Map<Rank, Integer> ranks) {
		this.ranks = ranks;
	}

	public static Winner of() {
		return new Winner(new HashMap<>());
	}

	public Winner statistics(LottoNumbers userLottoNumbers, LottoPapers createLottoNumbers) {
		List<Integer> matchLottoNumber = createLottoNumbers.findMatchLottoNumber(userLottoNumbers);
		return new Winner(
			matchLottoNumber.stream()
				.map(Rank::valueOf)
				.collect(
					Collectors.toMap(
						(matchNumber -> matchNumber),
						matchNumber -> WINNING_COUNT,
						Integer::sum
					)
				)
		);
	}

	public int getTotal() {
		return ranks.entrySet().stream()
			.map(Map.Entry::getKey)
			.map(Rank::getAmount)
			.reduce(0, Integer::sum);
	}
}
