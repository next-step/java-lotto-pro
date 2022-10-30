package lotto.controller.dto;

import static java.util.stream.Collectors.joining;

import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

public class PurchasedLottoTicketsResponse {

	private final List<List<Integer>> lottoNumbersList;

	private PurchasedLottoTicketsResponse(List<List<Integer>> lottoNumbersList) {
		this.lottoNumbersList = lottoNumbersList;
	}

	public static PurchasedLottoTicketsResponse of(LottoTickets lottoNumbersList) {
		return new PurchasedLottoTicketsResponse(lottoNumbersList.getLottoNumbersList());
	}

	public int getCount() {
		return lottoNumbersList.size();
	}

	public LottoTickets toLottoTickets() {
		return LottoTickets.of(
			lottoNumbersList.stream()
				.map(LottoTicket::of)
				.collect(Collectors.toList()));
	}

	@Override
	public String toString() {
		return lottoNumbersList.stream()
			.map(this::numbersToString)
			.collect(joining("\n"));
	}

	private String numbersToString(List<Integer> numbers) {
		return numbers.stream()
			.map(String::valueOf)
			.collect(joining(", ", "[", "]"));
	}
}
