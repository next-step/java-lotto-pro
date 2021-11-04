package lottogame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import lottogame.exception.DuplicateLottoNumberException;
import lottogame.exception.NotCorrectSizeOfLotto;

public class LottoWinningNumbers {

	private Set<LottoNumber> winningNumbers;

	private LottoWinningNumbers(List<LottoNumber> numbers) {
		winningNumbers=getDistinctLottoNumbers(numbers);
	}

	private Set<LottoNumber> getDistinctLottoNumbers(List<LottoNumber> numbers) {
		Set<LottoNumber> lottoNumbers = new HashSet<>();
		lottoNumbers.addAll(numbers);
		validateHasNotDuplicateLottoNumber(lottoNumbers);
		return lottoNumbers;
	}

	private void validateHasNotDuplicateLottoNumber(Set<LottoNumber> lottoNumbers) {
		if(lottoNumbers.size()<6){
			throw new DuplicateLottoNumberException("중복된 당첨번호를 입력하였습니다.");
		}
	}

	public static LottoWinningNumbers makeLottoWinningNumbers(List<Integer> numbers) {
		validateSizeOfLotto(numbers);
		return new LottoWinningNumbers(converToLottoNumbers(numbers));
	}

	private static void validateSizeOfLotto(List<Integer> numbers) {
		if(!isCorrectSizeOfLotto(numbers)){
			throw new NotCorrectSizeOfLotto("당첨 번호는 6개 입력하셔야 합니다.");
		}
	}

	private static boolean isCorrectSizeOfLotto(List<Integer> numbers) {
		if(numbers.size()==6){
			return true;
		}
		return false;
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
