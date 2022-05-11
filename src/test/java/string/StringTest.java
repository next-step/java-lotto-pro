package string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringTest {
	@DisplayName("1,2를 ,로 분리한다")
	@Test
	void split_1_2() {
		String[] actual = "1,2".split(",");
		assertThat(actual).contains("2", "1");
		assertThat(actual).containsExactly("1", "2");
	}

	@DisplayName("1을 ,로 분리한다")
	@Test
	void split_1() {
		String[] actual = "1".split(",");
		assertThat(actual).contains("1");
		assertThat(actual).containsExactly("1");
	}

	@DisplayName("(1,2)에서 ()를 제거하고 1,2를 반환한다")
	@Test
	void substring() {
		String actual = "(1,2)".substring(1, 4);
		assertThat(actual).isEqualTo("1,2");
	}

	@DisplayName("String의 charAt을 활용해 특정 위치의 문자를 가져온다")
	@Test
	void charAt() {
		String given = "abc";
		assertThat(given.charAt(0)).isEqualTo('a');
		assertThat(given.charAt(1)).isEqualTo('b');
		assertThat(given.charAt(2)).isEqualTo('c');
	}

	@DisplayName("String의 charAt 사용 시 문자의 위치값을 벗어나면 StringIndexOutOfBoundsException이 발생한다")
	@Test
	void charAt_exception() {
		String given = "abc";
		assertThatThrownBy(() -> given.charAt(-1))
				.isInstanceOf(StringIndexOutOfBoundsException.class);
		assertThatThrownBy(() -> given.charAt(3))
				.isInstanceOf(StringIndexOutOfBoundsException.class);
	}
}
