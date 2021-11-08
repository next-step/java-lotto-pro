import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoStoreTest {

	private final LottoStore lottoStore = new LottoStore();
	private final List<String> EMPTY_MANUAL_LOTTOS = Collections.emptyList();

	@Test
	void sell_arguments_null() {
		assertThatExceptionOfType(LottoStoreSellException.class)
			.isThrownBy(() -> lottoStore.sell(null, EMPTY_MANUAL_LOTTOS))
			.withMessage(LottoStoreSellException.ERROR_MESSAGE);

		final LottoPayment payment = createLottoPayment(Lotto.PRICE_KRW);
		assertThatExceptionOfType(LottoStoreSellException.class)
			.isThrownBy(() -> lottoStore.sell(payment, null))
			.withMessage(LottoStoreSellException.ERROR_MESSAGE);
	}

	@Test
	void sell_tooManyManualLottos() {
		final LottoPayment payment = createLottoPayment(Lotto.PRICE_KRW);
		final List<String> manualLottos = Arrays.asList("1,2,3,4,5,6", "1,2,3,4,5,6");
		assertThatExceptionOfType(LottoStoreSellException.class)
			.isThrownBy(() -> lottoStore.sell(payment, manualLottos))
			.withMessage(LottoStoreSellException.ERROR_MESSAGE);
	}

	@ParameterizedTest
	@CsvSource(value = {"3000:3", "1234:1"}, delimiter = ':')
	void sell_onlyAuto(String paidKRW, int numOfLottos) {
		final LottoPayment payment = LottoPayment.from(paidKRW);
		assertThat(lottoStore.sell(payment, EMPTY_MANUAL_LOTTOS).size()).isEqualTo(numOfLottos);
	}

	@Test
	void sell_onlyManually() {
		final List<String> manualLottos = Collections.singletonList("1,2,3,4,5,6");
		final LottoPayment payment = createLottoPayment(manualLottos.size() * Lotto.PRICE_KRW);
		assertThat(lottoStore.sell(payment, manualLottos).size()).isEqualTo(manualLottos.size());
	}

	@Test
	void sell_mixedAutoWithManually() {
		final List<String> manualLottos = Collections.singletonList("1,2,3,4,5,6");
		final int numOfLottos = 1 + manualLottos.size();
		final LottoPayment payment = createLottoPayment(numOfLottos * Lotto.PRICE_KRW);
		assertThat(lottoStore.sell(payment, manualLottos).size()).isEqualTo(numOfLottos);
	}

	private LottoPayment createLottoPayment(int KRW) {
		return LottoPayment.from(String.valueOf(KRW));
	}
}
