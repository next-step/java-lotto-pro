package camp.nextstep.edu.level1.lotto.lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


class MoneyTest {

    @Test
    void 금액은_음수일_수_없다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Money(-1));
    }
}