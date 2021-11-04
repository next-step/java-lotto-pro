package lottogame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryNumberMaker {
	private static final int START_INCLUSIVE_NUMBER=1;	/* 로또 번호 최소값 */
	private static final int END_EXCLUSIVE_NUMBER=45;	/* 로또 번호 최대값 */
	private static final List<Integer> lotteryNumberCandidates = getLotteryNumberCandidates();

	public static List<Integer> makelotteryNumbers() {
		Collections.shuffle(lotteryNumberCandidates);
		List<Integer> lotteryNumbers=lotteryNumberCandidates.stream().limit(6).collect(Collectors.toList());
		return lotteryNumbers;
	}

	private static List<Integer> getLotteryNumberCandidates(){
		return IntStream.range(START_INCLUSIVE_NUMBER, END_EXCLUSIVE_NUMBER+1)
			.collect(() -> new ArrayList<>(),
				(pickedNumbers, number) -> pickedNumbers.add(number)
				, (pickedNumbers1, pickedNumbers2) -> pickedNumbers1.addAll(pickedNumbers2));
	}
}
