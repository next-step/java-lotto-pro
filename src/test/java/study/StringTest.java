package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("요구사항 1")
    void split(){
        String[] result = "1,2".split(",");
        String[] result2 = "1".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
        assertThat(result2).contains("1");
    }

    @Test
    @DisplayName("요구사항 2")
    void substring(){
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항 3")
    void charAt(){
        assertThat("abc".charAt(0)).isEqualTo('a');
        assertThat("abc".charAt(1)).isEqualTo('b');
        assertThat("abc".charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("요구사항 3 - IndexOutOfBoundsException")
    void charAt2(){
        assertThatThrownBy(() -> {
            "abc".charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
