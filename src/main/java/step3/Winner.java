package step3;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Winner {

	private static Map<Integer, Integer> winnings;
	private final Map<Integer, Integer> winningAmount;
	private int sumAmount;
	private int yield;

	public Winner() {
		winnings = new HashMap<>();
		winningAmount = new HashMap<>();
		winnings.put(3, 5_000);
		winnings.put(4, 50_000);
		winnings.put(5, 1_500_000);
		winnings.put(6, 2_000_000_000);
		winnings = Collections.unmodifiableMap(winnings);
	}

	public Map<Integer, Integer> statistics(String userInputWinnerNumber) {
		assert userInputWinnerNumber == null : "입력값이 null일 수 없습니다.";
		List<LottoNumbers> papers = LottoPapers.PAPERS;
		List<Integer> inputNumbers = getIntegers(userInputWinnerNumber);
		for (LottoNumbers paper : papers) {
			Integer matchNumber = findMatchLottoNumber(inputNumbers, paper);
			Optional<Integer> optAmount = Optional.ofNullable(winnings.get(matchNumber));
			Integer amount = optAmount.orElse(0);
			winningAmount.put(matchNumber, amount);
			sumAmount += amount;
		}
		return winningAmount;
	}

	public int yield(Money money) {
		yield = money.yield(sumAmount);
		return yield;
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
		return Arrays.stream(inputNumber.split(","))
			.mapToInt(Integer::parseInt)
			.boxed()
			.collect(Collectors.toList());
	}
}
