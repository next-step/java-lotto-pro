package stringcalculator.utils;

import static org.assertj.core.api.Assertions.assertThat;

import static stringcalculator.utils.StringSplitter.split;

import org.junit.jupiter.api.Test;

class StringSplitterTest {

    @Test
    void basicSplitTest() {
        String input = "1,2,3";
        String[] split = split(input);
        assertThat(split).containsExactly("1", "2", "3");
    }

    @Test
    void customDelimiterTest() {
        String input = "//;\n1;2;3";
        String[] split = split(input);
        assertThat(split).containsExactly("1", "2", "3");
    }
}
