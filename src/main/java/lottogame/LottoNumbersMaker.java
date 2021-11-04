package lottogame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbersMaker {
	protected static final int START_INCLUSIVE_NUMBER=1;	/* 로또 번호 최소값 */
	protected static final int END_EXCLUSIVE_NUMBER=45;	/* 로또 번호 최대값 */
	private static final List<Integer> lottoNumberCandidates = getLottoNumberCandidates();

	public static List<LottoNumber> makelottoNumbers() {
		Collections.shuffle(lottoNumberCandidates);
		return lottoNumberCandidates.stream().limit(6).map(number->new LottoNumber(number)).collect(Collectors.toList());
	}

	private static List<Integer> getLottoNumberCandidates(){
		return IntStream.range(START_INCLUSIVE_NUMBER, END_EXCLUSIVE_NUMBER+1)
			.collect(ArrayList::new,
				(pickedNumbers, number) -> pickedNumbers.add(number)
				, (pickedNumbers1, pickedNumbers2) -> pickedNumbers1.addAll(pickedNumbers2));
	}
}
