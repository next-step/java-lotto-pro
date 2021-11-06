package lotto;

public class Lotto {
	private final LottoNumbers lottoNumbers;

	public Lotto() {
		this.lottoNumbers = new LottoNumbers(LottoNumberFactory.create());
	}

	public Lotto(int[] lottoNumbers) {
		this.lottoNumbers = new LottoNumbers(lottoNumbers);
	}

	public MatchedNumber countMatchNumber(int[] winningNumbers) {
		int count = 0;
		for (Integer winningNumber : winningNumbers) {
			count += lottoNumbers.isMatch(winningNumber);
		}
		return new MatchedNumber(count);
	}
}
