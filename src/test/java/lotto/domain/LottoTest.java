package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {
	@Test
	@DisplayName("로또 번호는 6개를 입력해야 한다.")
	void three_numbers_match() {
		assertThatThrownBy(()-> new Lotto(Arrays.asList(
				new Number(1), new Number(2),
				new Number(3), new Number(4)
			)))
			.isInstanceOf(IllegalArgumentException.class);
	}

}
