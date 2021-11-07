package lotto.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningLottoNumbersTest {

	@ParameterizedTest(name = "index {0} ===> input {1}")
	@CsvSource(value = {
		"1, 2,3, 4,5,6 : 7",
		"1 ,6, 12, 34, 33, 23 : 8",
		"1,10,11,12,13,41 : 9"
	}, delimiter = ':')
	void 입력된_문자열로_당첨번호_생성테스트(String input, String bonusInput) {
		// given // when
		WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(input, bonusInput);

		// then
		assertAll(
			() -> assertThat(winningLottoNumbers.size()).isEqualTo(6),
			() -> assertThat(winningLottoNumbers.containsLottoNumber(new LottoNumber(1))).isTrue()
		);
	}

	@ParameterizedTest(name = "index {index} ===> inputNumber {0}, lottoNumber {1}, resultCount {2}")
	@CsvSource(value = {
		"1,2,3,4,5,6 : 5 : 1",
		"1,2,3,4,5,6 : 8 : 0"
	}, delimiter = ':')
	void 로또번호와_당첨번호를_비교하여_값이_존재하는지_판단하는_테스트(String inputNumber, int lottoNumber, int resultCount) {
		//given
		WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(inputNumber);

		//when
		int containsCount = winningLottoNumbers.containsCountLottoNumber(new LottoNumber(lottoNumber));

		//then
		assertThat(resultCount).isEqualTo(containsCount);
	}
}