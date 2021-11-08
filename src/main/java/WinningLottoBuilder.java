public final class WinningLottoBuilder {

	private String lottoNumbers;
	private String bonus;

	private WinningLottoBuilder() {
	}

	public static WinningLottoBuilder aWinningLotto() {
		return new WinningLottoBuilder();
	}

	public WinningLottoBuilder withLottoNumbers(String lottoNumbers) {
		this.lottoNumbers = lottoNumbers;
		return this;
	}

	public WinningLottoBuilder withBonus(String bonus) {
		this.bonus = bonus;
		return this;
	}

	public WinningLotto build() {
		return new WinningLotto(LottoParser.parse(lottoNumbers), LottoNumber.from(bonus));
	}
}
