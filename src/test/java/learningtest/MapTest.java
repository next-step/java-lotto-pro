package learningtest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class MapTest {

	Map<String, Integer> map;

	@Test
	void testComputeIfAbsent() {
		map = new HashMap<>();

		String testKey = "TEST";

		int value = map.computeIfAbsent(testKey, key -> 5);
		int actualValue = map.get(testKey);

		assertThat(actualValue).isEqualTo(value);
	}

}
