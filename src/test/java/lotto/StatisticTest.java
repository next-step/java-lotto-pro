package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StatisticTest {
    private final List<LottoNumbers> fakePurchaseLottoNumbers = new ArrayList<>();

    @BeforeEach
    void init() {
        fakePurchaseLottoNumbers.add(new LottoNumbers(new ArrayList<>(
                Arrays.asList(new LottoNumber(1), new LottoNumber(2),
                        new LottoNumber(3), new LottoNumber(4),
                        new LottoNumber(5), new LottoNumber(6)))));
        fakePurchaseLottoNumbers.add(new LottoNumbers(new ArrayList<>(
                Arrays.asList(new LottoNumber(1), new LottoNumber(2),
                        new LottoNumber(3), new LottoNumber(4),
                        new LottoNumber(5), new LottoNumber(45)))));
        fakePurchaseLottoNumbers.add(new LottoNumbers(new ArrayList<>(
                Arrays.asList(new LottoNumber(1), new LottoNumber(2),
                        new LottoNumber(3), new LottoNumber(4),
                        new LottoNumber(44), new LottoNumber(45)))));
        fakePurchaseLottoNumbers.add(new LottoNumbers(new ArrayList<>(
                Arrays.asList(new LottoNumber(1), new LottoNumber(2),
                        new LottoNumber(3), new LottoNumber(43),
                        new LottoNumber(44), new LottoNumber(45)))));
    }

    @Test
    void 여섯개_맞춘_개수_가져오기() {
        Statistic statistic = new Statistic(new LottoNumbers(new ArrayList<>(
                Arrays.asList(new LottoNumber(1), new LottoNumber(2),
                        new LottoNumber(3), new LottoNumber(4),
                        new LottoNumber(5), new LottoNumber(6)))));
        statistic.countPrize(fakePurchaseLottoNumbers, new LottoNumber(7));
        assertThat(statistic.getCountOfFirst()).isEqualTo(1);
    }

    @Test
    void 다섯개와_보너스_번호_맞춘_개수_가져오기() {
        Statistic statistic = new Statistic(new LottoNumbers(new ArrayList<>(
                Arrays.asList(new LottoNumber(1), new LottoNumber(2),
                        new LottoNumber(3), new LottoNumber(4),
                        new LottoNumber(5), new LottoNumber(6)))));
        statistic.countPrize(fakePurchaseLottoNumbers, new LottoNumber(45));
        assertThat(statistic.getCountOfSecond()).isEqualTo(1);
    }

    @Test
    void 다섯개_맞춘_개수_가져오기() {
        Statistic statistic = new Statistic(new LottoNumbers(new ArrayList<>(
                Arrays.asList(new LottoNumber(1), new LottoNumber(2),
                        new LottoNumber(3), new LottoNumber(4),
                        new LottoNumber(5), new LottoNumber(6)))));
        statistic.countPrize(fakePurchaseLottoNumbers, new LottoNumber(7));
        assertThat(statistic.getCountOfThird()).isEqualTo(1);
    }

    @Test
    void 네개_맞춘_개수_가져오기() {
        Statistic statistic = new Statistic(new LottoNumbers(new ArrayList<>(
                Arrays.asList(new LottoNumber(1), new LottoNumber(2),
                        new LottoNumber(3), new LottoNumber(4),
                        new LottoNumber(5), new LottoNumber(6)))));
        statistic.countPrize(fakePurchaseLottoNumbers, new LottoNumber(7));
        assertThat(statistic.getCountOfFourth()).isEqualTo(1);
    }

    @Test
    void 세개_맞춘_개수_가져오기() {
        Statistic statistic = new Statistic(new LottoNumbers(new ArrayList<>(
                Arrays.asList(new LottoNumber(1), new LottoNumber(2),
                        new LottoNumber(3), new LottoNumber(4),
                        new LottoNumber(5), new LottoNumber(6)))));
        statistic.countPrize(fakePurchaseLottoNumbers, new LottoNumber(7));
        assertThat(statistic.getCountOfFifth()).isEqualTo(1);
    }

    @Test
    void 상금의_총합_계산() {
        Statistic statistic = new Statistic(new LottoNumbers(new ArrayList<>(
                Arrays.asList(new LottoNumber(1), new LottoNumber(2),
                        new LottoNumber(3), new LottoNumber(4),
                        new LottoNumber(5), new LottoNumber(6)))));
        statistic.countPrize(fakePurchaseLottoNumbers, new LottoNumber(7));
        assertThat(statistic.calculateTotalEarnings()).isEqualTo(2001555000.0);
    }

    @Test
    void 수익률_계산() {
        Statistic statistic = new Statistic(new LottoNumbers(new ArrayList<>(
                Arrays.asList(new LottoNumber(1), new LottoNumber(2),
                        new LottoNumber(3), new LottoNumber(4),
                        new LottoNumber(5), new LottoNumber(6)))));
        statistic.countPrize(fakePurchaseLottoNumbers, new LottoNumber(7));
        assertThat(statistic.calculateTotalEarningsRate(4000)).isEqualTo(500388.75);
    }
}
