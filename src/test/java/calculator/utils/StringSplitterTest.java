package calculator.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringSplitterTest {

    @Test
    @DisplayName("문자열을 기본구분자를 이용해 Split 할 수 있다. (기본 구분자 : , or :)")
    void split01(){
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
}