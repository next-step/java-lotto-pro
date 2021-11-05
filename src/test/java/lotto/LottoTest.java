package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoTest {

	@ParameterizedTest
	@CsvSource(value = {"1:1", "13:1", "26:1", "31:0", "44:0", "4:0"}, delimiter = ':')
	@DisplayName("번호 1개 일치여부 확인 기능 테스트")
	public void LottoNumberMatchTest(int inputData, int expectedValue) {
		//given
		int[] numbers = {1, 13, 26, 38, 41, 8};
		LottoNumbers lottoNumbers = new LottoNumbers(numbers);

		//when
		int result = lottoNumbers.isMatch(inputData);

		//then
		assertThat(result).isEqualTo(expectedValue);
	}

	@ParameterizedTest
	@CsvSource(value = {"1,13,26,38,41,8:6", "2,13,25,38,42,8:3", "3,15,22,31,33,4:0"}, delimiter = ':')
	@DisplayName("일치하는 로또번호 개수 확인 테스트")
	public void LottoNumbersMatchTest(String inputData, int expectedValue) {
		//given
		int[] winningNumbers = Arrays.stream(inputData.split(",")).mapToInt(Integer::parseInt).toArray();
		int[] lottoNumbers = {1, 13, 26, 38, 41, 8};
		Lotto lotto = new Lotto(lottoNumbers);

		//when
		int count = lotto.countMatchNumber(winningNumbers);

		//then
		assertThat(count).isEqualTo(expectedValue);
	}
}
