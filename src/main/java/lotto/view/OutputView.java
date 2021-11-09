package lotto.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import lotto.exception.LottoException;
import lotto.model.LottoNumbers;
import lotto.model.LottoRank;
import lotto.model.LottoResult;
import lotto.model.Lottos;

public class OutputView {
	private final static String STARTING_BRACKET = "[";
	private final static String END_BRACKET = "]";
	private final static String SEPARATOR_BRACKET = " ,";
	private final static int START_INDEX_CALCULATE_NUMBER = 0;
	private final static int LAST_INDEX_CALCULATE_NUMBER = 1;

	public static void printCompletePurchaseLotto(Lottos lottos) {
		System.out.println(lottos.size() + "개를 구입했습니다.");
	}

	public static void printLottoNumbers(Lottos lottos) {
		for (LottoNumbers lottoNumbers : lottos.getLottoNumbersList()) {
			System.out.println(lottoNumbersToString(lottoNumbers));
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

	public static void printErrorMessage(LottoException lottoException) {
		System.out.println(lottoException.getMessage());
	}

	public static List<String> convertRankMapToStringList(LottoResult lottoResult) {
		List<String> rankStringList = new ArrayList<>();
		for (Map.Entry<LottoRank, Integer> rankEntry : lottoResult.getRankCodeMapUsingContainsMap().entrySet()) {
			validNothing(rankStringList, rankEntry);
		}
		Collections.sort(rankStringList);

		return rankStringList;
	}

	public static String convertYieldToString(LottoResult lottoResult) {
		StringBuilder stringBuilder = new StringBuilder();
		double yield = lottoResult.getYield();
		stringBuilder
			.append("총 수익률은 ")
			.append(yield)
			.append("입니다.");
		appendLossYield(stringBuilder, yield);

		return stringBuilder.toString();
	}

	public static void appendLossYield(StringBuilder stringBuilder, double yield) {
		if (validLossYield(yield)) {
			stringBuilder.append("(기준이 1이기 떄문에 결과적으로 손해라는 의미임)");
		}
	}

	public static boolean validLossYield(double yield) {
		return yield < LottoResult.COUNT_VALUE;
	}

	public static void validNothing(List<String> rankStringList, Map.Entry<LottoRank, Integer> rankEntry) {
		if (validNothing(rankEntry)) {
			rankStringList.add(stringBuilderAppend(rankEntry));
		}
	}

	public static boolean validNothing(Map.Entry<LottoRank, Integer> rankEntry) {
		return rankEntry.getKey() != LottoRank.NOTHING;
	}

	public static String stringBuilderAppend(Map.Entry<LottoRank, Integer> rankEntry) {
		LottoRank lottoRank = rankEntry.getKey();
		StringBuilder stringBuilder = new StringBuilder();
		if (lottoRank == LottoRank.SECOND) {
			return stringBuilderSecondRankAppend(stringBuilder, rankEntry);
		}
		return stringBuilder
			.append(LottoRank.containsCount(lottoRank))
			.append("개 일치 ")
			.append("(")
			.append(LottoRank.getMoney(lottoRank))
			.append("원)- ")
			.append(rankEntry.getValue())
			.append("개").toString();
	}

	public static String stringBuilderSecondRankAppend(StringBuilder stringBuilder,
		Map.Entry<LottoRank, Integer> rankEntry) {
		return stringBuilder
			.append(LottoRank.containsCount(rankEntry.getKey()))
			.append("개 일치, 보너스 볼 일치")
			.append("(")
			.append(LottoRank.getMoney(rankEntry.getKey()))
			.append("원)- ")
			.append(rankEntry.getValue())
			.append("개").toString();
	}

	public static String lottoNumbersToString(LottoNumbers lottoNumbers) {
		StringBuilder sb = new StringBuilder();
		int size = lottoNumbers.lottoNumberList.size();
		sb.append(STARTING_BRACKET);
		for (int i = START_INDEX_CALCULATE_NUMBER; i < size; i++) {
			sb.append(lottoNumbers.lottoNumberList.get(i).toInt());
			addSeparatorInBracket(sb, i, size);
		}
		sb.append(END_BRACKET);
		return sb.toString();
	}

	private static void addSeparatorInBracket(StringBuilder sb, int i, int size) {
		if (i < size - LAST_INDEX_CALCULATE_NUMBER) {
			sb.append(SEPARATOR_BRACKET);
		}
	}
}
