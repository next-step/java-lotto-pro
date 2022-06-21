package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningTest {
    @Test
    void 당첨_번호_보너스_번호_중복() {
        assertThatThrownBy(() -> {
            List<Number> numbers = new LinkedList<>();
            for (int idx = 1; idx <= 6; idx++) {
                numbers.add(Number.of(idx));
            }
            new Winning(new Lottery(numbers), Number.of(1));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}