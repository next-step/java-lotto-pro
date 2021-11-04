package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTest {
    @Test
    @DisplayName("문자열 split 복수개")
    void splitMultiple() {
        String given = "1,2";
        String[] when = given.split(",");
        // then
        assertThat(when).contains("1");
        assertThat(when).containsExactly("1", "2");
        assertEquals(when.length, 2);
    }

    @Test
    @DisplayName("문자열 split 1개")
    void splitSingle() {
        String given = "1";
        String[] when = given.split(",");
        // then
        assertThat(when).containsExactly("1");
        assertThat(when).doesNotContain("2");
        assertEquals(when.length, 1);
    }

    @Test
    @DisplayName("문자열 substring")
    void substring() {
        String given = "(1,2)";
        String when = given.substring(1, given.length()-1);
        // then
        assertThat(when).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열 charAt 범위 안")
    void charAtInRange() {
        String given = "abc";
        char when = given.charAt(1);
        // then
        assertThat(when).isEqualTo('b');
    }

    @Test
    @DisplayName("문자열 charAt 범위 밖 오류")
    void charAtOutOfRange() {
        String given = "abc";
        assertThatThrownBy(()-> {
            char when = given.charAt(given.length());
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
        .hasMessageContaining("out of range: " + given.length());
    }
}
