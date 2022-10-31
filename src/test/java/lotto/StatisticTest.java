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
        LottoNumber fakeGeneratedLottoNumber1 = new LottoNumber(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        LottoNumber fakeGeneratedLottoNumber2 = new LottoNumber(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7)));
        LottoNumber fakeGeneratedLottoNumber3 = new LottoNumber(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 7, 8)));
        LottoNumber fakeGeneratedLottoNumber4 = new LottoNumber(new ArrayList<>(Arrays.asList(1, 2, 3, 7, 8, 9)));
        fakePurchaseLottoNumbers.add(fakeGeneratedLottoNumber1);
        fakePurchaseLottoNumbers.add(fakeGeneratedLottoNumber2);
        fakePurchaseLottoNumbers.add(fakeGeneratedLottoNumber3);
        fakePurchaseLottoNumbers.add(fakeGeneratedLottoNumber4);
    }

    @Test
    void 여섯개_맞춘_개수_가져오기() {
        Statistic statistic = new Statistic(new WinningNumber(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))));
        statistic.countPrize(fakePurchaseLottoNumbers);
        assertThat(statistic.getCountOfFirst()).isEqualTo(1);
    }

    @Test
    void 다섯개_맞춘_개수_가져오기() {
        Statistic statistic = new Statistic(new WinningNumber(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))));
        statistic.countPrize(fakePurchaseLottoNumbers);
        assertThat(statistic.getCountOfSecond()).isEqualTo(1);
    }

    @Test
    void 네개_맞춘_개수_가져오기() {
        Statistic statistic = new Statistic(new WinningNumber(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))));
        statistic.countPrize(fakePurchaseLottoNumbers);
        assertThat(statistic.getCountOfThird()).isEqualTo(1);
    }

    @Test
    void 세개_맞춘_개수_가져오기() {
        Statistic statistic = new Statistic(new WinningNumber(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))));
        statistic.countPrize(fakePurchaseLottoNumbers);
        assertThat(statistic.getCountOfFourth()).isEqualTo(1);
    }
}
