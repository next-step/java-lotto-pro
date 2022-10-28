package lotto.util;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RandomNumbersGeneratorTest {

	@Test
	void begin이_last보다_클경우_IllegalArguentException() {
		assertThatThrownBy(() -> RandomNumbersGenerator.generate(10, 1, 10))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void size가_0보다_작을경우_IllegalArguentException() {
		assertThatThrownBy(() -> RandomNumbersGenerator.generate(1, 10, -1))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void begin_last_범위_숫자_갯수가_size보다_작을경우_IllegalArguentException() {
		assertThatThrownBy(() -> RandomNumbersGenerator.generate(1, 5, 10))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 생성_성공() {
		assertThat(RandomNumbersGenerator.generate(1, 10, 10)).hasSize(10);
	}
}
