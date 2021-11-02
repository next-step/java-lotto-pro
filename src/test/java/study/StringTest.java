package study;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * String 클래스에 대한 학습 테스트
 * @author Inmook,Jeong
 * @since 2021.11.01
 */
public class StringTest {

	@Test
	@DisplayName("요구사항 1-1 : 1,2을 ','로 split 했을 때 잘 분리되는지 확인")
	void splitOneCommaTwo() {
		String[] result = "1,2".split(",");
		assertThat(result).contains("1", "2");
		assertThat(result).containsExactly("1", "2");
	}

	@Test
	@DisplayName("요구사항 1-2 : 1을 ','로 split 했을 때 1만 포함하는 배열이 반환되는지 확인")
	void splitOneComma() {
		String[] result = "1".split(",");
		assertThat(result).containsExactly("1").hasSize(1);
	}

	@Test
	@DisplayName("요구사항 2 : (1,2) 값이 주어졌을 때 substring을 활용해 ()을 제거하고 1,2를 반환하도록 테스트 구현")
	void substring() {
		String result = "(1,2)".substring(1, 4);
		assertThat(result).isEqualTo("1,2");
	}

	@ParameterizedTest
	@CsvSource(value = {"0:a", "1:b", "2:c"}, delimiter = ':')
	@DisplayName("요구사항 3-1 : abc 값이 주어졌을 때 charAt을 활용해 특정 문자를 가져오는 테스트 구현")
	void charAt(int index, String expected) {
		String result = "abc";
		assertThat(String.valueOf(result.charAt(index))).isEqualTo(expected);
	}

	@Test
	@DisplayName("요구사항 3-2 : 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현")
	void charAtOutOfIndex() {
		String result = "abc";
		assertThatThrownBy(() -> {
			result.charAt(3);
		}).isInstanceOf(StringIndexOutOfBoundsException.class)
				.hasMessageContaining("Result size is " + result.length());
	}
}
