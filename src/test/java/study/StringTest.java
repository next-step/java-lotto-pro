package study;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    void split() {
        assertAll(
                () -> assertThat("1,2".split(",")).containsExactly("1", "2"),
                () -> assertThat("1".split(",")).contains("1")
        );
    }

    @Test
    void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("위치 값 벗어난 경우 StringIndexOutOfBoundsException 테스트")
    @Test
    void charAt() {
        assertThatThrownBy(() -> "abc".charAt(6))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 6");
    }
}
