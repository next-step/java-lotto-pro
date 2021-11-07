package step3;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumbersTest {

	@Test
	@DisplayName("로또 번호가 중복된 경우 6개만 뽑히는지 확인")
	void createLotto() {
		// given
		LottoNumber[] inputLottoNumber = {new LottoNumber(1),
			new LottoNumber(4),
			new LottoNumber(42),
			new LottoNumber(5),
			new LottoNumber(9),
			new LottoNumber(9),
			new LottoNumber(4)};

		//when
		LottoNumbers lottoNumbers = LottoNumbers.createLottoNumber(inputLottoNumber);

		//then
		Assertions.assertThat(lottoNumbers).isEqualTo(LottoNumbers.createLottoNumber(inputLottoNumber));
	}

	@Test
	@DisplayName("로또 번호가 6개 이상 뽑히면 Exception 발생")
	void createOverFlowThrow() {
		assertThatThrownBy(() -> {
			LottoNumbers lottoNumbers = LottoNumbers.createLottoNumber();
			lottoNumbers.createLottoNumbers();
		}).isInstanceOf(ArrayIndexOutOfBoundsException.class);
	}

}