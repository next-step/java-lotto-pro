package lottoservice.lottonumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 로또 번호 생성 클래스
 */
public class LottoNumbersMaker {
	public static final int SIZE_OF_LOTTERY_NUMBERS = 6;    /* 로또 번호 갯수 */
	protected static final int START_INCLUSIVE_NUMBER = 1;    /* 로또 번호 최소값 */
	protected static final int END_EXCLUSIVE_NUMBER = 45;    /* 로또 번호 최대값 */
	private static final List<LottoNumber> lottoNumberCandidates = getLottoNumberCandidates();    /* 1~45사이의 수를 로또 번호로 포장하여 저장 */

	/* Collections.shuffle 메서드를 이용하여 collection을 섞은 후 앞에서 부터 SIZE_OF_LOTTERY_NUMBERS 갯수만큼 subList  */
	public static List<LottoNumber> makeLottoNumbers() {
		Collections.shuffle(lottoNumberCandidates);
		List<LottoNumber> lottoNumbers = new ArrayList<>(lottoNumberCandidates.subList(0,
			SIZE_OF_LOTTERY_NUMBERS));  /*List의 subList는 deepCopy가 아니므로 새로 인스턴스를 생성하여 전달 */
		Collections.sort(lottoNumbers,
			(lottoNumberPre, lottoNumberPost) -> lottoNumberPre.getNumber() - lottoNumberPost.getNumber());
		return lottoNumbers;
	}

	private static List<LottoNumber> getLottoNumberCandidates() {
		return IntStream.range(START_INCLUSIVE_NUMBER, END_EXCLUSIVE_NUMBER + 1)
			.collect(ArrayList::new,
				(pickedNumbers, number) -> pickedNumbers.add(new LottoNumber(number))
				, (pickedNumbers1, pickedNumbers2) -> pickedNumbers1.addAll(pickedNumbers2));
	}
}
