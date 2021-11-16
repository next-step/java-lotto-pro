import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exception.OutOfRangeException;
import model.LottoPurchaseCount;

public class LottoPurchasePriceTest {
	@Test
	void test_1000원미만_예외() {
		assertThatThrownBy(() -> new LottoPurchasePrice(999))
			.isInstanceOf(OutOfRangeException.class)
			.hasMessage(LottoPurchasePrice.MESSAGE_PRICE_MUST_BE_LARGER_THAN_999);
	}
	
	@Test
	void test_1000원이상_정상() {
		assertThat(new LottoPurchasePrice(1000)).isEqualTo(new LottoPurchasePrice(1000));
	}

	@Test
	void test_LottoPurchaseCount_변환() {
		assertThat(new LottoPurchasePrice(1000).toPurchaseCount()).isEqualTo(new LottoPurchaseCount(1));
	}
}
