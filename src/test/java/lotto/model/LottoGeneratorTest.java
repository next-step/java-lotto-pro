package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import lotto.code.ErrorCode;
import lotto.exception.LottoException;

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
		Method method = privateMethod("generateInputLottoNumbers");
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

	@Test
	void 입력된_금액과_수동번호갯수가_다를떄_예외처리_기능테스트() {
		// given
		Money inputMoney = Money.from("1000");
		List<String> inputList = Arrays.asList("12,3,4,5,6,7", "1,2,3,4,5,6", "1,2,3,4,5,6");

		// when // then
		assertThatThrownBy(() -> {
			LottoGenerator.of(inputMoney, inputList);
		}).isInstanceOf(LottoException.class)
			.hasMessageContaining(ErrorCode.INVALID_MONEY_INPUT_NUMBER_SIZE_ERROR.getErrorMessage());
	}

	@Test
	void 입력된_금액과_입력된_수동번호_갯수가_다를떄_예외처리_기능테스트() {
		// given
		Money inputMoney = Money.from("1000");
		List<String> inputList = Arrays.asList("12,3,4,5,6,7", "1,2,3,4,5,6", "1,2,3,4,5,6");
		String inputSize = "3";

		// when // then
		assertThatThrownBy(() -> {
			LottoGenerator.of(inputMoney, inputList, inputSize);
		}).isInstanceOf(LottoException.class)
			.hasMessageContaining(ErrorCode.INVALID_MONEY_INPUT_NUMBER_SIZE_ERROR.getErrorMessage());
	}

	@Test
	void 입력된_수동입력_갯수와_입력된_수동번호_리스트_갯수가_다를떄_예외처리_기능테스트() {
		// given
		Money inputMoney = Money.from("5000");
		List<String> inputList = Arrays.asList("12,3,4,5,6,7", "1,2,3,4,5,6", "1,2,3,4,5,6");
		String inputSize = "5";

		// when // then
		assertThatThrownBy(() -> {
			LottoGenerator.of(inputMoney, inputList, inputSize);
		}).isInstanceOf(LottoException.class)
			.hasMessageContaining(ErrorCode.INVALID_INPUT_SIZE_INPUT_LIST_SIZE_ERROR.getErrorMessage());
	}

}