package lottoLegacy;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lottoLegacy.common.Messages;

class LottoNumberTest {

	@Test
	@DisplayName("3 입력하여 3 반환")
	public void lottoNumber_생성() {
		int input = 3;
		LottoNumber lottoNumber = new LottoNumber(input);
		assertThat(lottoNumber.getNumber()).isEqualTo(input);
	}

	@Test
	@DisplayName("-1 입력한 경우 양의숫자만 입력가능하다는 메세지와 IllegalArgumentException")
	public void lottoNumber_음수_실패() {
		int input = -1;
		//when
		ThrowableAssert.ThrowingCallable throwingCallable = () -> new LottoNumber(input);

		//then
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(throwingCallable)
			.withMessage(Messages.POSITIVE_NUMBER_FORMAT_NOT_VALID.getValues());
	}

	@Test
	@DisplayName("48 입력한 경우 1~45까지의 숫자만 입력가능하다는 메세지와 IllegalArgumentException")
	public void lottoNumber_로또범위_실패() {
		int input = 48;
		//when
		ThrowableAssert.ThrowingCallable throwingCallable = () -> new LottoNumber(input);

		//then
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(throwingCallable)
			.withMessage(Messages.INPUT_NUMBER_RANGE_NOT_VALID.getValues());
	}

}