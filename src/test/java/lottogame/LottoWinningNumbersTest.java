package lottogame;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import lottogame.exception.DuplicateLottoNumberException;
import lottogame.exception.InvalidLottoFormatException;

public class LottoWinningNumbersTest {

	private static int SIZE_OF_LOTTERY_NUMBERS = 6;

	@ParameterizedTest
	@CsvSource({"3,34,22,17,26,7"})
	public void 당첨번호_리스트_입력(ArgumentsAccessor argumentsAccessor) {
		List<Integer> numbers = convertArgumentsToInteger(argumentsAccessor);
		LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.makeLottoWinningNumbers(numbers);
		assertThat(lottoWinningNumbers.getWinningNumbers().size()).isEqualTo(numbers.size());

		List<LottoNumber> lottoNumbers = convertToLottoNumbers(numbers);
		for (LottoNumber lottoNumber : lottoNumbers) {
			assertThat(lottoWinningNumbers.getWinningNumbers().contains(lottoNumber)).isTrue();
		}
	}

	@ParameterizedTest
	@CsvSource({"34,3,17,26,7,3"})
	public void 당첨번호_리스트_중복숫자_입력_예외(ArgumentsAccessor argumentsAccessor) {
		List<Integer> numbers = convertArgumentsToInteger(argumentsAccessor);
		assertThatThrownBy(() -> {
			LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.makeLottoWinningNumbers(numbers);
		}).isInstanceOf(DuplicateLottoNumberException.class);
	}

	@ParameterizedTest
	@CsvSource({"34,3,17,26,7"})
	public void 당첨번호_리스트_갯수가_작은경우_예외(ArgumentsAccessor argumentsAccessor) {
		List<Integer> numbers = convertArgumentsToInteger(argumentsAccessor);
		assertThatThrownBy(() -> {
			LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.makeLottoWinningNumbers(numbers);
		}).isInstanceOf(InvalidLottoFormatException.class);
	}

	@ParameterizedTest
	@CsvSource({"34,3,17,26,7,10,32"})
	public void 당첨번호_리스트_갯수가_큰경우_예외(ArgumentsAccessor argumentsAccessor) {
		List<Integer> numbers = convertArgumentsToInteger(argumentsAccessor);
		assertThatThrownBy(() -> {
			LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.makeLottoWinningNumbers(numbers);
		}).isInstanceOf(InvalidLottoFormatException.class);
	}

	@ParameterizedTest
	@ValueSource(strings = {"1, 31, 22, 15, 4, 7", "2, 43, 33, 25, 6, 7"})
	public void 당첨번호_문자열_입력(String lottoNumberText) {
		LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.makeLottoWinningNumbers(lottoNumberText);
		assertThat(lottoWinningNumbers.getWinningNumbers().size()).isEqualTo(SIZE_OF_LOTTERY_NUMBERS);
	}

	@ParameterizedTest
	@ValueSource(strings = {"1, 31, 22, 15, 4, 7, 5", "2, 43, 33, 25, 6"})
	public void 당첨번호_문자열_입력_로또갯수_예외(String lottoNumberText) {
		assertThatThrownBy(() -> {
			LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.makeLottoWinningNumbers(lottoNumberText);
		}).isInstanceOf(InvalidLottoFormatException.class);
	}

	@ParameterizedTest
	@ValueSource(strings = {"1,31,22,15,4,7", " 2, 43, 33, 25, 6, 10","2, 43, 33, 25, 6, 10 ","2 43 33 25 6 10"})
	public void 당첨번호_문자열_입력_포맷_예외(String lottoNumberText) {
		assertThatThrownBy(() -> {
			LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.makeLottoWinningNumbers(lottoNumberText);
		}).isInstanceOf(InvalidLottoFormatException.class);
	}

	// ArgumentsAccessor 타입을 Integer List로 변환
	private List<Integer> convertArgumentsToInteger(ArgumentsAccessor argumentsAccessor) {
		return argumentsAccessor.toList()
			.stream()
			.map(argument -> Integer.parseInt(String.valueOf(argument)))
			.collect(Collectors.toList());
	}

	// LottoNumber를 Set으로 담은 자료구조를 primitive 타입 int로 찾기 어려우므로 LottoNumber로 래핑
	private List<LottoNumber> convertToLottoNumbers(List<Integer> numbers) {
		return numbers.stream().map(number -> new LottoNumber(number)).collect(Collectors.toList());
	}

}
