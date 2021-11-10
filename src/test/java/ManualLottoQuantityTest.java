import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ManualLottoQuantityTest {

	@ParameterizedTest
	@ValueSource(ints = {0, 1})
	void from_int(int numOfLottos) {
		final LottoPayment payment = LottoPayment.from("1000");
		assertThat(ManualLottoQuantity.from(payment, numOfLottos).get()).isEqualTo(numOfLottos);
	}

	@Test
	void from_negative_int() {
		final LottoPayment payment = LottoPayment.from("1000");
		assertThatExceptionOfType(ManualLottoQuantityException.class)
			.isThrownBy(() -> ManualLottoQuantity.from(payment, -1))
			.withMessage(errorMessage(payment));
	}

	@ParameterizedTest
	@ValueSource(strings = {"0", "1"})
	void from_String(String numOfLottos) {
		final LottoPayment payment = LottoPayment.from("1000");
		assertThat(ManualLottoQuantity.from(payment, numOfLottos).get()).isEqualTo(Integer.parseInt(numOfLottos));
	}

	@ParameterizedTest
	@ValueSource(strings = {"NaN", "-1"})
	void from_String_invalid(String s) {
		final LottoPayment payment = LottoPayment.from("1000");
		assertThatExceptionOfType(ManualLottoQuantityException.class)
			.isThrownBy(() -> ManualLottoQuantity.from(payment, s))
			.withMessage(errorMessage(payment));
	}

	@Test
	void from_String_null() {
		final LottoPayment payment = LottoPayment.from("1000");
		assertThatExceptionOfType(ManualLottoQuantityException.class)
			.isThrownBy(() -> ManualLottoQuantity.from(payment, null))
			.withMessage(errorMessage(payment));
	}

	@Test
	void from_LottoPayment_null() {
		assertThatExceptionOfType(ManualLottoQuantityException.class)
			.isThrownBy(() -> ManualLottoQuantity.from(null, 1))
			.withMessage(ManualLottoQuantityException.ERROR_MESSAGE_NOT_FOUND_PAYMENT);
	}

	@Test
	void isBiggerThan() {
		final LottoPayment payment = LottoPayment.from("1000");
		final ManualLottoQuantity manualLottoQuantity = ManualLottoQuantity.from(payment, 1);
		assertThat(manualLottoQuantity.isBiggerThan(0)).isTrue();
		assertThat(manualLottoQuantity.isBiggerThan(2)).isFalse();
	}

	@Test
	void subtractFrom() {
		final LottoPayment payment = LottoPayment.from("1000");
		assertThat(ManualLottoQuantity.from(payment, 1).subtractFrom(10)).isEqualTo(9);
	}

	private String errorMessage(LottoPayment payment) {
		return String.format(ManualLottoQuantityException.ERROR_MESSAGE_FORMAT, payment.getNumOfLottosCanBuy());
	}
}
