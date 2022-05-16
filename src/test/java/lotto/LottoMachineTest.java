package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static lotto.Number.MAX_RANGE_NUMBER;
import static lotto.Number.MIN_RANGE_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    void 입력받은_금액만큼_로또발급(int price, int quantity) {
        LottoMachine lottoMachine = new LottoMachine();

        Lottos lottos = lottoMachine.buy(price);

        assertThat(lottos.getLottos()).hasSize(quantity);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 3200, 10500})
    void 예외테스트_잘못된_금액입력(int price) {
        LottoMachine lottoMachine = new LottoMachine();

        assertThatThrownBy(() -> lottoMachine.buy(price)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 수익률_계산() {
        LottoMachine lottoMachine = new LottoMachine();

        int price = 14000;
        List<Rank> ranks = Arrays.asList(Rank._4ST, Rank.ZERO);
        double expected = 0.35;

        double profitRate = lottoMachine.getProfitRate(price, ranks);

        assertThat(profitRate).isEqualTo(expected);
    }

}