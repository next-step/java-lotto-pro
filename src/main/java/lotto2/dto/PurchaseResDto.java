package lotto2.dto;

import lotto2.domain.LottoTickets;

public class PurchaseResDto {

	private int manualLottoCount;

	private int autoLottoCount;

	private LottoTickets totalTickets;

	private int purchaseMoney;

	private PurchaseResDto() {
	}

	public static PurchaseResDto of(int manualLottoCount, int autoLottoCount, LottoTickets totalTickets,
		int purchaseMoney) {
		PurchaseResDto dto = new PurchaseResDto();
		dto.manualLottoCount = manualLottoCount;
		dto.autoLottoCount = autoLottoCount;
		dto.totalTickets = totalTickets;
		dto.purchaseMoney = purchaseMoney;
		return dto;
	}

	public int getManualLottoCount() {
		return manualLottoCount;
	}

	public int getAutoLottoCount() {
		return autoLottoCount;
	}

	public LottoTickets getTotalTickets() {
		return totalTickets;
	}

	public int getPurchaseMoney() {
		return this.purchaseMoney;
	}

}
