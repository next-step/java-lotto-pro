package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
	private List<Lotto> lottoTickets;

	public LottoTickets(List<Lotto> lottoTickets) {
		this.lottoTickets = lottoTickets;
	}

	public LottoTickets() {
		this.lottoTickets = new ArrayList<>();
	}

	public void addLotto(Lotto lotto) {
		lottoTickets.add(lotto);
	}

	public RankResult getResult(Lotto winningLotto) {
		RankResult rankResult = new RankResult();

		for(Lotto lotto: lottoTickets) {
			Rank rank = lotto.match(winningLotto);

			rankResult.setUp(rank);
		}

		return rankResult;
	}
}
