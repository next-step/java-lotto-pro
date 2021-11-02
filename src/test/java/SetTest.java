import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
