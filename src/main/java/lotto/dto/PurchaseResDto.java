package lotto.dto;

import lotto.domain.LottoTickets;

public class PurchaseResDto {

	private final LottoTickets totalTickets;

	private final int purchaseMoney;

	public PurchaseResDto(LottoTickets totalTickets, int purchaseMoney) {
		this.totalTickets = totalTickets;
		this.purchaseMoney = purchaseMoney;
	}

	public LottoTickets getTotalTickets() {
		return totalTickets;
	}

	public int getPurchaseMoney() {
		return this.purchaseMoney;
	}

}
