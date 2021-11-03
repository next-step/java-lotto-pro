import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoStoreTest {

	private final LottoStore lottoStore = new LottoStore();

	@Test
	public void sell() {
		final int numOfLottos = 3;
		final List<Lotto> soldLottos = lottoStore.sell(numOfLottos * Lotto.PRICE_KRW);
		assertThat(soldLottos.size()).isEqualTo(numOfLottos);
	}

	@Test
	public void sell_indivisible() {
		final int numOfLottos = 2;
		final int remainder = Lotto.PRICE_KRW / 2;
		final List<Lotto> soldLottos = lottoStore.sell(numOfLottos * Lotto.PRICE_KRW + remainder);
		assertThat(soldLottos.size()).isEqualTo(numOfLottos);
	}

	@ParameterizedTest
	@ValueSource(ints = {-1, 0})
	public void sell_notEnoughKRW(int paidKRW) {
		assertThatExceptionOfType(LottoStorePaymentException.class)
			.isThrownBy(() -> lottoStore.sell(paidKRW))
			.withMessage(LottoStorePaymentException.ERROR_NOT_ENOUGH_KRW);
	}
}
