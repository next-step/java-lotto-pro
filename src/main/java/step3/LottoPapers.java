package step3;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class LottoPapers extends AbstractList<LottoNumbers> {

	public List<LottoNumbers> papers;

	private LottoPapers(List<LottoNumbers> lottoNumbers) {
		this.papers = new ArrayList<>(lottoNumbers);
	}

	public static LottoPapers createPapers(List<LottoNumbers> lottoNumbers) {
		return new LottoPapers(lottoNumbers);
	}

	@Override
	public int size() {
		return papers.size();
	}

	@Override
	public LottoNumbers get(int index) {
		return papers.get(index);
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
