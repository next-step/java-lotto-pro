package lotto;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import exception.BusinessException;
import exception.ErrorMessages;

class ManualCountTest {

	@Test
	@DisplayName("수동로또 갯수 3입력 성공")
	public void manualCountSuccess() {
		String input = "3";
		ManualCount manualCount = new ManualCount(input);
		assertThat(manualCount).isEqualTo(new ManualCount("3"));
	}

	@DisplayName("한글, 영어, 특수문자 입력시 BusinessException")
	@ParameterizedTest
	@ValueSource(strings = {"한글", "english", "-"})
	public void manualCountMultipleCases(String input) {

		//when
		ThrowableAssert.ThrowingCallable throwingCallable = () -> new ManualCount(input);

		//then
		assertThatExceptionOfType(BusinessException.class)
			.isThrownBy(throwingCallable)
			.withMessage(ErrorMessages.INPUT_NUMBER_FORMAT_NOT_VALID.getValues());
	}

	@Test
	@DisplayName("음수_입력_실패")
	public void negativeFail() {
		//given when
		ThrowableAssert.ThrowingCallable throwingCallable = () -> new ManualCount("-1");

		//then
		assertThatExceptionOfType(BusinessException.class)
			.isThrownBy(throwingCallable)
			.withMessage(ErrorMessages.POSITIVE_NUMBER_FORMAT_NOT_VALID.getValues());
	}

}