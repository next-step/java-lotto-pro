package lotto;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.common.Messages;

class LottoInputTest {

	@Test
	@DisplayName("1,2,3,4,5,6 입력한 경우 [1,2,3,4,5,6] Integer 배열을 반환한다")
	public void 당첨번호_입력_성공() {
	    String input = "1,2,3,4,5,6";
	    LottoInput lottoInput = new LottoInput(input);
	    assertThat(lottoInput.getInput().size()).isEqualTo(6);
	    assertThat(lottoInput.getInput()).containsExactly(1,2,3,4,5,6);
	}

	@Test
	@DisplayName("1,2,ㅇ,3,4,5 입력한 경우 숫자와 ,만 입력 가능하다는 IllegalArgumentException 발생한다.")
	public void 당첨번호_한글입력_실패() {
	    //given
	    String input = "1,2,d,3,4,5";
	    
	    //when
		ThrowingCallable throwingCallable = () -> new LottoInput(input);
	    
	    //then
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(throwingCallable)
			.withMessage(Messages.INPUT_NUMBER_COMMA_FORMAT_NOT_VALID.getValues());
	}

	@Test
	@DisplayName("1,2,3,4,5 입력한 경우 6개 숫자 입력해야 한다는 IllegalArgumentException 발생한다.")
	public void 당첨번호_5개입력_실패() {
	    //given
	    String input = "1,2,3,4,5";
		//when
		ThrowingCallable throwingCallable = () -> new LottoInput(input);
		//then
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(throwingCallable)
			.withMessage(Messages.INPUT_NUMBER_LENGTH_NOT_VALID.getValues());

	}

	@Test
	@DisplayName("1,2,3,4,5,48 입력한 경우1~45까지의 숫자만 입력해야 한다는 IllegalArgumentException 발생한다.")
	public void 당첨번호_중_48입력_실패() {
		//given
		String input = "1,2,3,4,5,48";
		//when
		ThrowingCallable throwingCallable = () -> new LottoInput(input);
		//then
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(throwingCallable)
			.withMessage(Messages.INPUT_NUMBER_RANGE_NOT_VALID.getValues());

	}

	@Test
	@DisplayName("1,2,3,4,5,5 입력한 경우 중복입력은 불가하다는 IllegalArgumentException 발생한다.")
	public void 당첨번호_중복입력_실패() {
		//given
		String input = "1,2,3,4,5,5";
		//when
		ThrowingCallable throwingCallable = () -> new LottoInput(input);
		//then
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(throwingCallable)
			.withMessage(Messages.INPUT_NUMBER_DUPLICATE.getValues());

	}

}