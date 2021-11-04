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
}