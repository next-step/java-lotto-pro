package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StatisticTest {
    private final List<Lotto> fakePurchaseLottoNumbers = new ArrayList<>();

    @BeforeEach
    void setUp() {
        fakePurchaseLottoNumbers.add(Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6)));
        fakePurchaseLottoNumbers.add(Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 45)));
        fakePurchaseLottoNumbers.add(Lotto.from(Arrays.asList(1, 2, 3, 4, 44, 45)));
        fakePurchaseLottoNumbers.add(Lotto.from(Arrays.asList(1, 2, 3, 43, 44, 45)));
    }

    @Test
    void 여섯개_맞춘_개수_가져오기() {
        Statistic statistic = new Statistic(Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6)), LottoNumber.from(7));
        statistic.countPrize(new Lottos(fakePurchaseLottoNumbers));
        assertThat(statistic.getCountOfFirst()).isEqualTo(1);
    }

    @Test
    void 다섯개와_보너스_번호_맞춘_개수_가져오기() {
        Statistic statistic = new Statistic(Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6)), LottoNumber.from(45));
        statistic.countPrize(new Lottos(fakePurchaseLottoNumbers));
        assertThat(statistic.getCountOfSecond()).isEqualTo(1);
    }

    @Test
    void 다섯개_맞춘_개수_가져오기() {
        Statistic statistic = new Statistic(Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6)), LottoNumber.from(7));
        statistic.countPrize(new Lottos(fakePurchaseLottoNumbers));
        assertThat(statistic.getCountOfThird()).isEqualTo(1);
    }

    @Test
    void 네개_맞춘_개수_가져오기() {
        Statistic statistic = new Statistic(Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6)), LottoNumber.from(7));
        statistic.countPrize(new Lottos(fakePurchaseLottoNumbers));
        assertThat(statistic.getCountOfFourth()).isEqualTo(1);
    }

    @Test
    void 세개_맞춘_개수_가져오기() {
        Statistic statistic = new Statistic(Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6)), LottoNumber.from(7));
        statistic.countPrize(new Lottos(fakePurchaseLottoNumbers));
        assertThat(statistic.getCountOfFifth()).isEqualTo(1);
    }

    @Test
    void 상금의_총합_계산() {
        Statistic statistic = new Statistic(Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6)), LottoNumber.from(7));
        statistic.countPrize(new Lottos(fakePurchaseLottoNumbers));
        assertThat(statistic.calculateTotalEarnings()).isEqualTo(2001555000.0);
    }

    @Test
    void 수익률_계산() {
        Statistic statistic = new Statistic(Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6)), LottoNumber.from(7));
        statistic.countPrize(new Lottos(fakePurchaseLottoNumbers));
        assertThat(statistic.calculateTotalEarningsRate(4000)).isEqualTo(500388.75);
    }
}
