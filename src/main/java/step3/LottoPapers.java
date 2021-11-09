package step3;

import java.util.List;
import java.util.stream.Collectors;

public class LottoPapers {

	private final List<LottoNumbers> papers;

	private LottoPapers(List<LottoNumbers> lottoNumbers) {
		this.papers = lottoNumbers;
	}

	public static LottoPapers createPapers(List<LottoNumbers> lottoNumbers) {
		return new LottoPapers(lottoNumbers);
	}

	public List<Integer> findMatchLottoNumber(LottoNumbers userLottoNumbers) {
		return papers.stream()
			.map(lottoNumbers -> lottoNumbers.match(userLottoNumbers))
			.collect(Collectors.toList());
	}

	public int size() {
		return papers.size();
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
