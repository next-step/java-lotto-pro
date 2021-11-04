package lottogame;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import lottogame.exception.DuplicateLottoNumberException;
import lottogame.exception.NotCorrectSizeOfLotto;

public class LottoWinningNumbersTest {

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
		}).isInstanceOf(NotCorrectSizeOfLotto.class);
	}

	@Test
	public void 당첨번호_리스트_갯수가_큰경우_예외() {
		List<Integer> numbers = Arrays.asList(34,3,17,26,7,10,32);
		assertThatThrownBy(()->{
			LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.makeLottoWinningNumbers(numbers);
		}).isInstanceOf(NotCorrectSizeOfLotto.class);
	}

	// LottoNumber를 Set으로 담은 자료구조를 primitive 타입 int로 찾기 어려우므로 LottoNumber로 래핑
	private List<LottoNumber> convertToLottoNumbers(List<Integer> numbers){
		return numbers.stream().map(number -> new LottoNumber(number)).collect(Collectors.toList());
	}


}
