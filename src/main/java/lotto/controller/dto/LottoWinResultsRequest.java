package lotto.controller.dto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

public class LottoWinResultsRequest {
	private final PurchasedLottoTicketsResponse purchasePurchasedLottoTicketsResponse;
	private final WinningLottoTicketResponse winningLottoTicketResponse;
	private final int bonusNumber;

	public LottoWinResultsRequest(PurchasedLottoTicketsResponse purchasePurchasedLottoTicketsResponse,
								  WinningLottoTicketResponse winningLottoTicketResponse, int bonusNumber) {

		this.purchasePurchasedLottoTicketsResponse = purchasePurchasedLottoTicketsResponse;
		this.winningLottoTicketResponse = winningLottoTicketResponse;
		this.bonusNumber = bonusNumber;
	}

	public LottoTickets getPurchasedLottoTickets() {
		return purchasePurchasedLottoTicketsResponse.toLottoTickets();
	}

	public LottoTicket getWinningLottoTicket() {
		return winningLottoTicketResponse.toLottoTicket();
	}

	public LottoNumber getBonusLottoNumber() {
		return LottoNumber.of(bonusNumber);
	}
}
