package lotto.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.exception.LottoException;

class LottoNumbersTest {

	private List<LottoNumber> lottoNumberList;

	@BeforeEach
	void setup() {
		lottoNumberList = new ArrayList<>();
	}

	@AfterEach
	void tearDown() {
		lottoNumberList = null;
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4, 5, 6})
	void 로또넘버_일급_콜렉션_생성_테스트(int lottoNumber) {
		// given
		for (int i = 1; i <= LottoNumbers.LOTTO_NUMBERS_SIZE; i++) {
			lottoNumberList.add(new LottoNumber(i));
		}

		// when
		LottoNumbers lottoNumbers = new LottoNumbers(lottoNumberList);

		// then
		assertAll(
			() -> assertThat(lottoNumbers).isInstanceOf(LottoNumbers.class),
			() -> assertThat(lottoNumbers.containsLottoNumber(new LottoNumber(lottoNumber)))
		);
	}

	@Test
	void 로또번호_일급_콜렉션_랜덤_생성_테스트() {
		// given // when
		LottoNumbers lottoNumbers = new LottoNumbers();

		// then
		assertThat(lottoNumbers.size()).isEqualTo(LottoNumbers.LOTTO_NUMBERS_SIZE);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4, 5, 6})
	void 로또번호_입력값으로_일급_콜렉션_생성_테스트(int lottoNumber) {
		//given
		String inputNumber = "1,2,3,4,5,6";

		//when
		LottoNumbers lottoNumbers = new LottoNumbers(inputNumber);

		//then
		assertThat(lottoNumbers.containsLottoNumber(new LottoNumber(lottoNumber))).isTrue();
	}

	@ParameterizedTest(name = "index {index} ===> input {0}")
	@ValueSource(strings = {
		"1, 2, 3, 4, 5, 6, 7",
		"1, 2, 3, 4,",
		""
	})
	void 입력된_당첨번호가_6자리가_아닐때_예외처리_테스트(String input) {
		// given // when // then
		assertThatThrownBy(() -> {
			new LottoNumbers(input);
		}).isInstanceOf(LottoException.class);
	}

	@Test
	void 입력된_당첨번호에_중복값이_존재할시_예외처리_테스트() throws Exception {
		// given
		String input = "1, 1, 2, 3, 4, 5";

		// when // then
		assertThatThrownBy(() -> {
			new LottoNumbers(input);
		}).isInstanceOf(LottoException.class);
	}
}