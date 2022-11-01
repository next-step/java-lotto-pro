package step3.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Collections;
import org.junit.jupiter.api.Test;
import step3.utils.TestNumberProvider;

public class LottosTest {

    @Test
    public void testValidateDuplicate() {
        UniqueNumbers uniqueNumbers = TestNumberProvider.rangeUniqueNumbers(1, 6);
        Lotto lotto = Lotto.generate(uniqueNumbers);
        Lottos lottos = Lottos.generate(Collections.singletonList(lotto));
        Number bonusNumber = new Number(1);
        assertThatThrownBy(() -> {
            lottos.getRanks(uniqueNumbers, bonusNumber);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Duplicate Unique numbers and Bonus number.");
    }
}
