package lotto.dto;

import java.util.List;

public class WinningReqDto {

	private final List<Integer> winningNumbers;

	private final int bonusNumber;

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
