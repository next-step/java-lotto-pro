import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoPaymentTest {

	@ParameterizedTest
	@CsvSource(value = {"3000:3:true", "1234:1:true", "1000:2:false"}, delimiter = ':')
	void canBuy(String paidKRW, int numOfLottos, boolean canBuy) {
		final LottoPayment payment = LottoPayment.from(paidKRW);
		assertThat(payment.canBuy(numOfLottos)).isEqualTo(canBuy);
	}

	@ParameterizedTest
	@ValueSource(strings = {"NaN", "-1", "0", "500"})
	void from_String_invalid(String pay) {
		assertThatExceptionOfType(LottoPaymentFormatException.class)
			.isThrownBy(() -> LottoPayment.from(pay))
			.withMessage(LottoPaymentFormatException.ERROR_MESSAGE);
	}
}
