package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SafeStringTest {
    @Test
    @DisplayName("비어있는 문자열이 넘어오면 \"0\"을 반환함")
    void test1() {
        SafeString s = SafeString.of("");

        assertThat(s.toString()).isEqualTo("0");
    }

    @Test
    @DisplayName("null이 넘어오면 \"0\"을 반환함")
    void test2() {
        SafeString s = SafeString.of("");

        assertThat(s.toString()).isEqualTo("0");
    }

    @Test
    @DisplayName("공백만 여러개 있는 문자가 넘어오면 \"0\"을 반환함")
    void test3() {
        SafeString s = SafeString.of("  ");

        assertThat(s.toString()).isEqualTo("0");
    }
}