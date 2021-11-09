package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

	private Method privateMethod(String methodName) throws Exception {
		Method method = LottoGenerator.class.getDeclaredMethod(methodName);
		method.setAccessible(true);
		return method;
	}

	@Test
	void 자동로또만_생성하는_기능테스트() throws Exception {
		// given
		Money inputMoney = Money.from("10000");

		// when
		Method method = privateMethod("generateRandomLottoNumbers");
		List<LottoNumbers> lottoNumbersList = (List<LottoNumbers>)method.invoke(LottoGenerator.from(inputMoney));

		// then
		assertThat(lottoNumbersList).hasSize(inputMoney.calculateLottoAmount());
	}

	@Test
	void 수동로또만_생성하는_기능테스트() throws Exception {
		// given
		Money inputMoney = Money.from("3000");
		List<String> inputNumberList = Arrays.asList("12,3,4,5,6,7", "12,3,4,5,6,7", "12,3,4,5,6,7");

		// when
		Method method = privateMethod("generateLottoInputNumbers");
		List<LottoNumbers> lottoNumbersList = (List<LottoNumbers>)method.invoke(
			LottoGenerator.of(inputMoney, inputNumberList));

		// then
		assertThat(lottoNumbersList).hasSize(inputMoney.calculateLottoAmount());
	}

	@Test
	void 수동로또_갯수로_자동로또_갯수를_구하는_기능테스트() throws Exception {
		// given
		Money inputMoney = Money.from("10000");
		List<String> inputNumberList = Arrays.asList("12,3,4,5,6,7", "12,3,4,5,6,7", "12,3,4,5,6,7");

		// when
		Method method = privateMethod("calculateRandomSize");
		int randomSize = (int)method.invoke(LottoGenerator.of(inputMoney, inputNumberList));

		// then
		assertThat(randomSize).isEqualTo(inputMoney.calculateLottoAmount() - inputNumberList.size());
	}

	@Test
	void 수동_자동로또_생성하는_기능테스트() {
		// given
		Money inputMoney = Money.from("10000");
		List<String> inputNumberList = Arrays.asList("12,3,4,5,6,7", "12,3,4,5,6,7", "12,3,4,5,6,7");

		// when
		List<LottoNumbers> lottoNumbersList = LottoGenerator.of(inputMoney, inputNumberList).generateLottoNumbers();

		// then
		assertThat(lottoNumbersList).hasSize(inputMoney.calculateLottoAmount());
	}
}