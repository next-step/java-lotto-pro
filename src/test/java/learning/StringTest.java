package learning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @DisplayName("'1,2'를 split 했을 때 1과 2로 분리된다")
    @Test
    public void splitTest1and2() {
        // given
        String target = "1,2";
        // when
        String[] split = target.split(",");
        // then
        assertThat(split).containsExactly("1", "2");
    }

    @DisplayName("'1'을 split 했을 때 1만 포함하는 배열이 반환된다")
    @Test
    public void splitTestOnly1() {
        // given
        String target = "1";
        // when
        String[] split = target.split(",");
        // then
        assertThat(split).containsExactly("1");
    }

    @DisplayName("'(1,2)'값을 substring() 메소드를 이용해 '1,2'로 반환한다")
    @Test
    public void subString() {
        // given
        String target = "(1,2)";
        target = target.substring(1, target.length() - 1);
        // when
        String[] split = target.split(",");
        // then
        assertThat(split).containsExactly("1", "2");
    }

    @DisplayName("'abc' 값이 주어졌을 때 charAt() 메서드를 이용해 특정 위치의 문자를 반환한다")
    @ParameterizedTest
    @MethodSource
    public void charAt(int index, char character) {
        // given
        String target = "abc";
        // when
        char charAt = target.charAt(index);
        // then
        assertThat(charAt).isEqualTo(character);
    }

    private static Stream<Arguments> charAt() {
        return Stream.of(
                Arguments.of(0, "a"),
                Arguments.of(1, "b"),
                Arguments.of(2, "c")
        );
    }

    @DisplayName("charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생한다")
    @Test
    public void charAtWithOutOfBoundsIndex() {
        // given
        String target = "abc";
        int outOfIndex = target.length() + 1;
        // when
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
            .isThrownBy(() -> {
                char charAt = target.charAt(outOfIndex);
            }).withMessageContaining("String index out of range: 4");
    }
}
