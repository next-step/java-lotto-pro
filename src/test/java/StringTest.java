import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("split 분리 테스트")
    void separateStrBySplitTest() {
        String[] str = "1,2".split(",");
        assertThat(str).containsExactly("1","2");
    }

    @Test
    @DisplayName("단일 값 split 분리 테스트")
    void separateSingleStrBySplitTest() {
        String[] str = "1,".split(",");
        assertThat(str).containsExactly("1");
    }

    @Test
    @DisplayName("괄호 제거 테스트")
    void substringTest() {
        String trgt = "(1,2)";
        String str = trgt.substring(1, trgt.length()-1);
        assertThat(str).isEqualTo("1,2");
    }

    @ParameterizedTest
    @DisplayName("특정 위치의 문자 추출 테스트")
    @CsvSource(value = {"0:a", "1:b", "2:c"}, delimiter = ':')
    void chatAtTest(int index, char value) {
        assertThat("abc".charAt(index)).isEqualTo(value);
    }

    @ParameterizedTest
    @DisplayName("범위 초과 값 추출 예외 테스트")
    @ValueSource(strings = {"abc", "defg"})
    void charAtOutOfBoundsTest(String input) {
        assertThatThrownBy(() -> {
            input.charAt(input.length());
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
