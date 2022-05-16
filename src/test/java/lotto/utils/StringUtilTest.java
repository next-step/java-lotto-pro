package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilTest {
    @Test
    @DisplayName("주어진 문자열이 비어있는 경우 isNullOrEmpty는 truthy해야 한다")
    void be_truthy_on_empty_string() {
        String string = "";
        Boolean isNullOrEmpty = StringUtil.isNullOrEmpty(string);

        assertThat(isNullOrEmpty).isTrue();
    }

    @Test
    @DisplayName("주어진 문자열이 null인 경우 isNullOrEmpty는 truthy해야 한다")
    void be_truthy_on_null() {
        String string = null;
        Boolean isNullOrEmpty = StringUtil.isNullOrEmpty(string);

        assertThat(isNullOrEmpty).isTrue();
    }

    @Test
    @DisplayName("주어진 문자열이 임의의 문자열일 경우 isNullOrEmpty는 falsy해야 한다")
    void be_falsy_on_some_string() {
        String string = "apple";
        Boolean isNullOrEmpty = StringUtil.isNullOrEmpty(string);

        assertThat(isNullOrEmpty).isFalse();
    }
}
