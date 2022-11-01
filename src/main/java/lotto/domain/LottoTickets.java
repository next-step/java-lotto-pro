package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoTickets {

	private final List<LottoTicket> lottoTicketList;

	private LottoTickets(List<LottoTicket> lottoTicketList) {
		this.lottoTicketList = lottoTicketList;
	}

	public static LottoTickets of(List<LottoTicket> lottoNumbers) {
		return new LottoTickets(lottoNumbers);
	}

	public static LottoTickets ofList(List<List<Integer>> lottoNumbers) {
		return new LottoTickets(lottoNumbers.stream()
			.map(LottoTicket::of)
			.collect(Collectors.toList()));
	}

	public LottoWinPrizes match(LottoTicket comparedTicket, int bonusNumber) {
		return match(comparedTicket, LottoNumber.of(bonusNumber));
	}

	public LottoWinPrizes match(LottoTicket comparedTicket, LottoNumber bonusNumber) {
		return LottoWinPrizes.of(
			lottoTicketList.stream()
				.map(lottoTicket -> lottoTicket.match(comparedTicket, bonusNumber))
				.collect(Collectors.toList()));
	}

	public List<List<Integer>> getLottoNumbersList() {
		return lottoTicketList.stream()
			.map(LottoTicket::getLottoNumbers)
			.collect(Collectors.toList());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		LottoTickets that = (LottoTickets)o;
		return lottoTicketList.equals(that.lottoTicketList);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottoTicketList);
	}

	@Override
	public String toString() {
		return lottoTicketList.stream().map(LottoTicket::toString)
			.collect(Collectors.joining("\n"));
	}
}
