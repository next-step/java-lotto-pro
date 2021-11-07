package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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
			method.invoke(new Money(inputMoney), inputMoney);
		}).isInstanceOf(LottoException.class);
	}

	@ParameterizedTest(name = "index {0} ===> inputMoney {1}")
	@ValueSource(strings = {"0", "999", "-1"})
	void 구입금액_1000원이상_아닐시_예외처리_테스트(String inputMoney) throws Exception {
		// given // when
		Method method = privateMethod("validUnderLottoPrice");

		// then
		assertThatThrownBy(() -> {
			method.invoke(new Money(inputMoney), inputMoney);
		}).isInstanceOf(LottoException.class);
	}

	@Test
	void 구입금액이_숫자가아닐때_예외처리_테스트() throws Exception {
		// given // when
		String inputMoney = "2we,";
		Method method = privateMethod("validNumber");

		// then
		assertThatThrownBy(() -> {
			method.invoke(new Money(inputMoney), inputMoney);
		}).isInstanceOf(LottoException.class);
	}
}