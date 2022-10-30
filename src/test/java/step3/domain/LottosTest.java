package step3.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

public class LottosTest {

    @Test
    public void testValidateDuplicate() {
        List<Integer> integers = Arrays.asList(1, 2, 3);
        UniqueNumbers numbers = UniqueNumbers.generate(integers);
        Lotto lotto = Lotto.generate(numbers);
        Lottos lottos = Lottos.generate(Collections.singletonList(lotto));
        assertThatThrownBy(() -> {
            lottos.getRanks(numbers, integers.get(0));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Duplicate Unique numbers and Bonus number.");
    }
}
