package calculator.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringSplitterTest {

    @Test
    @DisplayName("문자열을 기본구분자를 이용해 Split 할 수 있다. (기본 구분자 : , or :)")
    void split01() {
        // given
        String text = "1,2:3";

        // when
        String[] splitText = StringSplitter.split(text);

        // then
        assertAll(
            () -> assertThat(splitText).contains("1"),
            () -> assertThat(splitText).contains("2"),
            () -> assertThat(splitText).contains("3")
        );
    }

    @Test
    @DisplayName("문자열을 커스텀 구분자를 이용해 Split 할 수 있다.")
    void customSplit01() {
        // given
        String text = "//;\n1;2;3";

        // when
        String[] splitText = StringSplitter.split(text);

        // then
        assertAll(
            () -> assertThat(splitText).contains("1"),
            () -> assertThat(splitText).contains("2"),
            () -> assertThat(splitText).contains("3")
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"//-\n1-2-3", "///\n1/2/3"})
    @DisplayName("문자열을 커스텀 구분자를 이용해 Split 할 수 있다. (여러 케이스 테스트)")
    void customSplit02(String text) {
        // given & when
        String[] splitText = StringSplitter.split(text);

        // then
        assertAll(
            () -> assertThat(splitText).contains("1"),
            () -> assertThat(splitText).contains("2"),
            () -> assertThat(splitText).contains("3"),
            () -> assertThat(splitText.length).isEqualTo(3)
        );
    }
}