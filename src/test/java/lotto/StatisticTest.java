package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StatisticTest {
    private final List<LottoNumber> fakePurchaseLottoNumbers = new ArrayList<>();

    @BeforeEach
    void init() {
        fakePurchaseLottoNumbers.add(new LottoNumber(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))));
        fakePurchaseLottoNumbers.add(new LottoNumber(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 45))));
        fakePurchaseLottoNumbers.add(new LottoNumber(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 44, 45))));
        fakePurchaseLottoNumbers.add(new LottoNumber(new ArrayList<>(Arrays.asList(1, 2, 3, 43, 44, 45))));
    }

    @Test
    void 여섯개_맞춘_개수_가져오기() {
        Statistic statistic = new Statistic(new LottoNumber(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)), 7));
        statistic.countPrize(fakePurchaseLottoNumbers);
        assertThat(statistic.getCountOfFirst()).isEqualTo(1);
    }

    @Test
    void 다섯개와_보너스_번호_맞춘_개수_가져오기() {
        Statistic statistic = new Statistic(new LottoNumber(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)), 45));
        statistic.countPrize(fakePurchaseLottoNumbers);
        assertThat(statistic.getCountOfSecond()).isEqualTo(1);
    }

    @Test
    void 다섯개_맞춘_개수_가져오기() {
        Statistic statistic = new Statistic(new LottoNumber(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)), 7));
        statistic.countPrize(fakePurchaseLottoNumbers);
        assertThat(statistic.getCountOfThird()).isEqualTo(1);
    }

    @Test
    void 네개_맞춘_개수_가져오기() {
        Statistic statistic = new Statistic(new LottoNumber(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)), 7));
        statistic.countPrize(fakePurchaseLottoNumbers);
        assertThat(statistic.getCountOfFourth()).isEqualTo(1);
    }

    @Test
    void 세개_맞춘_개수_가져오기() {
        Statistic statistic = new Statistic(new LottoNumber(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)), 7));
        statistic.countPrize(fakePurchaseLottoNumbers);
        assertThat(statistic.getCountOfFifth()).isEqualTo(1);
    }

    @Test
    void 상금의_총합_계산() {
        Statistic statistic = new Statistic(new LottoNumber(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))));
        statistic.countPrize(fakePurchaseLottoNumbers);
        assertThat(statistic.calculateTotalEarnings()).isEqualTo(2001555000.0);
    }

    @Test
    void 수익률_계산() {
        Statistic statistic = new Statistic(new LottoNumber(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))));
        statistic.countPrize(fakePurchaseLottoNumbers);
        assertThat(statistic.calculateTotalEarningsRate(4000)).isEqualTo(500388.75);
    }
}
