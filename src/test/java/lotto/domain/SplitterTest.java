package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SplitterTest {

    @Test
    void 문자열을_숫자_리스트로_변환한다() {
        assertThat(Splitter.split("1,2,3")).contains(1, 2, 3);
    }
}