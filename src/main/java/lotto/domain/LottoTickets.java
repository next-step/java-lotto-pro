package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lotto.dto.LottoNumber;

public class LottoTickets {
	private List<Lotto> lottoTickets;

	public LottoTickets(List<Lotto> lottoTickets) {
		this.lottoTickets = lottoTickets;
	}

	public LottoTickets() {
		this.lottoTickets = new ArrayList<>();
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

	public void generate(LottoNumberStrategy lottoNumberStrategy) {
		lottoTickets.add(lottoNumberStrategy.generate());
	}

	public List<LottoNumber> getLottTickets() {
		return lottoTickets.stream()
			.map(Lotto::getLotto)
			.collect(Collectors.toList());
	}
}
