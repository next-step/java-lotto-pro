package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumbersTest {

    @Test
    @DisplayName("6개의 로또 번호로 로또 번호 일급 컬렉션을 생성할 수 있다.")
    void create() {
        assertDoesNotThrow(() -> Fixtures.createNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    @DisplayName("로또 번호 갯수는 6보다 작거나 클 수 없다.")
    void create_invalidSize() {
        assertThatThrownBy(() -> new Numbers(Collections.emptyList()))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
