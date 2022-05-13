package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StringTest {

    private static final String SPLIT_SEPARATOR = ",";

    @DisplayName("\"1,2\"를 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트_contains")
    @Test
    void splitTest_contains() {
        // given
        String input = "1,2";
        String[] expected = {"1", "2"};

        // when
        String[] actual = input.split(SPLIT_SEPARATOR);

        // then
        assertThat(actual).contains(expected);    // 순서 상관 없음
    }

    @DisplayName("\"1,2\"를 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트_containsExactly")
    @Test
    void splitTest_containsExactly() {
        // given
        String input = "1,2";
        String[] expected = {"1", "2"};

        // when
        String[] actual = input.split(SPLIT_SEPARATOR);

        // then
        assertThat(actual).as("일부 문자열을 찾을 수 없습니다").containsExactly(expected);    // containsExactly : 순서 상관 있음
    }

    @DisplayName("\"1,2\"를 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트_containsExactlyInAnyOrder")
    @Test
    void splitTest_containsExactlyInAnyOrder() {
        // given
        String input = "1,2";
        String[] expected = {"2", "1"};

        // when
        String[] actual = input.split(SPLIT_SEPARATOR);

        // then
        assertThat(actual).containsExactlyInAnyOrder(expected);    // containsExactlyInAnyOrder : 순서 상관 없음
    }

    @DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트_contains")
    @Test
    void splitTest2_contains() {
        // given
        String input = "1";
        String[] expected = {"1"};

        // when
        String[] actual = input.split(SPLIT_SEPARATOR);

        // then
        assertThat(actual).contains(expected);
    }

    @DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트_containsExactly")
    @Test
    void splitTest2_containsExactly() {
        // given
        String input = "1";
        String[] expected = {"1"};

        // when
        String[] actual = input.split(SPLIT_SEPARATOR);

        // then
        assertThat(actual).containsExactly(expected);
    }

    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하도록 구현")
    @Test
    void substringTest() {
        // given
        String input = "(1,2)";
        String expected = "1,2";

        // when
        String actual = input.substring(1, input.length() - 1);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트")
    @Test
    void charAtTest() {
        // given
        String input = "abc";
        char expected = 'a';

        // when
        char actual = input.charAt(0);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트_ParameterizedTest")
    @ParameterizedTest
    @CsvSource(value = {"a:0", "b:1", "c:2"}, delimiter = ':')
    void charAtTest_ParameterizedTest(char expected, int index) {
        // given
        String input = "abc";

        // when
        char actual = input.charAt(index);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException")
    @Test
    void exceptionTest() {
        // given
        String input = "abc";

        // when & then
        assertThatThrownBy(() -> input.charAt(5)).isInstanceOf(StringIndexOutOfBoundsException.class);
    }

    @DisplayName("StringIndexOutOfBoundsException에 hasMessageContaining 추가")
    @Test
    void exceptionTest_hasMessageContaining() {
        // given
        String input = "abc";

        // when & then
        assertThatThrownBy(() -> input.charAt(5)).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 5");
    }

    @DisplayName("StringIndexOutOfBoundsException에 withMessageMatching 추가")
    @Test
    void exceptionTest_withMessageMatching() {
        // given
        String input = "abc";

        // when & then
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> input.charAt(5)).withMessageMatching("String index out of range: 5");
    }
}
