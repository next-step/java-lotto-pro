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
		List<Rank> rankList = lottoTickets.stream()
			.map(lotto -> lotto.match(winningLotto, number))
			.collect(Collectors.toList());

		Map<Rank, Long> countingResult = rankList.stream()
			.collect(Collectors.groupingBy(Rank::winnings, Collectors.counting()));

		return new RankResult(countingResult);
	}

	public List<LottoNumber> getLottTickets() {
		return Collections.unmodifiableList(lottoTickets.stream()
			.map(Lotto::getLotto)
			.collect(Collectors.toList()));
	}

	public void sum(LottoTickets lottoTickets) {
		this.lottoTickets.addAll(lottoTickets.lottoTickets);
	}
}
