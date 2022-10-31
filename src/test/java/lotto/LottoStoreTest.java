package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStoreTest {

    @ParameterizedTest(name = "구입금액만큼_로또를_산다")
    @CsvSource(value = {"14000:14", "13299:13", "12999:12"}, delimiter = ':')
    void 구입금액만큼_로또를_산다(long payAmount, int expectedLottoCount) {
        LottoStore lottoStore = new LottoStore();

        List<Lotto> lottoList = lottoStore.pay(new PayAmount(payAmount));

        assertThat(lottoList).hasSize(expectedLottoCount);
    }
}
