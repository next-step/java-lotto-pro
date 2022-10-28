package javalib;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @DisplayName("문자열을 콤마(,)로 분리하면, 콤마를 기준으로 문자열이 분리되어 배열로 반환된다.")
    @Test
    void splitStringByComma() {
        final String targetString = "1,2";

        final String[] splitStrings = targetString.split(",");

        assertThat(splitStrings).containsExactly("1", "2");
    }

    @DisplayName("콤마(,)가 포함되지 않은 문자열을 콤마로 분리하면, 원 문자열 하나가 포함된 배열이 반환된다.")
    @Test
    void splitSingle() {
        final String targetString = "1";

        final String[] splitStrings = targetString.split(",");

        assertThat(splitStrings).containsExactly("1");
    }

    @DisplayName("substring()을 이용하여 '(1,2)' 문자열에서 괄호를 제거하기")
    @Test
    void substring() {
        final String targetString = "(1,2)";

        final String result = targetString.substring(1, 4);

        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("charAt()은 index에 해당하는 문자를 반환한다.")
    @Test
    void charAt() {
        final String targetString = "abc";
        final int givenIndex = 1;

        final char result = targetString.charAt(givenIndex);

        assertThat(result).isEqualTo('b');
    }

    @DisplayName("charAt() 인자에 위치 값을 벗어나는 index를 집어 넣으면 범위를 벗어났다는 예외를 던진다.")
    @Test
    void charAtThrowIndexOutOfBoundsException() {
        final String targetString = "abc";
        final int givenIndex = 3;

        assertThatThrownBy(() -> targetString.charAt(givenIndex))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageMatching("String index out of range: \\w+");
    }
}
