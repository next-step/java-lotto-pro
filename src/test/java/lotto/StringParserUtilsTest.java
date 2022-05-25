package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringParserUtilsTest {

    @Test
    void 콤마로_구분된_번호_처리() {
        assertThat(StringParserUtils.parseNumbers("1,2,3,4,5,6")).hasSize(6);
    }

}