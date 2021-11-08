package lotto.model;

import java.util.Arrays;

public class WinningLottoNumbers extends LottoNumbers {
	public WinningLottoNumbers(int...arrayIntNumbers) {
		super(arrayIntNumbers);
	}

	public WinningLottoNumbers(String numbers) {
		this(convertStringNumbersToIntArray(numbers));
	}

	/**
	 * 콤마로 구분된 번호 문자열값을 정수 배열로 변환
	 * @param nubmers 콤마로 구분된 번호 문자열
	 * @return 정수 배열
	 */
	public static int[] convertStringNumbersToIntArray(String nubmers) {
		return Arrays.stream(nubmers.split(","))
			.map(String::trim)
			.mapToInt(Integer::parseInt).toArray();
	}

	/**
	 * 입력받은 로또의 당첨결과
	 * @param lotto 로또
	 * @return 당첨결과
	 */
	public Rank result(Lotto lotto) {
		int match = (int)numbers.stream()
			.filter(lotto::contains)
			.count();
		return Rank.valueOf(match, false);		//TODO 임시처리. 추후수정필요
	}
}
