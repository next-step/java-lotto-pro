package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
	@Test
	@DisplayName("\"1,2\"�� ,�� split ���� ��, 1�� 2�� �и� �׽�Ʈ")
	void split() {
		String[] result = "1,2".split(",");
		assertThat(result).containsExactly("1","2");
	}
	
	@Test
	@DisplayName("\"1\"�� ,�� split ���� ��, 1�� �����ϴ� �迭 ��ȯ �׽�Ʈ")
	void splitOne() {
		String[] result = "1".split(",");
		assertThat(result).containsExactly("1");
	}
	
	@Test
	@DisplayName("\"(1,2)\"�� substring() Ȱ���Ͽ� ()�� �����ϰ�, \"1,2\" ��ȯ �׽�Ʈ")
	void removeBracket() {
		String result = "(1,2)".substring(1,4);
		assertThat(result).isEqualTo("1,2");
	}
	
	@Test
	@DisplayName("\"a,b,c\"��  charAt() Ȱ���Ͽ� Ư�� ��ġ�� ���� ��ȯ �׽�Ʈ")
	void searchCharAt() {
		assertThat("abc".charAt(0)).isEqualTo('a');
		assertThat("abc".charAt(1)).isEqualTo('b');
		assertThat("abc".charAt(2)).isEqualTo('c');
	}
	
	@Test
	@DisplayName("\"a,b,c\"��  charAt() Ȱ�� ��, ��ġ �� ����� StringIndexOutOfBoundsException �߻� �׽�Ʈ")
	void wrongLocation() {
		assertThatExceptionOfType(IndexOutOfBoundsException.class)
		.isThrownBy(() -> {
			"abc".charAt(100);
		}).withMessageMatching("String index out of range: \\d+");
	}

}
