package lotto;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import exception.BusinessException;
import exception.ErrorMessages;

public class LottoTest {

	@Test
	@DisplayName("사용자입력 받아 로또 생성")
	public void lottoUserInput() {
		String input = "1,2,3,4,5,6";
		Lotto lotto = new Lotto(input);
		assertThat(lotto.size()).isEqualTo(6);
	}

	@ParameterizedTest
	@ValueSource(strings = {"1,2,3,한글", "1;2;3;4;5;6", "1,2,3,4,d,6,"})
	@DisplayName("사용자입력 한글, 특수문자, 영문자입력, 오류")
	public void lottoUserInputFail(String input) {
		//when
		ThrowableAssert.ThrowingCallable throwingCallable = () -> new Lotto(input);

		//then
		assertThatExceptionOfType(BusinessException.class)
			.isThrownBy(throwingCallable)
			.withMessage(ErrorMessages.INPUT_NUMBER_COMMA_FORMAT_NOT_VALID.getValues());
	}

	@Test
	@DisplayName("사용자입력_중복숫자_오류")
	public void lottoDuplicate() {
		String input = "1,2,3,3,3,3";
		//when
		ThrowableAssert.ThrowingCallable throwingCallable = () -> new Lotto(input);

		//then
		assertThatExceptionOfType(BusinessException.class)
			.isThrownBy(throwingCallable)
			.withMessage(ErrorMessages.INPUT_NUMBER_DUPLICATE.getValues());
	}

	@Test
	@DisplayName("사용자입력_7개입력_오류")
	public void lottoRangeFail() {
		String input = "1,2,3,4,5,6,7";
		//when
		ThrowableAssert.ThrowingCallable throwingCallable = () -> new Lotto(input);

		//then
		assertThatExceptionOfType(BusinessException.class)
			.isThrownBy(throwingCallable)
			.withMessage(ErrorMessages.INPUT_NUMBER_LENGTH_NOT_VALID.getValues());
	}

	@Test
	@DisplayName("두로또_비교_3개_숫자_당첨")
	public void lottoCompareSuccess() {
		Lotto manualLotto = new Lotto("1,2,3,4,5,6");
		Lotto winner = new Lotto("1,3,4,7,8,9");
		assertThat(winner.compareCount(manualLotto)).isEqualTo(3);
	}

	@ParameterizedTest
	@CsvSource(value = {"3:true", "8:false"}, delimiter = ':')
	@DisplayName("숫자_포함_성공_또는_실패")
	public void lottoContains(int number, boolean expected) {
		Lotto manualLotto = new Lotto("1,2,3,4,5,6");
		assertThat(manualLotto.contains(new LottoNumber(number))).isEqualTo(expected);
	}

}
