package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.Method;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoGeneratorTest {

	private Method privateMethod(String methodName) throws Exception {
		Method method = LottoGenerator.class.getDeclaredMethod(methodName, String.class);
		method.setAccessible(true);
		return method;
	}

	@ParameterizedTest(name = "index {index} ==> inputMoney {0}, lottoAmount {1}")
	@CsvSource(value = {"10000:10", "1111:1", "20000:20", "13200:13"}, delimiter = ':')
	void 입력된_구입금액만큼_로또갯수를_구해주는_기능테스트(String inputMoney, int lottoAmount) throws Exception {
		// given // when
		Method method = privateMethod("calculateLottoAmount");
		int resultAmount = (int)method.invoke(new LottoGenerator(inputMoney), inputMoney);

		// then
		assertThat(lottoAmount).isEqualTo(resultAmount);
	}
}