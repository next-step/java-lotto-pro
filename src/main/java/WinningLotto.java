import java.util.List;

public class WinningLotto extends Lotto {

	private WinningLotto(List<LottoNumber> lottoNumbers) {
		super(lottoNumbers);
	}

	public static WinningLotto from(String s) {
		return new WinningLotto(LottoParser.parse(s));
	}

	public int countMatching(Lotto lotto) {
		return lotto.lottoNumbers.stream()
			.reduce(0, (acc, lottoNumber) -> acc + countIfContains(lottoNumber), Integer::sum);
	}

	private int countIfContains(LottoNumber lottoNumber) {
		return this.lottoNumbers.contains(lottoNumber) ? 1 : 0;
	}
}
