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
			.isThrownBy(() -> new LottoPurchaseCount("1000"));
	}

	@Test
	@DisplayName("호출시 구매한 횟수 반환")
	void test_get1() {
		assertThat(new LottoPurchaseCount("1000").get()).isEqualTo(1);
	}

	@Test
	@DisplayName("호출시 구매시 사용한 비용 반환")
	void test_getTotalPrice() {
		assertThat(new LottoPurchaseCount("2000").getTotalPrice()).isEqualTo(2000);
	}
}
