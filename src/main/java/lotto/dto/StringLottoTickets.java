package lotto.dto;

import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.Lotto;

public class StringLottoTickets {
	List<StringLotto> lottoTickets;

	public StringLottoTickets(List<StringLotto> lottoTickets) {
		this.lottoTickets = lottoTickets;
	}

	public List<Lotto> convertToLottoList() {
		return lottoTickets.stream()
			.map(StringLotto::convertToLotto)
			.collect(Collectors.toList());
	}
}
