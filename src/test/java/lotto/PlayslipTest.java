package lotto;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayslipTest {

    @Test
    @DisplayName("로또 용지를 생성할 수 있다.")
    void create() {
        assertDoesNotThrow(() -> new Playslip(
                Fixtures.createNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))
            )
        );
    }
}
