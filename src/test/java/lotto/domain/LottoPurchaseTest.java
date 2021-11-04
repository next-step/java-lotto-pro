package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoPurchaseTest {

	@ParameterizedTest
	@CsvSource(delimiter = ',', value = {"5000, 5", "10000, 10"})
	@DisplayName("주어진 돈으로 살 수 있는 로또 갯수를 반환한다")
	public void purchaseTest(int money, int count) {
		int result = LottoPurchase.getLottoCount(money);
		assertThat(result).isEqualTo(count);
	}

}
