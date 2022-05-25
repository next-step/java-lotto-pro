package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {
	private LottoNumberStrategy lottoNumberStrategy;

	public LottoMachine(LottoNumberStrategy lottoNumberStrategy) {
		this.lottoNumberStrategy = lottoNumberStrategy;
	}

	public LottoTickets generate(int count) {
		List<Lotto> lottoTickets = new ArrayList<>();
		for(int index = 0; index < count; index +=1 ) {
			lottoTickets.add(new Lotto(lottoNumberStrategy.generate(Lotto.LOTTO_SIZE)));
		}

		return new LottoTickets(lottoTickets);
	}

	public LottoTickets generate(Ledger ledger) {
		if(!ledger.isValidOrder()) {
			throw new IllegalArgumentException("");
		}

		List<List<String>> manualLottoList = ledger.getManualLottoList();

		return new LottoTickets(manualLottoList.stream()
			.map(Lotto::getInstanceByString)
			.collect(Collectors.toList()));
	}
}
