package lotto.dto;

import java.util.List;

public class WinningReqDto {

	private List<Integer> winningNumbers;

	private int bonusNumber;

	public WinningReqDto(List<Integer> winningNumbers, int bonusNumber) {
		this.winningNumbers = winningNumbers;
		this.bonusNumber = bonusNumber;
	}

	public List<Integer> getWinningNumbers() {
		return winningNumbers;
	}

	public int getBonusNumber() {
		return bonusNumber;
	}

}
