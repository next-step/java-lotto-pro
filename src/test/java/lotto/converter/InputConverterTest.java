package lotto.converter;

import static org.assertj.core.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.domain.LottoNumbers;
import lotto.exception.InvalidLottoNumberException;
import lotto.exception.InvalidUserInputException;

@DisplayName("사용자 입력값 테스트")
class InputConverterTest {

	@Test
	@DisplayName("입력된 문자열을 int 값으로 변환")
	void convertToIntTest() {
		assertThat(InputConverter.toInt("1")).isEqualTo(1);
	}

	@Test
	@DisplayName("숫자가 아닌 문자열 입력 시 InvalidUserInputException 발생")
	void throwInvalidUserInputExceptionTest() {
		assertThatThrownBy(() -> InputConverter.toInt("abc"))
			.isInstanceOf(InvalidUserInputException.class)
			.hasMessageContaining("숫자를 입력해주세요 :");
	}

	@ParameterizedTest
	@NullAndEmptySource
	@DisplayName("공백 입력 시 InvalidUserInputException 발생")
	void throwInvalidUserInputExceptionTest(String input) {
		assertThatThrownBy(() -> InputConverter.toInt(input))
			.isInstanceOf(InvalidUserInputException.class)
			.hasMessageContaining("입력값이 없습니다.");
	}

	@Test
	@DisplayName("당첨 번호 입력 시 LottoNumbers 반환")
	void convertToLottoNumbersTest() {
		assertThat(InputConverter.toLottoNumbers("1, 2, 3, 4, 5, 6"))
			.isInstanceOf(LottoNumbers.class)
			.isEqualTo(LottoNumbers.from(Set.of(1, 2, 3, 4, 5, 6)));
	}

	@Test
	@DisplayName("당첨 번호 입력 시 중복된 숫자가 있을 경우 InvalidLottoNumberException 발생")
	void duplicateInputLottoNumbersTest() {
		assertThatThrownBy(() -> InputConverter.toLottoNumbers("1, 2, 3, 4, 5, 5"))
			.isInstanceOf(InvalidLottoNumberException.class)
			.hasMessageContaining("로또 번호는 중복되지 않는 6개의 숫자여야 합니다");
	}

	@ParameterizedTest
	@ValueSource(strings = {"1, 2, 3, 4, 5, 6", " 1 , 2 , 3 , 4 , 5 , 6 "})
	@DisplayName("수동 로또 번호 입력 시 공백 제거")
	void removeWhiteSpaceTest(String input) {
		assertThat(InputConverter.toLottoNumbers(input))
			.isEqualTo(InputConverter.toLottoNumbers("1,2,3,4,5,6"));
	}
}