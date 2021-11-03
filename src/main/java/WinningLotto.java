import java.util.List;

public class WinningLotto extends Lotto {

	private WinningLotto(List<LottoNumber> lottoNumbers) {
		super(lottoNumbers);
	}

	public static WinningLotto from(String s) {
		return new WinningLotto(LottoParser.parse(s));
	}

	public int countMatching(Lotto lotto) {
		int count = 0;
		for (LottoNumber lottoNumber : lotto.lottoNumbers) {
			count += (this.lottoNumbers.contains(lottoNumber) ? 1 : 0);
		}
		return count;
	}
}
