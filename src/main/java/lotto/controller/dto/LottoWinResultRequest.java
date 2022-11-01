package lotto.controller.dto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

public class LottoWinResultRequest {

	private final List<List<Integer>> manualLottoNumbers;
	private final List<List<Integer>> autoLottoNumbers;
	private final List<Integer> winningLottoNumbers;
	private final int bonusNumber;

	public LottoWinResultRequest(List<List<Integer>> manualLottoNumbers,
								 List<List<Integer>> autoLottoNumbers,
								 List<Integer> winningLottoNumbers,
								 int bonusNumber) {
		this.manualLottoNumbers = manualLottoNumbers;
		this.autoLottoNumbers = autoLottoNumbers;
		this.winningLottoNumbers = winningLottoNumbers;
		this.bonusNumber = bonusNumber;
	}

	public static LottoWinResultRequest of(List<List<Integer>> manualLottoNumbers,
										   List<List<Integer>> autoLottoNumbers,
										   List<Integer> winningLottoNumbers,
										   int bonusNumber) {
		return new LottoWinResultRequest(manualLottoNumbers, autoLottoNumbers, winningLottoNumbers, bonusNumber);
	}

	public List<List<Integer>> getManualLottoNumbers() {
		return manualLottoNumbers;
	}

	public List<List<Integer>> getAutoLottoNumbers() {
		return autoLottoNumbers;
	}

	public LottoTickets getBoughtLottoTickets() {
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

	public List<Integer> getWinningLottoNumbers() {
		return winningLottoNumbers;
	}

	public int getBonusNumber() {
		return bonusNumber;
	}
}
