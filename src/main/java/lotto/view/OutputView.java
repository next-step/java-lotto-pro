package lotto.view;

import lotto.model.LottoGenerator;
import lotto.model.LottoNumbers;
import lotto.model.LottoResult;

public class OutputView {

	public static void printCompletePurchaseLotto(int size) {
		System.out.println(size + "개를 구입했습니다.");
	}

	public static void printLottoNumbers(LottoGenerator lottoGenerator) {
		for (LottoNumbers lottoNumbers : lottoGenerator.getLottoNumbersList()) {
			System.out.println(lottoNumbers.listToString());
		}
	}

	public static void printResultHead() {
		System.out.println("");
		System.out.println("당첨 통계");
		System.out.println("---------");
	}

	public static void printResultLottoList(LottoResult lottoResult) {
		for (String result : lottoResult.convertRankMapToStringList()) {
			System.out.println(result);
		}
	}

	public static void printYieldResult(LottoResult lottoResult) {
		System.out.println(lottoResult.convertYieldToString());
	}
}