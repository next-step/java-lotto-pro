package lotto.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoGeneratorTest {

	private Method privateMethod(String methodName) throws Exception {
		Method method = LottoGenerator.class.getDeclaredMethod(methodName, String.class);
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
			method.invoke(new LottoGenerator(), inputMoney);
		}).isInstanceOf(InvocationTargetException.class);
	}

	@ParameterizedTest(name = "index {0} ===> inputMoney {1}")
	@ValueSource(strings = {"0", "999", "-1"})
	void 구입금액_1000원이상_아닐시_예외처리_테스트(String inputMoney) throws Exception {
		// given // when
		Method method = privateMethod("validUnderLottoPrice");

		// then
		assertThatThrownBy(() -> {
			method.invoke(new LottoGenerator(), inputMoney);
		}).isInstanceOf(InvocationTargetException.class);
	}

	@ParameterizedTest(name = "index {0} ==> inputMoney {1}, lottoAmount {2}")
	@CsvSource(value = {"10000:10", "1111:1", "20000:20", "13200:13"}, delimiter = ':')
	void 입력된_구입금액만큼_로또갯수를_구해주는_기능테스트(String inputMoney, int lottoAmount) throws Exception {
		// given // when
		Method method = privateMethod("calculateLottoAmount");
		int resultAmount = (int)method.invoke(new LottoGenerator(), inputMoney);

		// then
		assertThat(lottoAmount).isEqualTo(resultAmount);
	}

	@ParameterizedTest(name = "index {0} ==> inputMoney {1}, lottoNumbersListSize {2}")
	@CsvSource(value = {"10000:10", "1111:1", "20000:20", "13200:13"}, delimiter = ':')
	void 입력된_구입금액만큼_로또를_생성하는_기능테스트(String inputMoney, int lottoNumbersListSize) throws Exception {
		// given // when
		Method method = privateMethod("generateLottoNumbers");
		List<LottoNumbers> lottoNumbersList = (List<LottoNumbers>)method.invoke(new LottoGenerator(), inputMoney);

		// then
		assertAll(
			() -> assertThat(lottoNumbersList).hasSize(lottoNumbersListSize),
			() -> assertThat(lottoNumbersList.get(0)).isInstanceOf(LottoNumbers.class),
			() -> assertThat(lottoNumbersList.get(0).lottoNumberList.get(0)).isInstanceOf(LottoNumber.class)
		);
	}

	@ParameterizedTest(name = "index {0} ==> inputMoney {1}, lottoNumbersListSize {2}")
	@CsvSource(value = {"10000:10", "1111:1", "20000:20", "13200:13"}, delimiter = ':')
	void 입력된_구입금액만큼_로또생성기로_로또를_생성하는_테스트(String inputMoney, int lottoNumbersListSize) {
		// given // when
		LottoGenerator lottoGenerator = new LottoGenerator(inputMoney);

		// then
		assertAll(
			() -> assertThat(lottoGenerator).isInstanceOf(LottoGenerator.class),
			() -> assertThat(lottoGenerator.size()).isEqualTo(lottoNumbersListSize)
		);
	}

	@ParameterizedTest(name = "index {0} ==> inputMoney {1}, inputNumber {2}, lottoNumbersListSize {3}")
	@CsvSource(value = {
		"10000:1,2,3,4,5,6:10",
		"1111:1,2,3,4,5,6:1",
		"20000:1,2,3,4,5,6:20",
		"13200:1,2,3,4,5,6:13"}, delimiter = ':')
	void 입력된_구입금액과_입력된숫자로_로또를_생성하는_테스트(String inputMoney, String inputNumber, int lottoNumbersListSize) {
		// given // when
		LottoGenerator lottoGenerator = new LottoGenerator(inputMoney, inputNumber);

		// then
		assertAll(
			() -> assertThat(lottoGenerator).isInstanceOf(LottoGenerator.class),
			() -> assertThat(lottoGenerator.size()).isEqualTo(lottoNumbersListSize),
			() -> assertThat(lottoGenerator.contains(new LottoNumbers("1,2,3,4,5,6")))
		);
	}
}