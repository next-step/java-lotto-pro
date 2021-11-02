import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {
	private Set<Integer> input = new HashSet<>();

	@BeforeEach
	protected void setUp() {
		// given
		input.add(1);
		input.add(2);
		input.add(3);
	}

	@DisplayName("Set 크기 반환 테스트")
	@Test
	public void sizeTest() {
		// when
		int size = input.size();

		// then
		assertThat(size).isEqualTo(3);
	}

	@DisplayName("Set에 특정 값들이 존재하는 지 확인")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	public void containsTest(int number) {
		assertThat(input.contains(number)).isTrue();
	}
}
