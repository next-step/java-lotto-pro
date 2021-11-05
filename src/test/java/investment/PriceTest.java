package investment;

import static common.Constants.*;
import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

import exception.BusinessException;
import exception.ErrorMessages;

class PriceTest {

	@Test
	public void 금액입력() {
		String input = "3000";
		Price price = new Price(input);
		assertThat(price).isEqualTo(new Price("3000"));
	}

	@Test
	public void 한글입력한_경우_BusinessException() {
		String input = "한글입력";
		//when
		ThrowableAssert.ThrowingCallable throwingCallable = () -> new Price(input);

		//then
		assertThatExceptionOfType(BusinessException.class)
			.isThrownBy(throwingCallable)
			.withMessage(ErrorMessages.INPUT_NUMBER_FORMAT_NOT_VALID.getValues());
	}

	@Test
	public void 금액이_1000이하_경우_BusinessException() {
		String input = "900";
		//when
		ThrowableAssert.ThrowingCallable throwingCallable = () -> new Price(input);

		//then
		assertThatExceptionOfType(BusinessException.class)
			.isThrownBy(throwingCallable)
			.withMessage(ErrorMessages.INPUT_INVESTMENT_MIN_VALID.getValues());
	}

	@Test
	public void 금액이_1000단위가_아닌_경우_BusinessException() {
		String input = "12500";
		//when
		ThrowableAssert.ThrowingCallable throwingCallable = () -> new Price(input);

		//then
		assertThatExceptionOfType(BusinessException.class)
			.isThrownBy(throwingCallable)
			.withMessage(ErrorMessages.INPUT_INVESTMENT_UNIT_VALID.getValues());
	}

	@Test
	public void 금액_3000_입력한_경우_1000단위로_나눈_값_3_반환() {
		//given
		String input = "3000";
		Price price = new Price(input);
		assertThat(price).isEqualTo(new Price("3000"));
		assertThat(price.floorDiv(PER_PRICE)).isEqualTo(3);
	}

}