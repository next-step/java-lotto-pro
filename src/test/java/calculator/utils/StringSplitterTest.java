package calculator.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringSplitterTest {
    @Test
    @DisplayName("기본 구분자를 이용하여 Split 처리가 되어야 한다")
    void splitter_default_split() {
        String string = "1:2,3";
        String[] splitString = StringSplitter.split(string);

        assertThat(splitString).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("커스텀 구분자를 이용하여 Split 처리가 되어야 한다")
    void splitter_custom_split() {
        String string = "//;\n1;2;3";
        String[] splitString = StringSplitter.split(string);

        assertThat(splitString).containsExactly("1", "2", "3");
    }

    @ParameterizedTest
    @ValueSource(strings = {"//-\n1-2-3", "///\n1/2/3"})
    @DisplayName("커스텀 구분자를 이용하여 Split 처리가 되어야 한다 - 추가 케이스")
    void splitter_custom_split_more_cases(String string) {
        String[] splitString = StringSplitter.split(string);

        assertAll(
                () -> assertThat(splitString).containsExactly("1", "2", "3"),
                () -> assertThat(splitString).hasSize(3)
        );
    }

    @Test
    @DisplayName("문자열이 비어있는 경우 빈 배열이 반환되어야 한다")
    void splitter_given_string_is_empty() {
        String[] splitString = StringSplitter.split("");

        assertThat(splitString).hasSize(0);
    }

    @Test
    @DisplayName("문자열이 null인 경우 빈 배열이 반환되어야 한다")
    void splitter_given_string_is_null() {
        String[] splitString = StringSplitter.split(null);

        assertThat(splitString).hasSize(0);
    }
}
