import lotto.WinningNumbers;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumbersTest {

    @Test
    void 생성_예외() {
        assertThatThrownBy(() -> {
            new WinningNumbers("1,1,1,2,2,3");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
