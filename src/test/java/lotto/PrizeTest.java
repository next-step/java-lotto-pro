package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PrizeTest {
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
    void 당첨_결과_집계() throws NoSuchFieldException, IllegalAccessException {
        Prize prize = new Prize(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        prize.countPrize(fakePurchaseLottoNumbers);
        Field field = prize.getClass().getDeclaredField("prize");
        field.setAccessible(true);
        Map<Integer, Integer> resultPrize = (Map<Integer, Integer>) field.get(prize);
        assertThat(resultPrize.get(6)).isEqualTo(1);
        assertThat(resultPrize.get(5)).isEqualTo(1);
        assertThat(resultPrize.get(4)).isEqualTo(1);
        assertThat(resultPrize.get(3)).isEqualTo(1);
    }

    @Test
    void 여섯개_맞춘_개수_가져오기() {
        Prize prize = new Prize(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        prize.countPrize(fakePurchaseLottoNumbers);
        assertThat(prize.getCountOfFirst()).isEqualTo(1);
    }

    @Test
    void 다섯개_맞춘_개수_가져오기() {
        Prize prize = new Prize(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        prize.countPrize(fakePurchaseLottoNumbers);
        assertThat(prize.getCountOfSecond()).isEqualTo(1);
    }

    @Test
    void 네개_맞춘_개수_가져오기() {
        Prize prize = new Prize(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        prize.countPrize(fakePurchaseLottoNumbers);
        assertThat(prize.getCountOfThird()).isEqualTo(1);
    }

    @Test
    void 세개_맞춘_개수_가져오기() {
        Prize prize = new Prize(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        prize.countPrize(fakePurchaseLottoNumbers);
        assertThat(prize.getCountOfFourth()).isEqualTo(1);
    }
}
