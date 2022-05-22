package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
	private LottoNumberStrategy lottoNumberStrategy;

	public LottoMachine(LottoNumberStrategy lottoNumberStrategy) {
		this.lottoNumberStrategy = lottoNumberStrategy;
	}

	public List<Lotto> generate(int count) {
		List<Lotto> lottoTickets = new ArrayList<>();
		for(int index = 0; index < count; index +=1 ) {
			lottoTickets.add(new Lotto(lottoNumberStrategy.generate(Lotto.LOTTO_SIZE)));
		}

		return lottoTickets;
	}
}
