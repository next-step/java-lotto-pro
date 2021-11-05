package model;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또")
class WinnerLottoTest {

	@Test
	@DisplayName("객체화")
	void instance() {
		assertThatNoException()
			.isThrownBy(() -> WinnerLotto.from(lottoNumbers(1, 2, 3, 4, 5, 6), LottoNumber.from(10)));
	}

	@Test
	@DisplayName("숫자 없이 객체화하면 IllegalArgumentException")
	void instance_nullNumbers_thrownIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> WinnerLotto.from(null, LottoNumber.from(10)))
			.withMessage("'lottoNumbers' must not be null");
	}

	@Test
	@DisplayName("보너스 숫자 없이 객체화하면 IllegalArgumentException")
	void instance_nullBonusNumbers_thrownIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> WinnerLotto.from(lottoNumbers(1, 2, 3, 4), null))
			.withMessage("'bonusNumber' must not be null");
	}

	@Test
	@DisplayName("일반 숫자에 보너스 숫자가 포함한 상태로 객체화하면 IllegalArgumentException")
	void instance_duplicationNumbers_thrownIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> WinnerLotto.from(lottoNumbers(1, 2, 3, 4), LottoNumber.from(3)))
			.withMessageContaining("must not have bonusNumber");
	}

	private LottoNumbers lottoNumbers(int... numbers) {
		Set<LottoNumber> numbersSet = new HashSet<>();
		for (int number : numbers) {
			numbersSet.add(LottoNumber.from(number));
		}
		return LottoNumbers.from(numbersSet);
	}

}
