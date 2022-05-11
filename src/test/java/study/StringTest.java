package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringTest {
    @Test
    @DisplayName("텍스트 split 확인")
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("단일 항목 텍스트의 split 확인")
    void splitSingleWord() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("문자열 괄호 제거 기능 확인")
    void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열 특정 위치 값 정상획득 확인")
    void charAt() {
        char result = "abc".charAt(1);
        assertThat(result).isEqualTo('b');
    }

    @Test
    @DisplayName("문자열 범위를 벗어난 위치의 값 요구시 Exception 발생 확인")
    void charAtWithOutOfBounds() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> "abc".charAt(4));
    }
}
