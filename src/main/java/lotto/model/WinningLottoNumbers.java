package lotto.model;

public class WinningLottoNumbers extends LottoNumbers {
	public WinningLottoNumbers(int...arrayIntNumbers) {
		super(arrayIntNumbers);
	}

	public LottoResult result(Lotto lotto) {
		int match = (int)numbers.stream().filter(lotto::contains).count();
		return LottoResult.getResult(match);
	}
}
