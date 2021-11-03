package lotto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.common.Messages;

class BonusBallTest {

	@Test
	@DisplayName("7 입력한 경우 BonusBall 생성")
	public void bonusBall_7_생성() {
	    String input = "7";
		BonusBall bonusBall = new BonusBall(input);
		assertThat(bonusBall.getBonusBall().getNumber()).isEqualTo(7);
	}

	@Test
	@DisplayName("-1 입력한 경우 양의숫자만 입력가능하다는 메세지와 IllegalArgumentException")
	public void bonusBall_음수_실패() {
		String input = "-1";
		//when
		ThrowableAssert.ThrowingCallable throwingCallable = () -> new BonusBall(input);

		//then
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(throwingCallable)
			.withMessage(Messages.POSITIVE_NUMBER_FORMAT_NOT_VALID.getValues());
	}

	@Test
	@DisplayName("48 입력한 경우 1~45까지의 숫자만 입력가능하다는 메세지와 IllegalArgumentException")
	public void bonusBall_로또범위_실패() {
		String input = "48";
		//when
		ThrowableAssert.ThrowingCallable throwingCallable = () -> new BonusBall(input);

		//then
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(throwingCallable)
			.withMessage(Messages.INPUT_NUMBER_RANGE_NOT_VALID.getValues());
	}

	@Test
	@DisplayName("일 입력한 경우  숫자만 입력가능하다는 메세지와 IllegalArgumentException")
	public void bonusBall_한글_실패() {
		String input = "일";
		//when
		ThrowableAssert.ThrowingCallable throwingCallable = () -> new BonusBall(input);

		//then
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(throwingCallable)
			.withMessage(Messages.INPUT_NUMBER_FORMAT_NOT_VALID.getValues());
	}

}