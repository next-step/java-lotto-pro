package step2;

import static org.assertj.core.api.Assertions.*;

import java.util.regex.Matcher;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SplitDelimiterTest {

    @Test
    @DisplayName("기본 구분자로 숫자 문자열 반환 검증")
    public void splitDelimiter_쉼표구분자() {
        // given
        String input = "10,20,30";

        // when
        String[] result = SplitDelimiter.splitDelimiterOfDefault(input);

        // then
        assertThat(result).contains("10", "20", "30");
    }

    @Test
    @DisplayName("기본 구분자 숫자 또는 콜론 String[] 반환 검증")
    public void splitDelimiter_쉼표_또는_콜론구분자() {
        // given
        String input = "10,20:30:40";

        // when
        String[] result = SplitDelimiter.splitDelimiterOfDefault(input);

        // then
        assertThat(result).contains("10", "20", "30", "40");
    }

    @Test
    @DisplayName("커스텀 구분자 String[] 반환 검증")
    public void splitDelimiter_커스텀구분자() {
        // given
        String input = "//;\n1;2;3";
        Matcher matcher = SplitDelimiter.CUSTOM_DELIMITER_REGEX.matcher(input);
        String[] result = {};

        // when
        if (matcher.find()) {
            result = SplitDelimiter.splitDelimiterOfCustom(matcher);
        }

        // then
        assertThat(result).contains("1", "2", "3");
    }

    @Test
    @DisplayName("stringSplit 기본 구분자 입력 반환 검증")
    public void stringSplit_기본_구분자() {
        // given
        String input = "10,20:30:40";

        // when
        String[] result = SplitDelimiter.stringSplit(input);

        // then
        assertThat(result).contains("10", "20", "30", "40");
    }

    @Test
    @DisplayName("stringSplit 커스텀 구분자 입력 반환 검증")
    public void stringSplit_커스텀_구분자() {
        // given
        String input = "//;\n1;2;3";

        // when
        String[] result = SplitDelimiter.stringSplit(input);

        // then
        assertThat(result).contains("1", "2", "3");
    }
    
}
