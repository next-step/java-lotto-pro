import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringTest {
    @DisplayName("1,2를 ','로 split하면 1과 2로 분리된다.")
    @Test
    void splitTest1() {
        assertThat("1,2".split(",")).containsExactly("1", "2");
    }

    @DisplayName("1을 ','로 split하면 1만 반환된다.")
    @Test
    void splitTest2() {
        assertThat("1".split(",")).containsExactly("1");
    }
}
