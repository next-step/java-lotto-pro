package study.splitter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class SplitterTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1,2:3", "1:2:3"})
    void split(String str) {
        assertThat(Splitter.split(str)).containsExactly("1", "2", "3");
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3", "//=\n1=2=3", "//-\n1-2-3"})
    void splitCustom(String str) {
        assertThat(Splitter.split(str)).containsExactly("1", "2", "3");
    }

}
