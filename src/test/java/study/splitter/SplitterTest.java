package study.splitter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class SplitterTest {

    @DisplayName("문자열을 기본 구분자로 분리하여 리턴하는 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1,2:3", "1:2:3"})
    void split(String str) {
        assertThat(Splitter.split(str)).containsExactly("1", "2", "3");
    }

    @DisplayName("문자열을 사용자 정의 구분자로 분리하여 리턴하는 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3", "//=\n1=2=3", "//-\n1-2-3"})
    void splitCustom(String str) {
        assertThat(Splitter.split(str)).containsExactly("1", "2", "3");
    }

}
