package lotto.controller;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoCountTest {

    @Test
    void 생성자의_인수로_넘어온_값이_숫자_형식이_아닐_경우_예외가_발생한다() {
        // when and then
        assertThatThrownBy(() ->
            new LottoCount("A")
        ).isInstanceOf(IllegalArgumentException.class);
    }
}