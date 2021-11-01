package study;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Test;

public class StringTest {
	@Test
	void splitUnitContains() {
		String[] result = "1,2".split(",");
		assertThat(result).contains("1","2");
	}

	@Test
	void splitUnitContainsExactly() {
		String[] result = "1,".split(",");
		assertThat(result).containsExactly("1");
	}

}
