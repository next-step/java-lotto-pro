package lotto.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import lotto.model.LottoGenerator;
import lotto.model.LottoNumbers;
import lotto.model.LottoResult;
import lotto.model.RankCode;

public class OutputView {

	public static void printCompletePurchaseLotto(LottoGenerator lottoGenerator) {
		System.out.println(lottoGenerator.size() + "개를 구입했습니다.");
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
		for (String result : convertRankMapToStringList(lottoResult)) {
			System.out.println(result);
		}
	}

	public static void printYieldResult(LottoResult lottoResult) {
		System.out.println(convertYieldToString(lottoResult));
	}

	public static List<String> convertRankMapToStringList(LottoResult lottoResult) {
		List<String> rankStringList = new ArrayList<>();
		for (Map.Entry<RankCode, Integer> rankEntry : lottoResult.getRankCodeMapUsingContainsMap().entrySet()) {
			validNothing(rankStringList, rankEntry);
		}
		Collections.sort(rankStringList);

		return rankStringList;
	}

	public static String convertYieldToString(LottoResult lottoResult) {
		StringBuilder stringBuilder = new StringBuilder();
		double yield = lottoResult.calculateYield();
		stringBuilder
			.append("총 수익률은 ")
			.append(yield)
			.append("입니다.");
		if (yield < LottoResult.COUNT_VALUE) {
			stringBuilder.append("(기준이 1이기 떄문에 결과적으로 손해라는 의미임)");
		}
		return stringBuilder.toString();
	}

	public static void validNothing(List<String> rankStringList, Map.Entry<RankCode, Integer> rankEntry) {
		if (rankEntry.getKey() != RankCode.NOTHING) {
			rankStringList.add(stringBuilderAppend(rankEntry));
		}
	}

	public static String stringBuilderAppend(Map.Entry<RankCode, Integer> rankEntry) {
		RankCode rankCode = rankEntry.getKey();
		StringBuilder stringBuilder = new StringBuilder();
		return stringBuilder
			.append(RankCode.containsCount(rankCode))
			.append("개 일치 ")
			.append("(")
			.append(RankCode.getMoney(rankCode))
			.append("원)- ")
			.append(rankEntry.getValue())
			.append("개").toString();
	}
}
