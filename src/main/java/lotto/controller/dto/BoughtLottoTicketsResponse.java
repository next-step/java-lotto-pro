package lotto.controller.dto;

import static java.util.stream.Collectors.joining;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

public class BoughtLottoTicketsResponse {

	private final List<List<Integer>> manualLottoNumbers;
	private final List<List<Integer>> autoLottoNumbers;

	private BoughtLottoTicketsResponse(List<List<Integer>> manualLottoNumbers,
									   List<List<Integer>> autoLottoNumbers) {
		this.manualLottoNumbers = manualLottoNumbers;
		this.autoLottoNumbers = autoLottoNumbers;
	}

	public static BoughtLottoTicketsResponse of(LottoTickets manualLottoTickets, LottoTickets autoLottoTickets) {
		return new BoughtLottoTicketsResponse(manualLottoTickets.getLottoNumbersList(),
			autoLottoTickets.getLottoNumbersList());
	}

	public int getManualBoughtCount() {
		return manualLottoNumbers.size();
	}

	public int getAutoBoughtCount() {
		return autoLottoNumbers.size();
	}

	public LottoTickets toLottoTickets() {
		return LottoTickets.of(
			Stream.concat(
				toStream(manualLottoNumbers),
				toStream(autoLottoNumbers))
				.collect(Collectors.toList()));
	}

	private Stream<LottoTicket> toStream(List<List<Integer>> lottoNumbers) {
		return lottoNumbers.stream()
			.map(LottoTicket::of);
	}

	private String numbersToString(List<Integer> numbers) {
		return numbers.stream()
			.map(String::valueOf)
			.collect(joining(", ", "[", "]"));
	}

	@Override
	public String toString() {
		return manualLottoNumbers.stream()
			.map(this::numbersToString)
			.collect(joining("\n"));
	}
}
