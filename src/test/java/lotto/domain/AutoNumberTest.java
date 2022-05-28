package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoNumberTest {
    @Test
    @DisplayName("AutoNumber 객체가 생성된다.")
    void checkExceptionWithString() {
        assertThat(new AutoNumber(3)).isNotNull();
    }
}
