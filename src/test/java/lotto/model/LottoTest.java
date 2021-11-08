package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoTest {

	@Test
	@DisplayName("로또 생성 테스트(6자리 숫자)")
	void create() {
		Lotto lotto1 = new Lotto(new LottoNumbers(3,6,23,24,32,33));
		Lotto lotto2 = new Lotto(new LottoNumbers(3,6,23,24,32,33));
		assertThat(lotto1).isEqualTo(lotto2);
	}

}
