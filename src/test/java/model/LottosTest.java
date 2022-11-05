package model;

import model.strategy.MockStrategy;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @Test
    void 로또번호를_입력갯수만큼_생성한다() {
        int count = new Money(10000).availableBuyAutoLottoCount(0);

        Lottos lotto = new Lottos(Collections.emptyList(),
                new Seller().buyAuto(count, new MockStrategy(Arrays.asList(1, 2, 3, 4, 5, 6))));

        assertThat(lotto.getLotto()).hasSize(10);
    }
}