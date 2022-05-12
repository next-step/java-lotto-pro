package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringSplitterTest {
    @Test
    @DisplayName("문자열을 구분자(콤마) 기준으로 split 되어야 한다")
    void splitter_split() {
        String string = "14,42,52,63,1";
        String[] splitString = StringSplitter.split(string);

        assertAll(
                () -> assertThat(splitString).containsExactly("14", "42", "52", "63", "1"),
                () -> assertThat(splitString).hasSize(5)
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

    @ParameterizedTest
    @ValueSource(strings = {" 14     ,42,52,  63,1", "14     , 42, 52,  63,1   "})
    @DisplayName("split 된 문자열은 문자열을 trim 한 결과값과 같아야 한다. (= 결과에 앞뒤로 공백이 없어야 한다)")
    void splitter_returns_trimmed_string(String string) {
        String[] splitString = StringSplitter.split(string);

        assertAll(
                () -> assertThat(splitString).containsExactly("14", "42", "52", "63", "1"),
                () -> assertThat(splitString).hasSize(5)
        );
    }
}
