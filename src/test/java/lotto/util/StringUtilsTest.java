package lotto.util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringUtilsTest {
    @DisplayName("숫자 하나를 문자열로 입력받은 경우 size 1을 반환한다.")
    @ParameterizedTest(name = "숫자 {0}를 문자열로 입력받은 경우 size {1} 를 반환한다.")
    @CsvSource(value = {"1:1", "2:1", "3:1", "15:1"}, delimiter = ':')
    void splitSize(String input, int expect) {
        String[] split = StringUtils.split(input);
        assertThat(split).hasSize(expect);
    }

    @DisplayName("문자열 (,), 콜론(:) 구분자로 구분된 문자열 만큼 사이즈를 반환한다.")
    @ParameterizedTest(name = "문자열 {0}를 컴마(,) 구분자로 입력할 경우 사이즈 {1}을 반환한다.")
    @CsvSource(value = {"1:2/2", "2,2/2", "3:0,3/3", "15,15:70,20/4", "1,2:2:3/4"}, delimiter = '/')
    void splitAndSumCommaDelimiter(String input, int expect) {
        String[] split = StringUtils.split(input);
        assertThat(split).hasSize(expect);
    }
}
