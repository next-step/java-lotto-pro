package calculator.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class StringUtilsTest {

    @Test
    void 콤마_콜론_구분자로_split() {
        assertAll(
                () -> assertThat(StringUtils.split("3,4,5")).containsExactly("3", "4", "5"),
                () -> assertThat(StringUtils.split("1:40:52")).containsExactly("1", "40", "52"),
                () -> assertThat(StringUtils.split("1:40,52:2")).containsExactly("1", "40", "52", "2")
        );
    }

    @Test
    void 커스텀_구분자로_split() {
        assertAll(
                () -> assertThat(StringUtils.split("//;\n1;2;3")).containsExactly("1", "2", "3"),
                () -> assertThat(StringUtils.split("//!\n11!22!33")).containsExactly("11", "22", "33")
        );
    }
}
