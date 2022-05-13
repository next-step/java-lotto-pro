package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberStringSplitterTest {

    @Test
    @DisplayName("문자열로 전달된 로또 번호를 콤마(,)를 기준으로 분리한다.")
    void split01() {
        // given
        String text = "1,2,3,4,5,6";

        // when
        String[] splitText = LottoNumberStringSplitter.split(text);

        // then
        assertAll(
            () -> assertThat(splitText).contains("1"),
            () -> assertThat(splitText).contains("2"),
            () -> assertThat(splitText).contains("3"),
            () -> assertThat(splitText).contains("4"),
            () -> assertThat(splitText).contains("5"),
            () -> assertThat(splitText).contains("6"),
            () -> assertThat(splitText).hasSize(6)
        );
    }
}