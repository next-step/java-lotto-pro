package lotto;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import exception.BusinessException;
import exception.ErrorMessages;

public class LottoTest {

	@Test
	public void 중복되지_않은_로또_번호_6_개_자동_생성() {
	    Lotto lotto = new Lotto();
	    assertThat(lotto.size()).isEqualTo(6);
		System.out.println(lotto);
	}
	
	@Test
	public void 사용자입력_받아_로또_생성() {
	    String input = "1,2,3,4,5,6";
		Lotto lotto = new Lotto(input);
		assertThat(lotto.size()).isEqualTo(6);
		System.out.println(lotto);
	}

	@ParameterizedTest
	@ValueSource(strings = {"1,2,3,한글", "1;2;3;4;5;6", "1,2,3,4,d,6,"})
	public void 사용자입력_한글_특수문자_영문자입력_오류(String input){
		//when
		ThrowableAssert.ThrowingCallable throwingCallable = () -> new Lotto(input);

		//then
		assertThatExceptionOfType(BusinessException.class)
			.isThrownBy(throwingCallable)
			.withMessage(ErrorMessages.INPUT_NUMBER_COMMA_FORMAT_NOT_VALID.getValues());
	}

	@Test
	public void 사용자입력_중복숫자_오류(){
		String input = "1,2,3,3,3,3";
		//when
		ThrowableAssert.ThrowingCallable throwingCallable = () -> new Lotto(input);

		//then
		assertThatExceptionOfType(BusinessException.class)
			.isThrownBy(throwingCallable)
			.withMessage(ErrorMessages.INPUT_NUMBER_DUPLICATE.getValues());
	}

	@Test
	public void 사용자입력_7개입력_오류(){
		String input = "1,2,3,4,5,6,7";
		//when
		ThrowableAssert.ThrowingCallable throwingCallable = () -> new Lotto(input);

		//then
		assertThatExceptionOfType(BusinessException.class)
			.isThrownBy(throwingCallable)
			.withMessage(ErrorMessages.INPUT_NUMBER_LENGTH_NOT_VALID.getValues());
	}

	@Test
	public void 두로또_비교_3개_숫자_당첨() {
		Lotto manualLotto = new Lotto("1,2,3,4,5,6");
		Lotto winner = new Lotto("1,3,4,7,8,9");
		assertThat(winner.compareCount(manualLotto)).isEqualTo(3);
	}

}
