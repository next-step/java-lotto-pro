package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StringUtilsTest {

    @SuppressWarnings("ConstantConditions")
    @DisplayName("isNull 성공 테스트")
    @Test
    void isNull_success() {
        // given
        String str = null;

        // when
        boolean result = StringUtils.isNull(str);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("isNull 실패 테스트")
    @ParameterizedTest(name = "{displayName}{index} -> str: {0}")
    @ValueSource(strings = {"a", "가", "", " "})
    void isNull_failure(String str) {
        // when
        boolean result = StringUtils.isNull(str);

        // then
        assertThat(result).isFalse();
    }

    @DisplayName("isNumber 성공 테스트")
    @ParameterizedTest(name = "{displayName} -> str: {0}")
    @ValueSource(strings = {"-1", "0", "1"})
    void isNumber_success(String str) {
        // when
        boolean result = StringUtils.isNumber(str);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("isNumber 실패 테스트")
    @ParameterizedTest(name = "{displayName} -> str: {0}")
    @ValueSource(strings = {"a", "가"})
    void isNumber_failure(String str) {
        // when
        boolean result = StringUtils.isNumber(str);

        // then
        assertThat(result).isFalse();
    }

    @DisplayName("toNumber 성공 테스트")
    @ParameterizedTest(name = "{displayName} -> str: {0}")
    @ValueSource(strings = {"-1", "0", "1"})
    void toNumber_success(String str) {
        // when
        int number = StringUtils.toNumber(str);

        // then
        assertThat(number).isEqualTo(Integer.parseInt(str));
    }

    @DisplayName("toNumber 실패 테스트")
    @ParameterizedTest(name = "{displayName} -> str: {0}")
    @ValueSource(strings = {"a", "가", "", " "})
    void toNumber_failure(String str) {
        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> StringUtils.toNumber(str))
                .withMessageStartingWith(StringUtils.IS_NOT_STRING_NUMBER);
    }
}
