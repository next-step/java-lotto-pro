package lotto.controller.dto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

public class LottoWinResultsRequest {
	private final BoughtLottoTicketsResponse boughtLottoTicketsResponse;
	private final WinningLottoTicketResponse winningLottoTicketResponse;
	private final int bonusNumber;

	public LottoWinResultsRequest(BoughtLottoTicketsResponse boughtLottoTicketsResponse,
								  WinningLottoTicketResponse winningLottoTicketResponse, int bonusNumber) {
		this.boughtLottoTicketsResponse = boughtLottoTicketsResponse;
		this.winningLottoTicketResponse = winningLottoTicketResponse;
		this.bonusNumber = bonusNumber;
	}

	public LottoTickets getBoughtLottoTickets() {
		return boughtLottoTicketsResponse.toLottoTickets();
	}

	public LottoTicket getWinningLottoTicket() {
		return winningLottoTicketResponse.toLottoTicket();
	}

	public LottoNumber getBonusLottoNumber() {
		return LottoNumber.of(bonusNumber);
	}
}
