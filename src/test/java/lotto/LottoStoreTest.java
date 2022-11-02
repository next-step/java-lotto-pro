package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
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

    @Test
    void 수동으로_사겠다고_말하고_돈을_지불하면_수동으로_로또를_산다() {
        LottoStore lottoStore = new LottoStore();

        lottoStore.buyWith(() -> new ManualLottoNumberGenerateStrategy(
            Arrays.asList(1, 2, 3, 4, 5, 6)
        ));

        List<Lotto> lottoList = lottoStore.pay(new PayAmount(1000));

        assertThat(lottoList).hasSize(1);
        assertThat(lottoList.get(0))
            .isEqualTo(Lotto.valueOf(new ManualLottoNumberGenerateStrategy(Arrays.asList(1, 2, 3, 4, 5, 6))));
    }

    @Test
    void 자동으로_사겠다고_말하고_돈을_지불하면_자동으로_로또를_산다() {
        LottoStore lottoStore = new LottoStore();

        lottoStore.buyWith(RandomLottoNumberGenerateStrategy::new);

        List<Lotto> lottoList = lottoStore.pay(new PayAmount(1000));

        assertThat(lottoList).hasSize(1);
    }
}
