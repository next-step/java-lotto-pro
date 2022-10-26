package calculator.domain.target.splitter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BasicSplitterTest {

    CalculatorSplitter splitter = new BasicSplitter();

    @ParameterizedTest
    @ValueSource(strings = "1,2:3")
    void comma_colon_split(String target) {
        String[] split = splitter.split(target);
        assertThat(split).contains("1", "2", "3");
        assertThat(split).containsExactly("1", "2", "3");
    }

    @ParameterizedTest
    @ValueSource(strings = "1:2")
    void colon_split(String target) {
        String[] split = splitter.split(target);
        assertThat(split).contains("1", "2");
        assertThat(split).containsExactly("1", "2");
    }

    @ParameterizedTest
    @ValueSource(strings = "1,2")
    void comma_split(String target) {
        String[] split = splitter.split(target);
        assertThat(split).contains("1", "2");
        assertThat(split).containsExactly("1", "2");
    }
}
