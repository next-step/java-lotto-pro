package lotto.model;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

	@Test
	@DisplayName("당첨번호에 보너스볼이 있는 경우 테스트")
	void winninglotto_contains_bonus() {
		assertThrows(IllegalArgumentException.class, () -> new WinningLotto(new LottoNumbers("1,2,3,4,5,6"), "6"));
	}
}
