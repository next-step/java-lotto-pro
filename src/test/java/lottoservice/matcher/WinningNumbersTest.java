package lottoservice.matcher;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lottoservice.exception.InvalidLottoFormatException;
import lottoservice.lottonumber.LottoArrangeManipulator;
import lottoservice.lottonumber.LottoNumber;
import lottoservice.lottonumber.LottoNumbersMaker;

public class WinningNumbersTest {

	private static int SIZE_OF_LOTTERY_NUMBERS = 6;

	LottoNumbersMaker lottoNumbersMaker = new LottoNumbersMaker(new LottoArrangeManipulator());

	@Test
	public void makeLottoWinningNumbers_당첨번호_생성() {
		List<LottoNumber> lottoNumbers = lottoNumbersMaker.makeLottoNumbers(Arrays.asList(3, 34, 22, 17, 26, 7));
		WinningNumbers winningNumbers = new WinningNumbers(lottoNumbers);

		assertThat(winningNumbers.sizeOfWinningNumbers()).isEqualTo(lottoNumbers.size());

		lottoNumbers.stream().forEach(it -> assertThat(winningNumbers.hasMatchNumber(it)).isTrue());
	}

	@Test
	public void validateLottoNumberGroupRule_당첨번호_리스트_중복숫자_입력_예외() {
		List<LottoNumber> lottoNumbers = lottoNumbersMaker.makeLottoNumbers(Arrays.asList(3, 34, 22, 17, 3, 7));

		assertThatThrownBy(() -> {
			WinningNumbers winningNumbers = new WinningNumbers(lottoNumbers);
		}).isInstanceOf(InvalidLottoFormatException.class);
	}

	@Test
	public void validateLottoNumberGroupRule_당첨번호_리스트_갯수가_작은경우_예외() {
		List<LottoNumber> lottoNumbers = lottoNumbersMaker.makeLottoNumbers(Arrays.asList(1, 22, 17, 3, 7));

		assertThatThrownBy(() -> {
			WinningNumbers winningNumbers = new WinningNumbers(lottoNumbers);
		}).isInstanceOf(InvalidLottoFormatException.class);
	}

	@Test
	public void validateLottoNumberGroupRule_당첨번호_리스트_갯수가_큰_경우_예외() {
		List<LottoNumber> lottoNumbers = lottoNumbersMaker.makeLottoNumbers(Arrays.asList(1, 22, 17, 3, 7, 30, 45));

		assertThatThrownBy(() -> {
			WinningNumbers winningNumbers = new WinningNumbers(lottoNumbers);
		}).isInstanceOf(InvalidLottoFormatException.class);
	}

	@ParameterizedTest
	@ValueSource(strings = {"1, 31, 22, 15, 4, 7", "2, 43, 33, 25, 6, 7"})
	public void makeLottoWinningNumbers_당첨번호_문자열_입력(String lottoNumberText) {
		List<LottoNumber> lottoNumbers = lottoNumbersMaker.makeLottoNumbers(lottoNumberText);
		WinningNumbers winningNumbers = new WinningNumbers(lottoNumbers);

		assertThat(winningNumbers.sizeOfWinningNumbers()).isEqualTo(lottoNumbers.size());

		lottoNumbers.stream().forEach(it -> assertThat(winningNumbers.hasMatchNumber(it)).isTrue());
	}

	@ParameterizedTest
	@ValueSource(strings = {"1, 31, 22, 15, 4, 7, 5", "2, 43, 33, 25, 6"})
	public void makeLottoWinningNumbers_당첨번호_문자열_입력_로또갯수_예외(String lottoNumberText) {
		assertThatThrownBy(() -> {
			WinningNumbers winningNumbers = new WinningNumbers(
				lottoNumbersMaker.makeLottoNumbers(lottoNumberText));
		}).isInstanceOf(InvalidLottoFormatException.class);
	}

	@ParameterizedTest
	@ValueSource(strings = {"1,31,22,15,4,7", " 2, 43, 33, 25, 6, 10", "2, 43, 33, 25, 6, 10 ", "2 43 33 25 6 10"})
	public void makeLottoWinningNumbers_당첨번호_문자열_입력_포맷_예외(String lottoNumberText) {
		assertThatThrownBy(() -> {
			WinningNumbers winningNumbers = new WinningNumbers(
				lottoNumbersMaker.makeLottoNumbers(lottoNumberText));
		}).isInstanceOf(InvalidLottoFormatException.class);
	}
}