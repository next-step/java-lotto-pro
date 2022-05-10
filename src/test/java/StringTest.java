import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
	@Test
	@DisplayName("1,2을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인")
	public void test_split_contains_1_or_2() {
		String[] underTest = "1,2".split(",");

		assertThat(underTest).contains("1", "2");
	}

	@Test
	@DisplayName("1을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인")
	public void test_split_contains_exactly_1() {
		String[] underTest = "1".split(",");

		assertThat(underTest).containsExactly("1");
	}

}
