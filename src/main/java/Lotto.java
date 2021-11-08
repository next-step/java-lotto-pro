import java.util.Collections;
import java.util.List;

public class Lotto {

	public final static int PRICE_KRW = 1000;
	public final static int NUM_OF_LOTTO_NUMBERS = 6;

	protected final List<LottoNumber> lottoNumbers;

	protected Lotto(List<LottoNumber> lottoNumbers) {
		validate(lottoNumbers);
		this.lottoNumbers = lottoNumbers;
		Collections.sort(this.lottoNumbers);
	}

	private void validate(List<LottoNumber> lottoNumbers) {
		if (null == lottoNumbers) {
			throw new LottoFormatException();
		}
		if (lottoNumbers.size() != NUM_OF_LOTTO_NUMBERS) {
			throw new LottoFormatException();
		}
		if (lottoNumbers.size() != lottoNumbers.stream().distinct().count()) {
			throw new LottoFormatException();
		}
	}

	public boolean hasBonus(WinningLotto winningLotto) {
		return this.lottoNumbers.contains(winningLotto.getBonus());
	}

	@Override
	public String toString() {
		return this.lottoNumbers.toString();
	}
}
