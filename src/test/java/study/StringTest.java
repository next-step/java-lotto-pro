package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("두 개의 숫자가 포함된 문자열 split 테스트")
    void splitStringContainedTwoNumber() {
        assertThat("1,2".split(",")).containsExactly("1", "2");
    }

    @Test
    @DisplayName("한 개의 숫자가 포함된 문자열 split 테스트")
    void splitStringContainedOneNumber() {
        assertThat("1".split(",")).contains("1");
    }

    @Test
    @DisplayName("첫 번째 문자와 마지막 문자를 제거하는 테스트")
    void substring_ShouldReturnMiddleSubString() {
        String str = "(1,2)";
        assertThat(str.substring(1, str.length()-1)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치의 문자를 가져오는 테스트")
    void charAt_ShouldReturnCharacterOfSpecificPosition() {
        assertThat("abc".charAt(1)).isEqualTo('b');
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 4})
    @DisplayName("특정 위치의 문자를 가져올 때 위치값을 벗어나는 경우 테스트")
    void charAt_ShouldThrowStringIndexOutOfBoundsException(int num) {
        String str = "abc";
        assertThatThrownBy(() -> {
            str.charAt(num);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessage("String index out of range: " + num);
    }
}
