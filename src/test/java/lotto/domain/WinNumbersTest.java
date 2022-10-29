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

	@Test
	void 로또_일치_갯수_확인() {
		WinNumbers winNumbers = new WinNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
		assertThat(winNumbers.countMatches(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)))).isEqualTo(6);
		assertThat(winNumbers.countMatches(new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7)))).isEqualTo(5);
		assertThat(winNumbers.countMatches(new Lotto(Arrays.asList(3, 4, 5, 6, 7, 8)))).isEqualTo(4);
		assertThat(winNumbers.countMatches(new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9)))).isEqualTo(3);
		assertThat(winNumbers.countMatches(new Lotto(Arrays.asList(5, 6, 7, 8, 9, 10)))).isEqualTo(2);
		assertThat(winNumbers.countMatches(new Lotto(Arrays.asList(6, 7, 8, 9, 10, 11)))).isEqualTo(1);
		assertThat(winNumbers.countMatches(new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)))).isEqualTo(0);
	}
}
