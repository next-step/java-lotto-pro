package lotto;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayslipsTest {

    @Test
    @DisplayName("여러장의 로또 용지로 로또 용지 일급 컬렉션을 생성할 수 있다.")
    void create() {
        assertDoesNotThrow(() -> new Playslips(
                Arrays.asList(
                    new Playslip(Fixtures.createNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))),
                    new Playslip(Fixtures.createNumbers(Arrays.asList(40, 41, 42, 43, 44, 45)))
                )
            )
        );
    }
}
