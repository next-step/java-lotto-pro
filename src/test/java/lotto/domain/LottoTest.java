package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoTest {

	@ParameterizedTest
	@CsvSource(value = {"1:true", "13:true", "26:true", "31:false", "44:false", "4:false"}, delimiter = ':')
	@DisplayName("번호 1개 일치여부 확인 기능 테스트")
	public void LottoNumberMatchTest(int inputData, boolean expectedValue) {
		//given
		Lotto lotto = new Lotto(1, 13, 26, 38, 41, 8);

		//when
		boolean result = lotto.isMatch(new LottoNumber(inputData));

		// then
		assertThat(result).isEqualTo(expectedValue);
	}

	@ParameterizedTest
	@CsvSource(value = {"1, 13, 26, 38, 41, 8:6", "2, 13, 25, 38, 42, 8:3", "3, 15, 22, 31, 33, 4:0"}, delimiter = ':')
	@DisplayName("일치하는 로또번호 개수 확인 테스트")
	public void LottoNumbersMatchTest(String inputData, int expectedValue) {
		//given
		LottoNumbers lottoNumbers = new LottoNumbers(inputData);
		Lotto lotto = new Lotto(1, 13, 26, 38, 41, 8);

		//when
		long count = lotto.countMatchedNumber(new WinningLotto(inputData, 45));

		//then
		assertThat(count).isEqualTo(expectedValue);
	}

}
