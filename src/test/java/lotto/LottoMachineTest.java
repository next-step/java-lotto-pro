package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static lotto.Number.MAX_RANGE_NUMBER;
import static lotto.Number.MIN_RANGE_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LottoMachineTest {

    @Test
    void 로또_자동생성() {
        Lotto lotto = new Lotto(LottoMachine.getRandomNumbers());

        assertThat(lotto.getNumberValues()).hasSize(6);
        assertThat(lotto.getNumberValues().get(0)).isBetween(MIN_RANGE_NUMBER, MAX_RANGE_NUMBER);
        assertThat(lotto.getNumberValues().get(1)).isBetween(MIN_RANGE_NUMBER, MAX_RANGE_NUMBER);
        assertThat(lotto.getNumberValues().get(2)).isBetween(MIN_RANGE_NUMBER, MAX_RANGE_NUMBER);
        assertThat(lotto.getNumberValues().get(3)).isBetween(MIN_RANGE_NUMBER, MAX_RANGE_NUMBER);
        assertThat(lotto.getNumberValues().get(4)).isBetween(MIN_RANGE_NUMBER, MAX_RANGE_NUMBER);
        assertThat(lotto.getNumberValues().get(5)).isBetween(MIN_RANGE_NUMBER, MAX_RANGE_NUMBER);
    }

    @ParameterizedTest
    @CsvSource({"3000,3", "14000,14"})
    void 입력받은_금액만큼_자동_로또발급(int price, int quantity) {
        LottoMachine lottoMachine = new LottoMachine();

        Lottos lottos = lottoMachine.buy(quantity, new Lottos(Collections.emptyList()));
        int expected = lottoMachine.getQuantity(price);

        assertThat(lottos.getLottos()).hasSize(expected);
    }

    @ParameterizedTest
    @MethodSource(value = "buyTestParameter")
    void 자동_수동_동시발급(int autoQuantity, Lottos manualLottos) {
        LottoMachine lottoMachine = new LottoMachine();

        Lottos lottos = lottoMachine.buy(autoQuantity, manualLottos);

        assertThat(lottos.getLottos()).hasSize(autoQuantity + manualLottos.getLottos().size());
    }

    static Stream<Arguments> buyTestParameter() {
        return Stream.of(
                arguments(3, new Lottos(Arrays.asList(new Lotto(new int[]{8, 21, 23, 41, 42, 43}), new Lotto(new int[]{8, 21, 23, 41, 42, 43})))));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 3200, 10500})
    void 예외테스트_잘못된_금액입력(int price) {
        LottoMachine lottoMachine = new LottoMachine();

        assertThatThrownBy(() -> lottoMachine.getQuantity(price)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource(value = "profitTestParameter")
    void 수익률_계산(int price, List<Rank> ranks, double expectedProfit) {
        LottoMachine lottoMachine = new LottoMachine();

        double profitRate = lottoMachine.getProfitRate(price, ranks);

        assertThat(profitRate).isEqualTo(expectedProfit);
    }

    static Stream<Arguments> profitTestParameter() {
        return Stream.of(
                arguments(1000, Arrays.asList(Rank.FIFTH), 5.00),
                arguments(2000, Arrays.asList(Rank.FIFTH, Rank.LOSE), 2.50),
                arguments(5000, Arrays.asList(Rank.FIFTH, Rank.LOSE, Rank.LOSE, Rank.LOSE, Rank.LOSE), 1.00));
    }

}