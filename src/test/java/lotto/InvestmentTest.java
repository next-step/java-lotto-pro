package lotto;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.common.Messages;

class InvestmentTest {

	@Test
	@DisplayName("투자금액 3000원 입력한 경우 Investment 객체 생성하여 투자금 3000과 3개를 확인한다.")
	public void Investment_입력() {
	    //given
	    String input = "3000";
	    
	    //when
		Investment investment = new Investment(input);
	    
	    //then
		assertThat(investment.getInvestment()).isEqualTo(3000);
		assertThat(investment.getCount()).isEqualTo(3);
	}

	@Test
	@DisplayName("3000원 입력한 경우 숫자만 입력 가능하다는 메세지와 IllegalArgumentException 확인한다.")
	public void Investment_한글입력_실패() {
	    //given
		String input = "3000원";
		//when
		ThrowableAssert.ThrowingCallable throwingCallable = () -> new Investment(input);

		//then
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(throwingCallable)
			.withMessage(Messages.INPUT_NUMBER_FORMAT_NOT_VALID.getValues());
	}

	@Test
	@DisplayName("900 입력한 경우 1000원 이상 입력 가능하다는 메세지와 IllegalArgumentException 확인한다.")
	public void Investment_1000원이하입력_실패() {
		//given
		String input = "900";
		//when
		ThrowableAssert.ThrowingCallable throwingCallable = () -> new Investment(input);

		//then
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(throwingCallable)
			.withMessage(Messages.INPUT_INVESTMENT_MIN_VALID.getValues());
	}

	@Test
	@DisplayName("3100 입력한 경우 1000원단위만 입력 가능하다는 메세지와 IllegalArgumentException 확인한다.")
	public void Investment_100원단위입력_실패() {
		//given
		String input = "3100";
		//when
		ThrowableAssert.ThrowingCallable throwingCallable = () -> new Investment(input);

		//then
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(throwingCallable)
			.withMessage(Messages.INPUT_INVESTMENT_UNIT_VALID.getValues());
	}
}