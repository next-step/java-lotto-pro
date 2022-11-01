package step3.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Collections;
import org.junit.jupiter.api.Test;

public class LottosTest extends AbstractTest {

    @Test
    public void testValidateDuplicate() {
        Lotto lotto = Lotto.generate(exceptNumbers);
        Lottos lottos = Lottos.generate(Collections.singletonList(lotto));
        Number bonusNumber = new Number(1);
        assertThatThrownBy(() -> {
            lottos.getRanks(exceptNumbers, bonusNumber);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Duplicate Unique numbers and Bonus number.");
    }
}
