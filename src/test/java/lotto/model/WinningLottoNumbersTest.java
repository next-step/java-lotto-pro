package lotto.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningLottoNumbersTest {

	private Method privateMethod(String methodName) throws Exception {
		Method method = WinningLottoNumbers.class.getDeclaredMethod(methodName, String.class);
		method.setAccessible(true);
		return method;
	}

	@ParameterizedTest(name = "index {0} ===> input {1}")
	@ValueSource(strings = {
		"1, 2, 3, 4, 5, 6, 7",
		"1, 2, 3, 4,",
		""
	})
	void 입력된_당첨번호가_6자리가_아닐때_예외처리_테스트(String input) throws Exception {
		// given // when
		Method method = privateMethod("isNotLottoNumberSize");

		// then
		assertThatThrownBy(() -> {
			method.invoke(new WinningLottoNumbers(), input);
		}).isInstanceOf(InvocationTargetException.class);
	}

	@Test
	void 입력된_당첨번호에_중복값이_존재할시_예외처리_테스트() throws Exception {
		// given
		String input = "1, 1, 2, 3, 4, 5";

		// when
		Method method = privateMethod("isDuplicateLottoNumber");

		// then
		assertThatThrownBy(() -> {
			method.invoke(new WinningLottoNumbers(), input);
		}).isInstanceOf(InvocationTargetException.class);
	}

	@Test
	void 입력된_당첨번호를_로또번호_일급_콜렉션으로_만드는_기능테스트() throws Exception {
		// given
		String input = "1, 2, 3, 4, 5, 6";
		LottoNumbers lottoNumbers = new LottoNumbers(input);

		// when
		Method method = privateMethod("generateWinningLottoNumbers");
		LottoNumbers winningLottoNumbers = (LottoNumbers)method.invoke(new WinningLottoNumbers(), input);

		// then
		assertAll(
			() -> assertThat(winningLottoNumbers).isNotNull(),
			() -> assertThat(winningLottoNumbers.size()).isEqualTo(LottoNumbers.LOTTO_NUMBERS_SIZE),
			() -> assertThat(lottoNumbers.equals(winningLottoNumbers)).isTrue()
		);
	}

	@ParameterizedTest(name = "index {0} ===> input {1}")
	@ValueSource(strings = {
		"1, 2,3, 4,5,6",
		"1 ,6, 12, 34, 33, 23",
		"1,10,11,12,13,41"
	})
	void 입력된_문자열로_당첨번호_생성테스트(String input) {
		// given // when
		WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(input);

		// then
		assertAll(
			() -> assertThat(winningLottoNumbers.size()).isEqualTo(6),
			() -> assertThat(winningLottoNumbers.containsLottoNumber(new LottoNumber(1))).isTrue()
		);
	}
}