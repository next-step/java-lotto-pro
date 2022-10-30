package model;

import model.strategy.MockStrategy;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class LottosTest {

    @Test
    void 로또번호를_입력갯수만큼_생성한다() {
        Lottos lotto = new Lottos(new Money(10000), new MockStrategy(Arrays.asList(1, 2, 3, 4, 5, 6)));
        org.assertj.core.api.Assertions.assertThat(lotto.getLotto()).hasSize(10);
    }
}