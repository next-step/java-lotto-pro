package study.step3.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringUtilTest {
    private static final String DELIMITER = ",";

    @Test
    @DisplayName("문자열 분할 및 숫자변환 - 공백없음")
    void splitAndParseInt() {
        List<Integer> result = StringUtil.splitAndParseInt("1", DELIMITER);
        assertThat(result).containsExactly(1);
    }

    @Test
    @DisplayName("문자열 분할 및 숫자변환 - 공백없음")
    void splitAndParseInt_withoutSapce() {
        List<Integer> result = StringUtil.splitAndParseInt("1,2,3,4", DELIMITER);
        assertThat(result).containsExactly(1, 2, 3, 4);
    }

    @Test
    @DisplayName("문자열 분할 및 숫자변환 - 공백있음")
    void splitAndParseInt_withSpace() {
        List<Integer> result = StringUtil.splitAndParseInt(" 1, 2 ,3 , 4 ", DELIMITER);
        assertThat(result).containsExactly(1, 2, 3, 4);
    }

    @Test
    @DisplayName("문자열 분할 및 숫자변환 - 예외 - 숫자 외 문자 포함")
    void split_withNonNumber() {
        assertThatThrownBy(() -> StringUtil.splitAndParseInt(" 1, a , 4 ", DELIMITER))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("문자열 분할 및 숫자변환 - 예외 - 숫자 외 빈칸 포함")
    void split_withSpace() {
        assertThatThrownBy(() -> StringUtil.splitAndParseInt(" 1, , 4 ", DELIMITER))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("주어진 리스트 섞은 후, 지정된 사이즈로 잘라서 반환")
    void suffleAndSlice() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> result = StringUtil.shuffleAndSlice(numbers, 3);
        assertThat(numbers).containsAll(result);
    }
}
