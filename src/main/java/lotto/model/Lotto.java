package lotto.model;

public class Lotto {
	private LottoNumbers numbers;

	public Lotto() {
		numbers = new LottoNumbers();
	}

	/**
	 * 로또 번호들 반환
	 * @return 로또 번호들 객체
	 */
	public LottoNumbers getNumbers() {
		return numbers;
	}
}
