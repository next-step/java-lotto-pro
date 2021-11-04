package com.example.lotto;

public class WinningLottoNumbers {
	private final LottoNumbers baseNumbers;
	private final LottoNumber bonusNumber;

	public WinningLottoNumbers(LottoNumbers baseNumbers, LottoNumber bonusNumber) {
		this.baseNumbers = baseNumbers;
		this.bonusNumber = bonusNumber;
	}

	public LottoNumbers getBaseNumbers() {
		return baseNumbers;
	}

	public LottoNumber getBonusNumber() {
		return bonusNumber;
	}
}
