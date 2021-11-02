package step2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SplitNumberTest {
    @Test
    @DisplayName("양수가 아닌경우 예외발생")
    void splitNumber_예외() {
        // when
        assertThatExceptionOfType(RuntimeException.class)
            // then
            .isThrownBy(() -> {
                SplitNumber.valueOf("A");
            }).withMessageMatching(SplitNumber.NOT_POSITIVE_NUMBER);
    }
}
