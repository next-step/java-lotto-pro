package lotto.model;

import java.util.Arrays;

public class WinningLottoNumbers extends LottoNumbers {
	private final LottoNumber bonusNumber;

	public WinningLottoNumbers(int[] arrayIntNumbers, int bonusNumber) {
		super(arrayIntNumbers);
		this.bonusNumber = new LottoNumber(bonusNumber);
		if (this.numbers.contains(this.bonusNumber)) {
			throw new IllegalArgumentException("보너스 번호는 당첨번호와 다른 번호여야 합니다. ("+this.numbers+" / "+this.bonusNumber+")");
		}
	}

	public WinningLottoNumbers(String numbers, String bunusNumber) {
		this(convertStringNumbersToIntArray(numbers), Integer.parseInt(bunusNumber));
	}

	/**
	 * 입력받은 로또의 당첨결과
	 * @param lotto 로또
	 * @return 당첨결과
	 */
	public Rank result(Lotto lotto) {
		int countOfMatch = (int)numbers.stream()
			.filter(lotto::contains)
			.count();
		boolean matchBonus = lotto.contains(bonusNumber);
		return Rank.valueOf(countOfMatch, matchBonus);
	}
}
