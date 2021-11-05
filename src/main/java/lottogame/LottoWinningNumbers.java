package lottogame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import lottogame.exception.DuplicateLottoNumberException;
import lottogame.exception.NotCorrectSizeOfLottoException;
import lottogame.exception.NotDigitLottoNumberException;

public class LottoWinningNumbers {

	private static int SIZE_OF_LOTTERY_NUMBERS = 6;
	private Set<LottoNumber> winningNumbers;

	private LottoWinningNumbers(List<LottoNumber> numbers) {
		winningNumbers = getDistinctLottoNumbers(numbers);
	}

	private Set<LottoNumber> getDistinctLottoNumbers(List<LottoNumber> numbers) {
		Set<LottoNumber> lottoNumbers = new HashSet<>();
		lottoNumbers.addAll(numbers);
		validateHasNotDuplicateLottoNumber(lottoNumbers);
		return lottoNumbers;
	}

	private void validateHasNotDuplicateLottoNumber(Set<LottoNumber> lottoNumbers) {
		if (lottoNumbers.size() < SIZE_OF_LOTTERY_NUMBERS) {
			throw new DuplicateLottoNumberException("중복된 당첨번호를 입력하였습니다.");
		}
	}

	public static LottoWinningNumbers makeLottoWinningNumbers(List<Integer> numbers) {
		validateSizeOfLotto(numbers);
		return new LottoWinningNumbers(converToLottoNumbers(numbers));
	}

	private static void validateSizeOfLotto(List<Integer> numbers) {
		if (!isCorrectSizeOfLotto(numbers)) {
			throw new NotCorrectSizeOfLottoException("당첨 번호는 6개 입력하셔야 합니다.");
		}
	}

	private static boolean isCorrectSizeOfLotto(List<Integer> numbers) {
		if (numbers.size() == SIZE_OF_LOTTERY_NUMBERS) {
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

	public static LottoWinningNumbers makeLottoWinningNumbers(String lottoNumberText) {
		String[] splitedTexts= lottoNumberText.split(", ");
		List<Integer> numbers =parseTextToNumbers(splitedTexts);
		return makeLottoWinningNumbers(numbers);
	}

	private static List<Integer> parseTextToNumbers(String[] splitedTexts) {
		try {
			return Arrays.stream(splitedTexts)
				.map(splitedNumber -> Integer.parseInt(splitedNumber))
				.collect(Collectors.toList());
		}catch (NumberFormatException ex){
			throw new NotDigitLottoNumberException("입력형식이 올바르지 않습니다. 로또번호 숫자와 구분자(, )를 형식에 맞게 입력해주세요.");
		}
	}

	public int compareWithNumbers(List<LottoNumber> ticketLottoNumbers) {
		int matchCount=0;
		for(LottoNumber number : ticketLottoNumbers){
			matchCount+=isMatchNumber(number) ? 1 : 0;
		}
		return matchCount;
	}

	private boolean isMatchNumber(LottoNumber number) {
		if(winningNumbers.contains(number)){
			return true;
		}
		return false;
	}
}
