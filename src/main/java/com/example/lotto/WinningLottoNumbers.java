package com.example.lotto;

public class WinningLottoNumbers {
	private final LottoNumbers baseNumbers;
	private final LottoNumber bonusNumber;

	public WinningLottoNumbers(LottoNumbers baseNumbers, LottoNumber bonusNumber) {
		this.baseNumbers = baseNumbers;
		this.bonusNumber = bonusNumber;
	}

	static WinningLottoNumbers of(LottoNumbers baseNumbers, LottoNumber bonusNumber) {
		if (baseNumbers.contains(bonusNumber)) {
			throw new IllegalArgumentException("기본 당첨 번호들과 보너스 당첨 번호는 중복될 수 없습니다.");
		}

		return new WinningLottoNumbers(baseNumbers, bonusNumber);
	}

	public LottoNumbers getBaseNumbers() {
		return baseNumbers;
	}

	public LottoNumber getBonusNumber() {
		return bonusNumber;
	}
}
