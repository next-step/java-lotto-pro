package lotto.controller.dto;

import static java.util.stream.Collectors.joining;

import java.util.List;
import java.util.stream.Stream;

import lotto.domain.LottoTickets;

public class BoughtLottoResponse {

	private final List<List<Integer>> manualLottoNumbers;
	private final List<List<Integer>> autoLottoNumbers;

	private BoughtLottoResponse(List<List<Integer>> manualLottoNumbers,
								List<List<Integer>> autoLottoNumbers) {
		this.manualLottoNumbers = manualLottoNumbers;
		this.autoLottoNumbers = autoLottoNumbers;
	}

	public static BoughtLottoResponse of(LottoTickets manualLottoTickets, LottoTickets autoLottoTickets) {
		return new BoughtLottoResponse(
			manualLottoTickets.getLottoNumbersList(),
			autoLottoTickets.getLottoNumbersList());
	}

	public int getManualBoughtCount() {
		return manualLottoNumbers.size();
	}

	public int getAutoBoughtCount() {
		return autoLottoNumbers.size();
	}

	public List<List<Integer>> getManualLottoNumbers() {
		return manualLottoNumbers;
	}

	public List<List<Integer>> getAutoLottoNumbers() {
		return autoLottoNumbers;
	}

	private String numbersToString(List<Integer> numbers) {
		return numbers.stream()
			.map(String::valueOf)
			.collect(joining(", ", "[", "]"));
	}

	@Override
	public String toString() {
		return Stream.concat(
			manualLottoNumbers.stream()
				.map(this::numbersToString),
			autoLottoNumbers.stream()
				.map(this::numbersToString))
			.collect(joining("\n"));
	}
}
