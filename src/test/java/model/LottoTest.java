package model;

import model.strategy.MockStrategy;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class LottoTest {

    @Test
    void 로또번호를_입력갯수만큼_생성한다() {
        int count = 2;
        Lotto lotto = new Lotto(count, new MockStrategy(Arrays.asList(1, 2, 3, 4, 5, 6)));
        org.assertj.core.api.Assertions.assertThat(lotto.getLotto()).hasSize(count);
    }
}