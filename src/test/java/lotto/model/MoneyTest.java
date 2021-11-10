package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.Method;
import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.exception.LottoException;

class MoneyTest {
	private Method privateMethod(String methodName) throws Exception {
		Method method = Money.class.getDeclaredMethod(methodName, String.class);
		method.setAccessible(true);
		return method;
	}

	@Test
	void 구입금액_빈값_예외처리_테스트() throws Exception {
		// given // when
		String inputMoney = "";
		Method method = privateMethod("validNullOrEmpty");

		// then
		assertThatThrownBy(() -> {
			method.invoke(Money.from(inputMoney), inputMoney);
		}).isInstanceOf(LottoException.class);
	}

	@ParameterizedTest(name = "index {0} ===> inputMoney {1}")
	@ValueSource(strings = {"0", "999", "-1"})
	void 구입금액_1000원이상_아닐시_예외처리_테스트(String inputMoney) throws Exception {
		// given // when
		Method method = privateMethod("validUnderLottoPrice");

		// then
		assertThatThrownBy(() -> {
			method.invoke(Money.from(inputMoney), inputMoney);
		}).isInstanceOf(LottoException.class);
	}

	@Test
	void 구입금액이_숫자가아닐때_예외처리_테스트() throws Exception {
		// given // when
		String inputMoney = "2we,";
		Method method = privateMethod("validNumber");

		// then
		assertThatThrownBy(() -> {
			method.invoke(Money.from(inputMoney), inputMoney);
		}).isInstanceOf(LottoException.class);
	}

	@ParameterizedTest(name = "index {index} ==> inputMoney {0}, resultAmount {1}")
	@CsvSource(value = {
		"10000 : 10", "5555 : 5", "2323 : 2", "30000 : 30"
	}, delimiter = ':')
	void 구입금액에_따른_로또_갯수구하는_기능테스트(String inputMoney, int resultAmount) {
		// given
		Money money = Money.from(inputMoney);

		// when
		int size = money.calculateLottoAmount();

		// then
		assertThat(resultAmount).isEqualTo(size);
	}

	@Test
	void 구입금액에_비례하여_수익률을_계산하는_기능테스트() {
		// given
		Money money = Money.from(10000);
		BigDecimal sum = new BigDecimal(5000);

		// when
		float yield = money.calculateYield(sum);

		// then
		assertThat(yield).isEqualTo(0.5f);
	}
}