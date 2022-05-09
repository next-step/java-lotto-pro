package string;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
	@Test
	void split_1_2() {
		String[] actual = "1,2".split(",");
		assertThat(actual).contains("2", "1");
		assertThat(actual).containsExactly("1", "2");
	}

	@Test
	void split_1() {
		String[] actual = "1".split(",");
		assertThat(actual).contains("1");
		assertThat(actual).containsExactly("1");
	}

	@Test
	void substring() {
		String actual = "(1,2)".substring(1, 4);
		assertThat(actual).isEqualTo("1,2");
	}
}
