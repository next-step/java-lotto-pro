package lotto.domain;

import static lotto.constant.LottoConstant.*;
import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lotto.generator.TestNumberGenerator;

class LottoTest {

	@DisplayName("1~45 사이의 서로 중복되지 않은 숫자 개로 로또 1장을 만들 수 있다.")
	@ParameterizedTest
	@CsvSource(value = {"1:2:3:4:5:6", "1:10:20:30:40:45", "40:41:42:43:44:45"}, delimiter = ':')
	void creatLotto(int n1, int n2, int n3, int n4, int n5, int n6) {
		// given
		LottoNumbers lottoNumbers = LottoNumbers.createBy(new TestNumberGenerator(Arrays.asList(n1, n2, n3, n4, n5, n6)));

		// when
		Lotto lotto = Lotto.of(lottoNumbers);

		// then
		assertThat(lotto.getNumberSize()).isEqualTo(VALID_LOTTO_NUMBER_COUNT);
	}

	@DisplayName("당첨번호를 확인하여 로또가 당첨됐는지 확인한다.")
	@ParameterizedTest
	@CsvSource(value = {
		"1:2:3:4:5:6:6",
		"1:2:3:4:5:45:5",
		"1:2:3:4:44:45:4",
		"1:2:3:43:44:45:3",
		"1:2:42:43:44:45:2",
		"1:41:42:43:44:45:1",
		"40:41:42:43:44:45:0"},
		delimiter = ':')
	void checkWinningNumbers(int n1, int n2, int n3, int n4, int n5, int n6, int winningNumberCountResult) {
		// given
		TestNumberGenerator numberGenerator = new TestNumberGenerator(Arrays.asList(1, 2, 3, 4, 5, 6));
		LottoNumbers lottoNumbers = LottoNumbers.createBy(new TestNumberGenerator(Arrays.asList(n1, n2, n3, n4, n5, n6)));

		LottoNumbers lastWinningNumbers = LottoNumbers.createBy(numberGenerator);
		Lotto lotto = Lotto.of(lottoNumbers);

		// when
		int winningNumberCount = lotto.countWinningNumbers(lastWinningNumbers);

		// then
		assertThat(winningNumberCount).isEqualTo(winningNumberCountResult);
	}
}