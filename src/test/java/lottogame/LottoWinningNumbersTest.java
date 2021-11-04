package lottogame;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lottogame.exception.DuplicateLottoNumberException;
import lottogame.exception.NotCorrectSizeOfLottoException;

public class LottoWinningNumbersTest {

	private static int SIZE_OF_LOTTERY_NUMBERS = 6;

	@Test
	public void 당첨번호_리스트_입력() {
		List<Integer> numbers = Arrays.asList(3,34,22,17,26,7);
		LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.makeLottoWinningNumbers(numbers);
		assertThat(lottoWinningNumbers.getWinningNumbers().size()).isEqualTo(numbers.size());

		List<LottoNumber> lottoNumbers=convertToLottoNumbers(numbers);
		for(LottoNumber lottoNumber : lottoNumbers){
			assertThat(lottoWinningNumbers.getWinningNumbers().contains(lottoNumber)).isTrue();
		}
	}

	@Test
	public void 당첨번호_리스트_중복숫자_입력_예외() {
		List<Integer> numbers = Arrays.asList(34,3,17,26,7);
		assertThatThrownBy(()->{
			LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.makeLottoWinningNumbers(numbers);
		}).isInstanceOf(DuplicateLottoNumberException.class);
	}

	@Test
	public void 당첨번호_리스트_갯수가_작은경우_예외() {
		List<Integer> numbers = Arrays.asList(34,3,17,26,7);
		assertThatThrownBy(()->{
			LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.makeLottoWinningNumbers(numbers);
		}).isInstanceOf(NotCorrectSizeOfLottoException.class);
	}

	@Test
	public void 당첨번호_리스트_갯수가_큰경우_예외() {
		List<Integer> numbers = Arrays.asList(34,3,17,26,7,10,32);
		assertThatThrownBy(()->{
			LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.makeLottoWinningNumbers(numbers);
		}).isInstanceOf(NotCorrectSizeOfLottoException.class);
	}

	// LottoNumber를 Set으로 담은 자료구조를 primitive 타입 int로 찾기 어려우므로 LottoNumber로 래핑
	private List<LottoNumber> convertToLottoNumbers(List<Integer> numbers){
		return numbers.stream().map(number -> new LottoNumber(number)).collect(Collectors.toList());
	}

	@Test
	public void 당첨번호_문자열_입력() {
		String lottoNumberText="1, 31, 22, 15, 4, 7";
		List<Integer> numbers = Arrays.asList(1,31,22,15,4,7);
		LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.makeLottoWinningNumbers(lottoNumberText);
		assertThat(lottoWinningNumbers.getWinningNumbers().size()).isEqualTo(SIZE_OF_LOTTERY_NUMBERS);

		List<LottoNumber> lottoNumbers=convertToLottoNumbers(numbers);
		for(LottoNumber lottoNumber : lottoNumbers){
			assertThat(lottoWinningNumbers.getWinningNumbers().contains(lottoNumber)).isTrue();
		}
	}


}
