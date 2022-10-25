package study.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringUtilTest {

    @ParameterizedTest
    @NullAndEmptySource
    void isEmpty_문자열이_null이거나_비어있으면_true(String str) {
        assertTrue(StringUtil.isEmpty(str));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "테스트"})
    void isEmpty_문자열이_null이_아니고_비어있지_않으면_false(String str) {
        assertFalse(StringUtil.isEmpty(str));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "1", "2", "3"})
    void isNotSplit_문자열의_크기가_1이하이면_true(String str) {
        assertTrue(StringUtil.isNotSplit(str));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2", "2,3", "1,2,3"})
    void isNotSplit_문자열의_크기가_1초과이면_false(String str) {
        assertFalse(StringUtil.isNotSplit(str));
    }
}
