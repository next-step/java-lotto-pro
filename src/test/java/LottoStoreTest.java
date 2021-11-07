import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoStoreTest {

	private final LottoStore lottoStore = new LottoStore();
	private final List<String> EMPTY_MANUAL_LOTTOS = Collections.emptyList();

	@ParameterizedTest
	@CsvSource(value = {"3000:3", "1234:1"}, delimiter = ':')
	void sell_onlyAuto(String paidKRW, int numOfLottos) {
		final List<Lotto> soldLottos = lottoStore.sell(paidKRW, EMPTY_MANUAL_LOTTOS);
		assertThat(soldLottos.size()).isEqualTo(numOfLottos);
	}

	@ParameterizedTest
	@ValueSource(strings = {"-1", "0", "500", "NaN"})
	void sell_invalidPay(String pay) {
		assertThatExceptionOfType(LottoStorePaymentException.class)
			.isThrownBy(() -> lottoStore.sell(pay, EMPTY_MANUAL_LOTTOS))
			.withMessage(LottoStorePaymentException.ERROR_NOT_ENOUGH_KRW);
	}

	@Test
	void sell_tooManyManualLottos() {
		final String pay = String.valueOf(Lotto.PRICE_KRW);
		final List<String> manualLottos = Arrays.asList("1,2,3,4,5,6", "1,2,3,4,5,6");
		assertThatExceptionOfType(LottoStorePaymentException.class)
			.isThrownBy(() -> lottoStore.sell(pay, manualLottos))
			.withMessage(LottoStorePaymentException.ERROR_NOT_ENOUGH_KRW);
	}

	@Test
	void sell_onlyManually() {
		final List<String> manualLottos = Collections.singletonList("1,2,3,4,5,6");
		final String pay = String.valueOf(manualLottos.size() * Lotto.PRICE_KRW);
		assertThat(lottoStore.sell(pay, manualLottos).size()).isEqualTo(manualLottos.size());
	}

	@Test
	void sell_mixedAutoWithManually() {
		final List<String> manualLottos = Collections.singletonList("1,2,3,4,5,6");
		final int numOfLottos = 1 + manualLottos.size();
		final String pay = String.valueOf(numOfLottos * Lotto.PRICE_KRW);
		assertThat(lottoStore.sell(pay, manualLottos).size()).isEqualTo(numOfLottos);
	}
}
