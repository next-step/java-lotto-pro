import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoStoreTest {

	private final LottoStore lottoStore = new LottoStore();

	@ParameterizedTest
	@CsvSource(value = {"3000:3", "1234:1"}, delimiter = ':')
	public void sell(String paidKRW, int numOfLottos) {
		final List<Lotto> soldLottos = lottoStore.sell(paidKRW);
		assertThat(soldLottos.size()).isEqualTo(numOfLottos);
	}

	@ParameterizedTest
	@ValueSource(strings = {"-1", "0", "NaN"})
	public void sell_notEnoughKRW(String pay) {
		assertThatExceptionOfType(LottoStorePaymentException.class)
			.isThrownBy(() -> lottoStore.sell(pay))
			.withMessage(LottoStorePaymentException.ERROR_NOT_ENOUGH_KRW);
	}
}
