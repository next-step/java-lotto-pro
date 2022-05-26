package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {
	private final String INVALID_ORDER = "로또를 살 수 있는 개수를 초과했습니다.";

	private LottoNumberStrategy lottoNumberStrategy;

	public LottoMachine(LottoNumberStrategy lottoNumberStrategy) {
		this.lottoNumberStrategy = lottoNumberStrategy;
	}

	public LottoTickets generateByAuto(int count) {
		return new LottoTickets(getAutoLottoList(count));
	}

	public LottoTickets generateByManual(Ledger ledger) {
		if(!ledger.isValidOrder()) {
			throw new IllegalArgumentException(INVALID_ORDER);
		}

		List<Lotto> manualLottoList = ledger.getManualLottoList().stream()
								.map(Lotto::getInstanceByString)
								.collect(Collectors.toList());

		return new LottoTickets(manualLottoList);
	}

	public Lotto createLottoInstance(List<String> strLottoList) {
		return Lotto.getInstanceByString(strLottoList);
	}

	private List<Lotto> getAutoLottoList(int count) {
		List<Lotto> lottoList = new ArrayList<>();
		for(int index = 0; index < count; index +=1 ) {
			lottoList.add(new Lotto(lottoNumberStrategy.generate(Lotto.LOTTO_SIZE)));
		}

		return lottoList;
	}
}
