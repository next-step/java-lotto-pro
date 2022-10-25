package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StringStudyTest {


    @Test
    @DisplayName("[요구사항 1] `1,2`를 `,` 로 split 하였을 경우 1, 2를 포함한 배열을 라턴한다 ")
    void splitTwoString() {
        String target = "1,2";

        String[] result = target.split(",");

        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("[요구사항 1] `1`을 `,` 로 split 하였을 경우 1만을 포함한 배열을 라턴한다 ")
    void splitOneString() {
        String target = "1";

        String[] result = target.split(",");

        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("[요구사항 2] `(1,2)`를 `(,)`를 제거하고 `1,2`를 반환한다. ")
    void splitSubString() {
        String target = "(1,2)";

        String result = target.substring(1, target.length() - 1);

        assertEquals(result, "1,2");
    }

    @ParameterizedTest
    @CsvSource(value = {"0:a", "1:b", "2:c"}, delimiter = ':')
    @DisplayName("[요구사항 3] charAt을 이용하여 `abc`의 특정위치의 값을 가져온다 - 성공")
    void charAtSuccess(int index, char value) {
        String target = "abc";

        assertEquals(target.charAt(index), value);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 4})
    @DisplayName("[요구사항 3] charAt이`abc`의 범위를 벗어 날 경우 예외가 발생한다. - 실패")
    void charAtException(int value) {
        String target = "abc";

        assertThatThrownBy(() -> {
            target.charAt(value);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("index out of range");
    }
}
