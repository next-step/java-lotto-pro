package calculator.add.string.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class StringInputUtilTest {

    @ParameterizedTest
    @DisplayName("입력값이 빈칸이나 null일 경우 True를 리턴한다.")
    @NullAndEmptySource
    void 빈값이거나_null_일_경우(String input) {
        assertTrue(StringInputUtil.isBlank(input));
    }

    @Test
    @DisplayName("커스텀 구분자를 가진 경우 해당 구분자로 숫자를 추출한다.")
    void split_커스텀_구분자를_가진_경우() {
        String[] split = StringInputUtil.split("//;\n1;2;3");
        assertThat(split).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("기본 구분자로 숫자를 추출한다.")
    void split_커스텀_구분자를_가지지_않는_경우() {
        String[] split = StringInputUtil.split("1,2:3");
        assertThat(split).containsExactly("1", "2", "3");
    }

}
