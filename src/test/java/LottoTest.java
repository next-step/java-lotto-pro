import model.Lotto;
import model.LottoNumber;
import model.strategy.MockStrategy;
import model.strategy.RandomStrategy;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static common.Constants.END_LOTTO_NUMBER;
import static common.Constants.START_LOTTO_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    void 입력한_금액만큼_로또를구매한다() {
        int money = 10000;
        List<LottoNumber> buyLotto = new Lotto(money, new MockStrategy(Arrays.asList(1, 2, 3, 4, 5, 6))).buy();
        assertThat(buyLotto).hasSize(10);
    }

    @Test
    void 천원이하의_금액을_입력하면_오류를_리턴한다() {
        int money = 100;
        assertThatThrownBy(() -> {
            new Lotto(money, new MockStrategy(Arrays.asList(1, 2, 3, 4, 5, 6))).buy();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1000원 이상의 금액을 입력해주세요.");
    }

    @Test
    void 로또숫자의범위는_1에서_45여야한다() {
        int money = 10000;
        List<Integer> arrangeNumber = new ArrayList<>();
        for (int i = START_LOTTO_NUMBER; i <= END_LOTTO_NUMBER; i++) {
            arrangeNumber.add(i);
        }

        List<LottoNumber> buyLotto = new Lotto(money, new RandomStrategy(arrangeNumber)).buy();

        for (LottoNumber lotto : buyLotto) {
            boolean result = lotto.getNumber().stream().allMatch(v -> v > 0 && v < 46);
            assertThat(result).isTrue();
        }
    }
}
