package step3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Winner {

	private static Map<Integer, Integer> winnerAmount;

	public Winner() {
		winnerAmount = new HashMap<>();
		winnerAmount.put(3, 5_000);
		winnerAmount.put(4, 50_000);
		winnerAmount.put(5, 1_500_000);
		winnerAmount.put(6, 2_000_000_000);
		winnerAmount = Collections.unmodifiableMap(winnerAmount);
	}
	public List<Integer> statistics(String userInputWinnerNumber) {
		List<LottoNumbers> papers = LottoPapers.PAPERS;
		List<Integer> inputNumbers = getIntegers(userInputWinnerNumber);
		List<Integer> result = new ArrayList<>();
		for (LottoNumbers paper : papers) {
			Integer matchNumber = findMatchLottoNumber(inputNumbers, paper);
			result.add(winnerAmount.get(matchNumber));
		}
		return result;
	}

	private Integer findMatchLottoNumber(List<Integer> collect, LottoNumbers paper) {
		Integer match = 0;
		for (Integer integer : collect) {
			match += paper.match(new LottoNumber(integer));
		}
		return match;
	}

	private List<Integer> getIntegers(String userInputWinnerNumber) {
		final String inputNumber = userInputWinnerNumber.replaceAll("\\s+", "");
		List<Integer> collect = Arrays.stream(inputNumber.split(","))
			.mapToInt(Integer::parseInt)
			.boxed()
			.collect(Collectors.toList());
		return collect;
	}
}
