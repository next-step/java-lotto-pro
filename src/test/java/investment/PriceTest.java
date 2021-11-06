package investment;

import static common.Constants.*;
import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import exception.BusinessException;
import exception.ErrorMessages;

class PriceTest {

	@Test
	@DisplayName("금액 입력 성공")
	public void priceSuccess() {
		String input = "3000";
		Price price = new Price(input);
		assertThat(price).isEqualTo(new Price("3000"));
	}

	@Test
	@DisplayName("한글입력한_경우_BusinessException")
	public void priceKoreanInputFail() {
		String input = "한글입력";
		//when
		ThrowableAssert.ThrowingCallable throwingCallable = () -> new Price(input);

		//then
		assertThatExceptionOfType(BusinessException.class)
			.isThrownBy(throwingCallable)
			.withMessage(ErrorMessages.INPUT_NUMBER_FORMAT_NOT_VALID.getValues());
	}

	@Test
	@DisplayName("금액이_1000이하_경우_BusinessException")
	public void priceMinFail() {
		String input = "900";
		//when
		ThrowableAssert.ThrowingCallable throwingCallable = () -> new Price(input);

		//then
		assertThatExceptionOfType(BusinessException.class)
			.isThrownBy(throwingCallable)
			.withMessage(ErrorMessages.INPUT_INVESTMENT_MIN_VALID.getValues());
	}

	@Test
	@DisplayName("금액이_1000단위가_아닌_경우_BusinessException")
	public void priceUnitFail() {
		String input = "12500";
		//when
		ThrowableAssert.ThrowingCallable throwingCallable = () -> new Price(input);

		//then
		assertThatExceptionOfType(BusinessException.class)
			.isThrownBy(throwingCallable)
			.withMessage(ErrorMessages.INPUT_INVESTMENT_UNIT_VALID.getValues());
	}

	@Test
	@DisplayName("금액_3000_입력한_경우_1000단위로_나눈_값_3_반환")
	public void priceFloorDivSuccess() {
		//given
		String input = "3000";
		Price price = new Price(input);
		assertThat(price).isEqualTo(new Price("3000"));
		assertThat(price.floorDiv(PER_PRICE)).isEqualTo(3);
	}

}