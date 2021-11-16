import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import exception.OutOfRangeException;
import model.LottoPurchaseCount;

public class LottoPurchaseCountTest {
	@Test
	void test_정상생성() {
		assertThat(new LottoPurchaseCount(1)).isEqualTo(new LottoPurchaseCount(1));
	}

	@Test
	void 더_작으면_true() {
		assertThat(new LottoPurchaseCount(1).isLessThan(2)).isTrue();
		assertThat(new LottoPurchaseCount(1).isLessThan(0)).isFalse();
	}

	@Test
	@DisplayName("호출시 구매한 횟수 반환")
	void test_get1() {
		assertThat(new LottoPurchaseCount(1).get()).isEqualTo(1);
	}
}
