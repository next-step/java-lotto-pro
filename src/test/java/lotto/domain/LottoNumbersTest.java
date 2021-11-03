package lotto.domain;

import static java.util.stream.Collectors.*;
import static lotto.constant.ErrorMessage.*;
import static lotto.constant.LottoConstant.*;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lotto.generator.TestNumberGenerator;
import lotto.utils.MessageBuilder;

class LottoNumbersTest {

	@DisplayName("로또 1개에 들어있는 숫자의 개수는 항상 6개 이다.")
	@ParameterizedTest
	@CsvSource(value = {"1:2:3:4:5:6", "1:10:20:30:40:45", "40:41:42:43:44:45"}, delimiter = ':')
	void createLottoNumbers1(int n1, int n2, int n3, int n4, int n5, int n6) {
		// given
		LottoNumbers lottoNumbers = LottoNumbers.createBy(new TestNumberGenerator(Arrays.asList(n1, n2, n3, n4, n5, n6)));

		// when
		int size = lottoNumbers.getSize();

		// then
		assertThat(size).isEqualTo(VALID_LOTTO_NUMBER_COUNT);
	}

	@DisplayName("로또 1개에 들어있는 숫자는 서로 중복되지 않는다.")
	@ParameterizedTest
	@CsvSource(value = {"1:2:3:4:5:6", "1:10:20:30:40:45", "40:41:42:43:44:45"}, delimiter = ':')
	void createLottoNumbers2(int n1, int n2, int n3, int n4, int n5, int n6) {
		// given
		LottoNumbers lottoNumbers = LottoNumbers.createBy(new TestNumberGenerator(Arrays.asList(n1, n2, n3, n4, n5, n6)));

		// when
		Set<LottoNumber> numbers = lottoNumbers.getValues()
											   .stream()
											   .collect(toSet());
		// then
		assertThat(numbers.size()).isEqualTo(VALID_LOTTO_NUMBER_COUNT);
	}

	@DisplayName("로또 1개에 들어있는 숫자가 서로 중복되면 예외가 발생한다.")
	@ParameterizedTest
	@CsvSource(value = {"1:1:1:1:1:1", "1:2:3:4:5:5", "45:45:45:45:45:45"}, delimiter = ':')
	void createLottoNumbers3(int n1, int n2, int n3, int n4, int n5, int n6) {
		// given
		List<Integer> numbers = Arrays.asList(n1, n2, n3, n4, n5, n6);

		// when & then
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> LottoNumbers.createBy(new TestNumberGenerator(numbers)))
			.withMessage(MessageBuilder.build(DUPLICATED_LOTTO_NUMBER, numbers));
	}
}