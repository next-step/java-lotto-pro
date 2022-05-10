package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SplitUtilsTest {

    private SplitUtils splitUtils = new SplitUtils();

    @ValueSource(strings = {"1,2:3", "1,2,3", "1:2:3"})
    @ParameterizedTest
    void splitByDefaultDelimiter(String input) {
        String[] strings = splitUtils.splitByDefaultDelimiter(input);
        assertThat(strings).containsExactly("1", "2", "3");
    }
}