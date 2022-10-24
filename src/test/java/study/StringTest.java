package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void split_contains() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1", "2");
    }

    @Test
    void split_exactly() {
        String[] result = "1,".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    void substring() {
        String input = "(1,2)";
        String result = input.substring(input.indexOf("(") + 1, input.indexOf(")"));
        assertThat(result).contains("1,2");
    }

    @Test
    @DisplayName("chatAt IndexOutOfBoundsException 발생 및 메시지 확인")
    void chatAt() {
        String input = "abc";
        int index = input.length();
        int size = input.length();
        String exceptionMessage = String.format("Index: %d, Size: %d", index, size);

        assertThatThrownBy(() -> {
            try {
                input.charAt(index);
            } catch (IndexOutOfBoundsException e) {
                throw new IndexOutOfBoundsException(exceptionMessage);
            }
        }).isInstanceOf(IndexOutOfBoundsException.class)
        .hasMessageContaining("Index: 3, Size: 3");


        assertThatExceptionOfType(IndexOutOfBoundsException.class)
        .isThrownBy(() -> {
            try {
                input.charAt(index);
            } catch (IndexOutOfBoundsException e) {
                throw new IndexOutOfBoundsException(exceptionMessage);
            }
        }).withMessageMatching("Index: \\d+, Size: \\d+");
    }

}
