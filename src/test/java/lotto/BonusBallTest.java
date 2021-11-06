package lotto;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import exception.BusinessException;
import exception.ErrorMessages;

public class BonusBallTest {

	@Test
	@DisplayName("7 입력한 경우 BonusBall 생성")
	public void BonusBall7생성() {
		String input = "7";
		BonusBall bonusBall = new BonusBall(input);
		assertThat(bonusBall).isEqualTo(new BonusBall("7"));
	}

	@Test
	@DisplayName("-1 입력한 경우 양의숫자만 입력가능하다는 메세지와 BusinessException")
	public void BonusBall음수실패() {
		String input = "-1";
		//when
		ThrowableAssert.ThrowingCallable throwingCallable = () -> new BonusBall(input);

		//then
		assertThatExceptionOfType(BusinessException.class)
			.isThrownBy(throwingCallable)
			.withMessage(ErrorMessages.POSITIVE_NUMBER_FORMAT_NOT_VALID.getValues());
	}

	@Test
	@DisplayName("48 입력한 경우 1~45까지의 숫자만 입력가능하다는 메세지와 BusinessException")
	public void BonusBall로또범위실패() {
		String input = "48";
		//when
		ThrowableAssert.ThrowingCallable throwingCallable = () -> new BonusBall(input);

		//then
		assertThatExceptionOfType(BusinessException.class)
			.isThrownBy(throwingCallable)
			.withMessage(ErrorMessages.INPUT_LOTTO_RANGE_NOT_VALID.getValues());
	}

	@Test
	@DisplayName("일 입력한 경우  숫자만 입력가능하다는 메세지와 BusinessException")
	public void BonusBall한글실패() {
		String input = "일";
		//when
		ThrowableAssert.ThrowingCallable throwingCallable = () -> new BonusBall(input);

		//then
		assertThatExceptionOfType(BusinessException.class)
			.isThrownBy(throwingCallable)
			.withMessage(ErrorMessages.INPUT_NUMBER_FORMAT_NOT_VALID.getValues());
	}

}
