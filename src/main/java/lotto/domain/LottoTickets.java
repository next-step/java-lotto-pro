package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lotto.dto.LottoNumber;

public class LottoTickets {
	private final List<Lotto> lottoTickets;

	public LottoTickets(List<Lotto> lottoTickets) {
		this.lottoTickets = lottoTickets;
	}

	public RankResult getResult(Lotto winningLotto, Number number) {
		List<Rank> rankList = new ArrayList<>();
		for(Lotto lotto: lottoTickets) {
			rankList.add(lotto.match(winningLotto, number));
		}

		Map<Rank, Long> countingResult = rankList.stream()
			.collect(Collectors.groupingBy(Rank::winnings, Collectors.counting()));

		return new RankResult(countingResult);
	}

	public List<LottoNumber> getLottTickets() {
		return Collections.unmodifiableList(lottoTickets.stream()
			.map(Lotto::getLotto)
			.collect(Collectors.toList()));
	}
}
