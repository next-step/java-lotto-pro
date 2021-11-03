package lotto;

import lotto.utils.StringUtils;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringUtilsTest {

    @Test
    void 문자열_쉼표_구분() {
        assertThat(StringUtils.separate("1, 2, 3, 4, 5, 6"))
                .containsExactly("1", "2", "3", "4", "5", "6");
    }

    @Test
    void 숫자_6개미만_에러처리() {
        assertThatThrownBy(() ->
                StringUtils.separate("1, 2, 3, 4, 5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_이외의값_에러처리() {
        assertThatThrownBy(() ->
                StringUtils.separate("1, 2, 3, 4, 5, aa"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복숫자_에러처리() {
        assertThatThrownBy(() ->
                StringUtils.separate("1, 2, 3, 4, 5, 5"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
