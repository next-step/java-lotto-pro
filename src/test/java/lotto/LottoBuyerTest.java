package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoBuyerTest {

    @Test
    void 자신의_돈보다_수동구매_개수가_더_많으면_최대로_산다() {
        LottoBuyer lottoBuyer = new LottoBuyer(new PayAmount(3000));
        LottoStore lottoStore = new LottoStore();

        lottoBuyer.buyWithManual(lottoStore, Arrays.asList(8, 21, 23, 41, 42, 43));
        lottoBuyer.buyWithManual(lottoStore, Arrays.asList(3, 5, 11, 16, 32, 38));
        lottoBuyer.buyWithManual(lottoStore, Arrays.asList(7, 11, 16, 35, 36, 44));
        lottoBuyer.buyWithManual(lottoStore, Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoBuyer.buyWithManual(lottoStore, Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoBuyer.buyWithManual(lottoStore, Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoBuyer.buyWithManual(lottoStore, Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(lottoBuyer.getManualLottoCount()).isEqualTo(3);
        assertThat(lottoBuyer.getRandomLottoCount()).isEqualTo(0);
    }

    @Test
    void 수동구매_이후에_나머지_돈으로_자동구매를_한다() {
        LottoBuyer lottoBuyer = new LottoBuyer(new PayAmount(14000));
        LottoStore lottoStore = new LottoStore();

        lottoBuyer.buyWithManual(lottoStore, Arrays.asList(8, 21, 23, 41, 42, 43));
        lottoBuyer.buyWithManual(lottoStore, Arrays.asList(3, 5, 11, 16, 32, 38));
        lottoBuyer.buyWithManual(lottoStore, Arrays.asList(7, 11, 16, 35, 36, 44));
        lottoBuyer.buyWithRandom(lottoStore);

        assertThat(lottoBuyer.getManualLottoCount()).isEqualTo(3);
        assertThat(lottoBuyer.getRandomLottoCount()).isEqualTo(11);
    }
}
