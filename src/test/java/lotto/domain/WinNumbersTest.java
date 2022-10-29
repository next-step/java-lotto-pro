package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class WinNumbersTest {

	@Test
	void 객체_생성() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		assertThat(new WinNumbers(numbers)).isEqualTo(new WinNumbers(numbers));
	}
}
