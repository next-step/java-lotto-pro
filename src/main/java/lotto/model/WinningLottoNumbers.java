package lotto.model;

import java.util.Arrays;

public class WinningLottoNumbers extends LottoNumbers {
	public WinningLottoNumbers(int...arrayIntNumbers) {
		super(arrayIntNumbers);
	}

	public WinningLottoNumbers(String numbers) {
		this(convertStringNumbersToIntArray(numbers));
	}

	public static int[] convertStringNumbersToIntArray(String nubmers) {
		return Arrays.stream(nubmers.split(","))
			.map(String::trim)
			.mapToInt(Integer::parseInt).toArray();
	}

	public LottoResult result(Lotto lotto) {
		int match = (int)numbers.stream().filter(lotto::contains).count();
		return LottoResult.getResult(match);
	}
}
