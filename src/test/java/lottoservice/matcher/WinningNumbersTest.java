package lottoservice.matcher;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lottoservice.exception.InvalidLottoFormatException;
import lottoservice.lottonumber.LottoArrangeManipulator;
import lottoservice.lottonumber.LottoNumber;
import lottoservice.lottonumber.LottoNumbersMaker;
import lottoservice.testfactory.TestLottoDataFactory;

public class WinningNumbersTest {

	LottoNumbersMaker lottoNumbersMaker = new LottoNumbersMaker(new LottoArrangeManipulator());

	@DisplayName("당첨번호_생성")
	@Test
	public void makeLottoWinningNumbers() {
		List<LottoNumber> lottoNumbers = TestLottoDataFactory.getLottoNumbers(3, 34, 22, 17, 26, 7);
		WinningNumbers winningNumbers = new WinningNumbers(lottoNumbers);

		assertThat(winningNumbers.sizeOfWinningNumbers()).isEqualTo(lottoNumbers.size());

		lottoNumbers.stream().forEach(it -> assertThat(winningNumbers.hasMatchNumber(it)).isTrue());
	}

	@DisplayName("당첨번호_리스트_중복숫자_입력_예외")
	@Test
	public void validateLottoNumberGroupRule_duplicate() {
		assertThatThrownBy(() -> {
			WinningNumbers winningNumbers = new WinningNumbers(TestLottoDataFactory.getLottoNumbers(3, 34, 22, 17, 3, 7));
		}).isInstanceOf(InvalidLottoFormatException.class);
	}

	@DisplayName("당첨번호_리스트_갯수가_작은경우_예외")
	@Test
	public void validateLottoNumberGroupRule_smaller_size() {
		assertThatThrownBy(() -> {
			WinningNumbers winningNumbers = new WinningNumbers(TestLottoDataFactory.getLottoNumbers(1, 22, 17, 3, 7));
		}).isInstanceOf(InvalidLottoFormatException.class);
	}

	@DisplayName("당첨번호_리스트_갯수가_큰_경우_예외")
	@Test
	public void validateLottoNumberGroupRule_biggersize() {
		assertThatThrownBy(() -> {
			WinningNumbers winningNumbers = new WinningNumbers(TestLottoDataFactory.getLottoNumbers(1, 22, 17, 3, 7, 30, 45));
		}).isInstanceOf(InvalidLottoFormatException.class);
	}

	@DisplayName("당첨번호_문자열_입력")
	@ParameterizedTest
	@ValueSource(strings = {"1, 31, 22, 15, 4, 7", "2, 43, 33, 25, 6, 7"})
	public void makeLottoWinningNumbers_string(String lottoNumberText) {
		List<LottoNumber> lottoNumbers = lottoNumbersMaker.makeLottoNumbers(lottoNumberText);
		WinningNumbers winningNumbers = new WinningNumbers(lottoNumbers);

		assertThat(winningNumbers.sizeOfWinningNumbers()).isEqualTo(lottoNumbers.size());

		lottoNumbers.stream().forEach(it -> assertThat(winningNumbers.hasMatchNumber(it)).isTrue());
	}

	@DisplayName("당첨번호_문자열_입력_로또갯수_예외")
	@ParameterizedTest
	@ValueSource(strings = {"1, 31, 22, 15, 4, 7, 5", "2, 43, 33, 25, 6"})
	public void makeLottoWinningNumbers_size_exception(String lottoNumberText) {
		assertThatThrownBy(() -> {
			WinningNumbers winningNumbers = new WinningNumbers(
				lottoNumbersMaker.makeLottoNumbers(lottoNumberText));
		}).isInstanceOf(InvalidLottoFormatException.class);
	}

	@DisplayName("당첨번호_문자열_입력_포맷_예외")
	@ParameterizedTest
	@ValueSource(strings = {"1,31,22,15,4,7", " 2, 43, 33, 25, 6, 10", "2, 43, 33, 25, 6, 10 ", "2 43 33 25 6 10"})
	public void makeLottoWinningNumbers_format_exception(String lottoNumberText) {
		assertThatThrownBy(() -> {
			WinningNumbers winningNumbers = new WinningNumbers(
				lottoNumbersMaker.makeLottoNumbers(lottoNumberText));
		}).isInstanceOf(InvalidLottoFormatException.class);
	}
}