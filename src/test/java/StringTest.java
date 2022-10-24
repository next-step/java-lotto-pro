import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringTest {

    @ParameterizedTest(name = "\"{0}\"을 ,로 split 하면 \"{1}\", \"{2}\"이다.")
    @CsvSource(value = {"1,2:1:2", "3,4:3:4", "5,6:5:6"}, delimiter = ':')
    void 문자열_분리(String given, String first, String second) {
        String[] token = given.split(",");
        assertThat(token).contains(first, second);
    }

    @ParameterizedTest(name = "\"{0}\"을 ,로 split 하면 \"{0}\"만을 포함한 배열이 반환된다.")
    @ValueSource(strings = {"1", "2", "3", "4"})
    void 문자열_분리_문자_하나만을_포함한_배열(String given) {
        String[] token = given.split("");
        assertThat(token).containsExactly(given);

    }

    @ParameterizedTest(name = "{0}이 주어졌을때 substring 으로 {1}을 반환할 수 있디.")
    @CsvSource(value = {"(1,2):1,2", "(4,5):4,5", "(7,9):7,9"}, delimiter = ':')
    void 문자열_추출(String given, String expect) {
        String extractString = given.substring(1, 4);
        assertThat(extractString).isEqualTo(expect);
    }

    @ParameterizedTest(name = "{0}의 첫번째 문자는 {1}이다")
    @CsvSource(value = {"abc:a", "basic:b", "stone:s"}, delimiter = ':')
    void 문자열의_첫번쨰_문자(String given, char expect) {
        char firstCharacter = given.charAt(0);
        assertThat(firstCharacter).isEqualTo(expect);


    }

    @DisplayName("문자열의 위치 값을 벗어나서 charAt을 하면 StringIndexOutOfBoundsException이 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 4, 5, 6, 7})
    void 문자열_범위_오류(int position) {
        String given = "abc";
        assertThatThrownBy(() -> given.charAt(position)).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
