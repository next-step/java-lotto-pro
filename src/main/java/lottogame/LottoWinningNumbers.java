package lottogame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoWinningNumbers {

	private Set<LottoNumber> winningNumbers;

	private LottoWinningNumbers(List<LottoNumber> numbers) {
		winningNumbers=new HashSet<>();
		winningNumbers.addAll(numbers);
	}

	public static LottoWinningNumbers makeLottoWinningNumbers(List<Integer> numbers) {
		return new LottoWinningNumbers(converToLottoNumbers(numbers));
	}

	private static List<LottoNumber> converToLottoNumbers(List<Integer> numbers) {
		return numbers.stream()
			.map(number -> new LottoNumber(number))
			.collect(ArrayList::new,
				(numlist, lottoNumber) -> numlist.add(lottoNumber),
				(numlist1, numlist2) -> numlist1.addAll(numlist2));
	}

	public Set<LottoNumber> getWinningNumbers() {
		return winningNumbers;
	}
}
