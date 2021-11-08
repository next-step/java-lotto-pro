package step3;

import java.util.ArrayList;
import java.util.List;

import step3.winner.WinningAmount;

public class LottoPapers {

	public List<LottoNumbers> papers;

	private LottoPapers(List<LottoNumbers> lottoNumbers) {
		this.papers = new ArrayList<>(lottoNumbers);
	}

	public static LottoPapers createPapers(List<LottoNumbers> lottoNumbers) {
		return new LottoPapers(lottoNumbers);
	}

	public int  findMatchLottoNumber(List<LottoNumber> userLottoNumbers) {
		int total = 0;
		for (LottoNumbers lottoNumbers : papers) {
			int match = lottoNumbers.match(userLottoNumbers);
			total += WinningAmount.valueOf(match);
		}
		return total;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (LottoNumbers paper : papers) {
			sb.append(paper).append("\n");
		}
		return sb.toString();
	}

}
