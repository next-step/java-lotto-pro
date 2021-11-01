package study;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
public class StringTest {

    @DisplayName("split 검증")
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1","2");
    }

    @DisplayName("substring 검증")
    @Test
    void substring() {
        String input = "(1,2)";
        String result = input.substring(1,4);
        assertThat(result).contains("1,2");
    }

    @DisplayName("StringIndexOutOfBoundsException 검증")
    @Test
    void chatAt() {
        String input = "abc";
        assertThatThrownBy(() ->{
            input.charAt(4);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");
    }

}
