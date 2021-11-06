package lotto;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import exception.BusinessException;
import exception.ErrorMessages;

public class LottoNumberTest {
	@Test
	@DisplayName("3 입력하여 3 반환")
	public void LottoNumber생성() {
		int input = 3;
		LottoNumber lottoNumber = new LottoNumber(input);
		assertThat(lottoNumber).isEqualTo(new LottoNumber(3));
	}

	@Test
	@DisplayName("-1 입력한 경우 양의숫자만 입력가능하다는 메세지와 BusinessException")
	public void LottoNumber음수실패() {
		int input = -1;
		//when
		ThrowableAssert.ThrowingCallable throwingCallable = () -> new LottoNumber(input);

		//then
		assertThatExceptionOfType(BusinessException.class)
			.isThrownBy(throwingCallable)
			.withMessage(ErrorMessages.POSITIVE_NUMBER_FORMAT_NOT_VALID.getValues());
	}

	@Test
	@DisplayName("48 입력한 경우 1~45까지의 숫자만 입력가능하다는 메세지와 BusinessException")
	public void LottoNumber로또범위실패() {
		int input = 48;
		//when
		ThrowableAssert.ThrowingCallable throwingCallable = () -> new LottoNumber(input);

		//then
		assertThatExceptionOfType(BusinessException.class)
			.isThrownBy(throwingCallable)
			.withMessage(ErrorMessages.INPUT_LOTTO_RANGE_NOT_VALID.getValues());
	}
}
