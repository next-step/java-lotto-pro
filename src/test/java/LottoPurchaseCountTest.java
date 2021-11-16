import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import exception.OutOfRangeException;
import model.LottoPurchaseCount;

public class LottoPurchaseCountTest {
	@Test
	@DisplayName("0번을 제공하면 예외")
	void test_constructor() {
		assertThatThrownBy(() -> new LottoPurchaseCount(0))
			.isInstanceOf(OutOfRangeException.class)
			.hasMessage(LottoPurchaseCount.MESSAGE_COUNT_MUST_BE_LARGER_THAN_ZERO);
	}

	@Test
	void test_0이아니면_정상() {
		assertThat(new LottoPurchaseCount(1)).isEqualTo(new LottoPurchaseCount(1));
	}

	@Test
	@DisplayName("호출시 구매한 횟수 반환")
	void test_get1() {
		assertThat(new LottoPurchaseCount(1).get()).isEqualTo(1);
	}
}
