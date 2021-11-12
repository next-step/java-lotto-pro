package step3;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import step3.lotto.BonusBall;
import step3.lotto.exception.DuplicationOrLessThenSixException;
import step3.lotto.LottoNumbers;

class LottoNumbersTest {

	@Test
	@DisplayName("로또 번호가 중복된 경우 6개만 뽑히는지 확인")
	void createLotto() {
		// given
		Integer[] resultLottoNumbers = {1, 4, 4, 5, 9, 9, 6, 44};

		//when
		LottoNumbers createLottoNumbers = LottoNumbers.createLottoNumber(resultLottoNumbers);

		//then
		Assertions.assertThat(createLottoNumbers).isEqualTo(LottoNumbers.createLottoNumber(1,4,5,9,6,44));
	}

	@ParameterizedTest
	@CsvSource(value = {"1,2,2,3","1,24,24,5,6,7"},delimiter = ':')
	void 로또번호가_6개_이하이거나_중복된_숫자인경우예외(String lottoNumbers) {
		Assertions.assertThatThrownBy(() -> {
				LottoNumbers.from(lottoNumbers);
			}).isInstanceOf(DuplicationOrLessThenSixException.class)
			.hasMessage("중복된 숫자가 존재하거나 로또번호가 6개 미만입니다.");
	}

	@Test
	@DisplayName("로또 번호가 6개 이상 뽑히면 Exception 발생")
	void createOverFlowThrow() {
		// given
		Integer[] inputLottoNumbers = {1, 4, 42, 5, 9, 6, 45, 32};

		assertThatThrownBy(() -> {
			LottoNumbers.createLottoNumber(inputLottoNumbers);
		}).isInstanceOf(ArrayIndexOutOfBoundsException.class);
	}

	@Test
	void 당첨번호와_생성된_당첨번호의_수를_확인() {
		LottoNumbers lottoNumber = LottoNumbers.createLottoNumber(1, 2, 3, 4, 5, 6);
		LottoNumbers userLottNumber = LottoNumbers.createLottoNumber(1, 2, 42, 44, 23, 19);
		Integer matchCount = lottoNumber.matchCount(userLottNumber);
		assertThat(matchCount).isEqualTo(2);
	}

	@Test
	void 유저가_입력한_숫자에_보너스볼이_존재하는_확인 () {
		LottoNumbers userLottNumber = LottoNumbers.createLottoNumber(1, 2, 42, 44, 23, 19);
		Boolean bonusBall = userLottNumber.matchBonusBall(new BonusBall(42));
		assertThat(bonusBall).isTrue();
	}
}