package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
	@Test
	@DisplayName("\"1,2\"을 ,로 split 했을 때, 1과 2로 분리 테스트")
	void split() {
		String[] result = "1,2".split(",");
		assertThat(result).containsExactly("1","2");
	}
	
	@Test
	@DisplayName("\"1\"을 ,로 split 했을 때, 1만 포함하는 배열 반환 테스트")
	void splitOne() {
		String[] result = "1".split(",");
		assertThat(result).containsExactly("1");
	}
	
	@Test
	@DisplayName("\"(1,2)\"를 substring() 활용하여 ()을 제거하고, \"1,2\" 반환 테스트")
	void removeBracket() {
		String result = "(1,2)".substring(1,4);
		assertThat(result).isEqualTo("1,2");
	}
	
	@Test
	@DisplayName("\"a,b,c\"를  charAt() 활용하여 특정 위치의 문자 반환 테스트")
	void searchCharAt() {
		assertThat("abc".charAt(0)).isEqualTo('a');
		assertThat("abc".charAt(1)).isEqualTo('b');
		assertThat("abc".charAt(2)).isEqualTo('c');
	}
	
	@Test
	@DisplayName("\"a,b,c\"를  charAt() 활용 시, 위치 값 벗어나면 StringIndexOutOfBoundsException 발생 테스트")
	void wrongLocation() {
		assertThatExceptionOfType(IndexOutOfBoundsException.class)
		.isThrownBy(() -> {
			"abc".charAt(100);
		}).withMessageMatching("String index out of range: \\d+");
	}

}
