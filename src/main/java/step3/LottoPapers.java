package step3;

import java.util.ArrayList;
import java.util.List;

public class LottoPapers {

	private static LottoPapers INSTANCE;
	public static List<LottoNumbers> PAPERS;

	private LottoPapers() {
	}

	private LottoPapers(List<LottoNumbers> lottoPapers) {
		PAPERS = lottoPapers;
	}

	public static LottoPapers getInstance() {
		synchronized (LottoPapers.class) {
			if (INSTANCE != null) {
				INSTANCE = new LottoPapers(new ArrayList<>());
			}
		}
		return INSTANCE;
	}

	public static void createPapers(List<LottoNumbers> lottoNumbers) {
		PAPERS = lottoNumbers;
	}
}
