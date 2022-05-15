package lotto.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilsTest {

    @Test
    void 문자열을_숫자_리스트로_변환할_수_있다() {
        assertThat(StringUtils.convertToList("1,2,3,4", ",")).containsExactly(1, 2, 3, 4);
    }

    @Test
    void 공백이_포함된_문자도_처리할_수_있다() {
        assertThat(StringUtils.convertToList("1 , 2 , 3 ,4 ", ",")).containsExactly(1, 2, 3, 4);
    }

}