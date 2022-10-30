import model.LottoNumber;
import model.Lottos;
import model.Money;
import model.strategy.MockStrategy;
import model.strategy.RandomStrategy;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottosTest {

    @Test
    void 입력한_금액만큼_로또를구매한다() {
        int money = 10000;
        Lottos lottos = new Lottos(new Money(money), new MockStrategy(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(lottos.getLotto()).hasSize(10);
    }

    @Test
    void 천원이하의_금액을_입력하면_오류를_리턴한다() {
        int money = 100;
        assertThatThrownBy(() -> {
            new Lottos(new Money(money), new MockStrategy(Arrays.asList(1, 2, 3, 4, 5, 6)));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1000원 이상의 금액을 입력해주세요.");
    }

    @Test
    void 로또숫자의범위는_1에서_45여야한다() {
        int money = 10000;
        List<Integer> arrangeNumber = new ArrayList<>();

        for (int i = 0; i <= 45; i++) {
            arrangeNumber.add(i);
        }

        Lottos lottos = new Lottos(new Money(money), new RandomStrategy(arrangeNumber));

        for (LottoNumber lotto : lottos.getLotto()) {
            boolean result = lotto.getNumber().stream().allMatch(v -> v > 0 && v < 46);
            assertThat(result).isTrue();
        }
    }
}
