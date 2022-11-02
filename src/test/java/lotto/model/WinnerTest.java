package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WinnerTest {

	@Test
	void 보너스_번호가_승리번호_포함시_예외_발생() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new Winner(new ManualLotto(LottoNumber.of(1, 2, 3, 4, 5, 6)), LottoNumber.of(6)))
			.withMessage("보너스 번호는 승리 번호에 포함될 수 없다.");
	}

}
