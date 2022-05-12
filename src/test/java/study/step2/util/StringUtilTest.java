package study.step2.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringUtilTest {
    @Test
    @DisplayName("문자열 분할 테스트 - 콜론")
    void split_콜론() {
        String[] result = StringUtil.split("1:2:3");
        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("문자열 분할 테스트 - 콤마")
    void split_콤마() {
        String[] result = StringUtil.split("1,2,3");
        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("문자열 분할 테스트 - 콤마, 콜론,")
    void split_콤마_콜론() {
        String[] result = StringUtil.split("1:2,3");
        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("문자열 분할 테스트 - 커스텀")
    void split_커스텀() {
        String[] result = StringUtil.split("//;\n1;2;3");
        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("문자열 양수 변환 테스트 - 양수")
    void parseNonNegativeNumber_양수() {
        int result = StringUtil.parseNonNegativeNumber("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("문자열 양수 변환 테스트 - 0")
    void parseNonNegativeNumber_0() {
        int result = StringUtil.parseNonNegativeNumber("0");
        assertThat(result).isZero();
    }

    @Test
    @DisplayName("문자열 양수 변환 테스트 - 음수")
    void parseNonNegativeNumber_음수() {
        assertThatThrownBy(() -> StringUtil.parseNonNegativeNumber("-1"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("문자열 양수 변환 테스트 - 숫자이외의 문자")
    void parseNonNegativeNumber_숫자아닌문자() {
        assertThatThrownBy(() -> StringUtil.parseNonNegativeNumber("a"))
                .isInstanceOf(RuntimeException.class);
    }
}