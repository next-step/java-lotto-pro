package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("문자열을 쉼표로 분할한다")
    void simpleSplitTest() {
        // given
        String target1 = "1,2";
        String target2 = "1";
        String delimiter = ",";

        // when
        String[] splitTarget1 = target1.split(delimiter);
        String[] splitTarget2 = target2.split(delimiter);

        // then
        assertThat(splitTarget1).containsExactly("1", "2");
        assertThat(splitTarget2).containsExactly("1");
    }

    @Test
    @DisplayName("subString을 활용해서 괄호를 제거한다")
    void substringTest() {
        // given
        String substringTarget = "(1,2)";

        // when
        String substringedTarget = substringTarget.substring(1, 4);

        // then
        assertThat(substringedTarget).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 인덱스의 char를 확인한다")
    void charAtTest() {
        // given
        String given = "abc";

        // when
        char character1 = given.charAt(0);
        char character2 = given.charAt(1);
        char character3 = given.charAt(2);

        // then
        assertThat(character1).isEqualTo('a');
        assertThat(character2).isEqualTo('b');
        assertThat(character3).isEqualTo('c');
    }

    @ParameterizedTest
    @DisplayName("charAt의 인덱스가 범위를 벗어나 StringIndexOutOfBoundsException을 발생한다")
    @ValueSource(ints = {-1, 3})
    void charAtFailTest(int ourOfRangeIndex) {
        // given
        String given = "abc";

        // when
        assertThatThrownBy(() -> given.charAt(ourOfRangeIndex))
                // then
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: " + ourOfRangeIndex);
    }
}
