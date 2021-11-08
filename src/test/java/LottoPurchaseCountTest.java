import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.LottoPurchaseCount;

public class LottoPurchaseCountTest {
	@Test
	@DisplayName("숫자가 아닌 경우 예외 발생")
	void test_constructor1() {
		assertThatThrownBy(() -> new LottoPurchaseCount("a"))
			.isInstanceOf(NumberFormatException.class);
	}

	@Test
	@DisplayName("숫자인 경우 정상 동작")
	void test_constructor2() {
		assertThatNoException()
			.isThrownBy(() -> new LottoPurchaseCount("1"));

		assertThat(new LottoPurchaseCount("1").get()).isEqualTo(1);
	}
}
