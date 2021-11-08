package lotto2.dto;

import java.util.List;

public class PurchaseReqDto {

	private final int money;

	private final List<List<Integer>> manualLottoNumbers;

	public PurchaseReqDto(int money, List<List<Integer>> manualLottoNumbers) {
		this.money = money;
		this.manualLottoNumbers = manualLottoNumbers;
	}

	public int getMoney() {
		return money;
	}

	public List<List<Integer>> getManualLottoNumbers() {
		return manualLottoNumbers;
	}
	
}
