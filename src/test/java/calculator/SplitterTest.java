package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Splitter 테스트")
class SplitterTest {

    @Test
    @DisplayName("숫자를 컴마로 구분한 문자열로 나누면 숫자 배열을 반환한다.")
    public void split1() {
        // given
        String input = "1,2,3";

        // when
        String[] result = Splitter.split(input);

        // then
        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("숫자를 컴마나 콜론으로 구분한 문자열로 나누면 숫자 배열을 반환한다.")
    public void split2() {
        // given
        String input = "1,2:3";

        // when
        String[] result = Splitter.split(input);

        // then
        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("숫자를 커스텀 구분자로 구분한 문자열로 나누면 숫자 배열을 반환한다.")
    public void split3() {
        // given
        String input = "//;\n1;2;3";

        // when
        String[] result = Splitter.split(input);

        // then
        assertThat(result).containsExactly("1", "2", "3");
    }
}
