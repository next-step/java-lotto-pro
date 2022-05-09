package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class StringTest {

    @Test
    void split() {
        String[] split = "1,2".split(",");
        assertAll(
                () -> assertThat(split).contains("1"),
                () -> assertThat(split).containsExactly("1", "2")
        );

    }

    @Test
    void subString() {
        String data = "(1,2)";
        assertThat(data.substring(1, data.length() - 1)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("abc가 주어졌을때 특정 위치의 문자를 가져오는지 확인한다.")
    void charAt() {
        String data = "abc";
        assertAll(
                () -> assertThat(data.charAt(0)).isEqualTo('a'),
                () -> assertThat(data.charAt(1)).isEqualTo('b'),
                () -> assertThat(data.charAt(2)).isEqualTo('c')
        );
    }

    @Test
    @DisplayName("abc의 범위를 벗어난 인덱스를 조회할 경우 StringIndexOutOfBoundsException 예외 발생")
    void charAt_outOfBound() {
        String data = "abc";
        int outIndex = 4;
        assertThatThrownBy(() ->
                data.charAt(outIndex)
        ).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: " + outIndex);

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    data.charAt(outIndex);
                }).withMessageContaining("String index out of range: " + outIndex);
    }

}
