import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("String 클래스에 대한 학습 테스트")
class StringTest {

    public static final String DELIMITER = ",";

    @DisplayName("1,2를 ,로 split 하여 1,2로 분리한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2"})
    void splitTwoWords(String text) {

        String[] actual = text.split(DELIMITER);

        assertAll(
                () -> assertThat(actual).contains("1"),
                () -> assertThat(actual).contains("2"),
                () -> assertThat(actual).containsExactly("1", "2")
        );
    }

    @DisplayName("1을 ,로 split 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1"})
    void splitOneWord(String text) {

        String[] actual = text.split(DELIMITER);

        assertAll(
                () -> assertThat(actual).contains("1"),
                () -> assertThat(actual).containsExactly("1")
        );
    }

    @DisplayName("(1,2)의 ()를 제거하여  1,2를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"(1,2)"})
    void substring(String text) {

        String actual = text.substring(1, 5);

        assertThat(actual).contains("1,2");
    }

    @DisplayName("특정 위치의 문자를 가져온다.")
    @ParameterizedTest
    @CsvSource({"abcdef", "1bevcs", "ubsdfeve"})
    void charAt(String text) {

        char actual = text.charAt(1);

        assertThat(actual).isEqualTo('b');
    }

}
