package lottogame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryNumberMaker {
	private static final int START_INCLUSIVE_NUMBER=1;	/* 로또 번호 최소값 */
	private static final int END_EXCLUSIVE_NUMBER=45;	/* 로또 번호 최대값 */
	private static final List<Integer> lotteryNumberCandidates = getLotteryNumberCandidates();

	public static LotteryNumberGroup makelotteryNumbers() {
		Collections.shuffle(lotteryNumberCandidates);
		LotteryNumberGroup lotteryNumberGroup =new LotteryNumberGroup(lotteryNumberCandidates.stream().limit(6).map(number->new LotterNumber(number)).collect(Collectors.toList()));
		return lotteryNumberGroup;
	}

	private static List<Integer> getLotteryNumberCandidates(){
		return IntStream.range(START_INCLUSIVE_NUMBER, END_EXCLUSIVE_NUMBER+1)
			.collect(ArrayList::new,
				(pickedNumbers, number) -> pickedNumbers.add(number)
				, (pickedNumbers1, pickedNumbers2) -> pickedNumbers1.addAll(pickedNumbers2));
	}
}
