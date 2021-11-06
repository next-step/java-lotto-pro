package step3;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Winner {

	private static final int THREE = 3;
	private static final int FOUR = 4;
	private static final int FIVE = 5;
	private static final int SIX = 6;

	private static Map<Integer, Integer> winnings;
	private final Map<Integer, Integer> winningAmount;
	private int sumAmount;
	private BigDecimal yield;

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
		assert userInputWinnerNumber != null;
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

	public BigDecimal yield(Money money) {
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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("3개 일치 (5000원)-").append(getWinner(THREE)).append("개").append("\n");
		sb.append("4개 일치 (50000원)-").append(getWinner(FOUR)).append("개").append("\n");
		sb.append("5개 일치 (1500000원)-").append(getWinner(FIVE)).append("개").append("\n");
		sb.append("6개 일치 (2000000000원)-").append(getWinner(SIX)).append("개").append("\n");
		sb.append("총 수익률은 ").append(yield).append("입니다.");
		return sb.toString();
	}

	private Integer getWinner(int matchCount) {
		Optional<Integer> integer = Optional.ofNullable(winningAmount.get(matchCount));
		return integer.orElse(0);
	}
}
