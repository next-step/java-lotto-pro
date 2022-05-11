package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SplitUtilsTest {

    private SplitUtils splitUtils = new SplitUtils();

    @DisplayName("기본 구분자를 사용하여 입력값을 구분한다.")
    @ValueSource(strings = {"1,2:3", "1,2,3", "1:2:3"})
    @ParameterizedTest
    void splitByDefaultDelimiter(String input) {
        String[] strings = splitUtils.splitByDefaultDelimiter(input);
        assertThat(strings).containsExactly("1", "2", "3");
    }

    @DisplayName("커스텀 구분자를 사용하여 입력값을 구분한다.")
    @Test
    void splitByCustomDelimiter() {
        String[] strings = splitUtils.splitByDelimiter("//;\n1;2;3");
        assertThat(strings).containsExactly("1", "2", "3");
    }
}