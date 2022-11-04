package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoListTest {

    LottoList lottoList;

    @BeforeEach
    void setUp() {
        lottoList = new LottoList();
        lottoList.add(Lotto.valueOf(new ManualLottoNumberGenerateStrategy(Arrays.asList(2, 3, 6, 12, 27, 44))));
        lottoList.add(Lotto.valueOf(new ManualLottoNumberGenerateStrategy(Arrays.asList(16, 21, 30, 31, 35, 36))));
        lottoList.add(Lotto.valueOf(new ManualLottoNumberGenerateStrategy(Arrays.asList(15, 23, 27, 33, 34, 43))));
        lottoList.add(Lotto.valueOf(new ManualLottoNumberGenerateStrategy(Arrays.asList(1, 31, 33, 34, 35, 40))));
        lottoList.add(Lotto.valueOf(new ManualLottoNumberGenerateStrategy(Arrays.asList(11, 35, 37, 38, 41, 44))));
        lottoList.add(Lotto.valueOf(new ManualLottoNumberGenerateStrategy(Arrays.asList(6, 14, 27, 32, 36, 40))));
        lottoList.add(Lotto.valueOf(new ManualLottoNumberGenerateStrategy(Arrays.asList(8, 12, 15, 28, 30, 34))));
        lottoList.add(Lotto.valueOf(new ManualLottoNumberGenerateStrategy(Arrays.asList(2, 12, 13, 16, 26, 45))));
        lottoList.add(Lotto.valueOf(new ManualLottoNumberGenerateStrategy(Arrays.asList(1, 6, 19, 36, 38, 40))));
        lottoList.add(Lotto.valueOf(new ManualLottoNumberGenerateStrategy(Arrays.asList(8, 10, 16, 20, 37, 43))));
    }

    @Test
    void 로또리스트에_로또를_추가한다() {
        assertThat(lottoList.get()).hasSize(10);
    }

    @ParameterizedTest(name = "로또리스트와_당첨된_로또를_비교한다")
    @MethodSource("lottoListMatchFixture")
    void 로또리스트와_당첨된_로또를_비교한다(List<Integer> winNumbers, LottoMatchType lottoMatchType) {
        Lotto winLotto = Lotto.valueOf(new ManualLottoNumberGenerateStrategy(winNumbers));

        List<LottoMatchType> match = lottoList.match(winLotto, BonusLottoNumber.valueOf(40, winLotto));

        assertThat(match).contains(lottoMatchType);
    }

    static Stream<Arguments> lottoListMatchFixture() {
        return Stream.of(
            Arguments.of(
                Arrays.asList(8, 10, 16, 20, 37, 43), LottoMatchType.SIX
            ),
            Arguments.of(
                Arrays.asList(8, 10, 16, 20, 37, 1), LottoMatchType.FIVE
            ),
            Arguments.of(
                Arrays.asList(1, 6, 19, 36, 38, 2), LottoMatchType.FIVE_BONUS
            ),
            Arguments.of(
                Arrays.asList(8, 10, 16, 20, 1, 2), LottoMatchType.FOUR
            ),
            Arguments.of(
                Arrays.asList(8, 10, 16, 1, 2, 3), LottoMatchType.THREE
            ),
            Arguments.of(
                Arrays.asList(8, 1, 2, 3, 4, 43), LottoMatchType.OTHER
            )
        );
    }
}
