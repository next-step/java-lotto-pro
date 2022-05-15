package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {
	@Test
	@DisplayName("로또 번호는 6개를 입력해야 한다.")
	void three_numbers_match() {
		assertThatThrownBy(()-> new Lotto(Arrays.asList(1, 2, 3, 4)))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
