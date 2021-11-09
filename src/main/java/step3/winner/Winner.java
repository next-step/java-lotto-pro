package step3.winner;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import step3.BonusBall;
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

	public Winner statistics(LottoNumbers userLottoNumbers, LottoPapers createLottoNumbers, BonusBall bonusBall) {
		List<Rank> matchLottoNumber = createLottoNumbers.findMatchLottoNumber(userLottoNumbers, bonusBall);
		return new Winner(
			matchLottoNumber.stream()
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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Arrays.stream(Rank.values()).sorted(Collections.reverseOrder()).forEach(s-> {
			sb.append(String.format(s.getMessage(),getWinner(s)));
		});
		return sb.toString();
	}

	private Integer getWinner(Rank rank) {
		Optional<Integer> integer = Optional.ofNullable(ranks.get(rank));
		return integer.orElse(0);
	}
}
