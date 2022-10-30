package lotto.controller.dto;

import static java.util.stream.Collectors.joining;

import java.util.List;

import lotto.domain.LottoTicket;

public class WinningLottoTicketResponse {
	private final List<Integer> winningWeekLottoTicket;

	private WinningLottoTicketResponse(List<Integer> winningWeekLottoTicket) {
		this.winningWeekLottoTicket = winningWeekLottoTicket;
	}

	public static WinningLottoTicketResponse of(List<Integer> lastWeekWinLottoTicket) {
		return new WinningLottoTicketResponse(lastWeekWinLottoTicket);
	}

	public LottoTicket toLottoTicket() {
		return LottoTicket.of(winningWeekLottoTicket);
	}

	@Override
	public String toString() {
		return winningWeekLottoTicket.stream()
			.map(String::valueOf)
			.collect(joining(",", "[", "]"));
	}
}
