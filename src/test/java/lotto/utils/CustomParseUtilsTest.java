package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CustomParseUtilsTest {
    @Test
    @DisplayName("문자열을 IntegerList로 정상 변환")
    void CustomParseUtilsTest_stringToIntegerList(){
        String str = "1, 2, 3, 4, 5";
        List<Integer> result = CustomParseUtils.stringToIntegerList(str);
        assertThat(result).containsExactly(1, 2, 3, 4, 5);
    }

    @Test
    @DisplayName("문자열을 IntegerList로 비정상 변환")
    void CustomParseUtilsTest_stringToIntegerList_Invalid(){
        String str = "a, 2, 3, 4, 5";
        assertThatThrownBy(() -> {
            List<Integer> result = CustomParseUtils.stringToIntegerList(str);
        });
    }

    @Test
    @DisplayName("문자열을 숫자로 정상 변환")
    void CustomParseUtilsTest_stringToInteger(){
        String str = "123";
        assertThat(CustomParseUtils.stringToInteger(str)).isEqualTo(123);
    }

    @Test
    @DisplayName("문자열을 숫자로 비정상 변환")
    void CustomParseUtilsTest_stringToInteger_Invalid(){
        String str = "a23";
        assertThatThrownBy(() -> {
            int result = CustomParseUtils.stringToInteger(str);
        });
    }
}