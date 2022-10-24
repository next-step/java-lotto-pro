package step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @Test
    @DisplayName("숫자 하나로만 이루어진 문자열을 입력받아야 합니다. ")
    public void single_number_parse_exception() {
        Assertions.assertThatThrownBy(() -> {
            Integer.parseInt("1,2");
        }).isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("For input string: \"1,2\"");
    }

    @Test
    @DisplayName("구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다.")
    public void split() {
        String[] result = "1,2:3".split(",|:");
        assertThat(result).containsAnyOf("3", "2", "1");
    }

    @Test
    @DisplayName("//와 \n문자 사이에 커스텀 구분자를 지정할 수 있다")
    public void pattern() {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher("//;\n1;2;3");
        m.find();
        assertThat(m.group(1)).contains(";");
        assertThat(m.group(2)).contains("1;2;3");
    }

    @Test
    @DisplayName("매칭기 되지 않으면 IllegalStateException 발생")
    public void pattern_exception() {
        Assertions.assertThatThrownBy(() -> {
            Matcher m = Pattern.compile("//(.)\n(.*)").matcher("/\n1;2;3");
            m.find();
            m.group(1);
        }).isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("No match found");
    }

    @Test
    @DisplayName("문자열 배열에서 음수가 들었있는지 확인")
    public void negative_number() {
        String[] splitValue = "-1,-2,-3".split(",");
        assertThat(Arrays.stream(splitValue)
                .mapToInt(Integer::parseInt)
                .filter(n -> n < 0)
                .count()).isEqualTo(3);
    }


    @Test
    public void splitAndSum_null_또는_빈문자() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void splitAndSum_숫자하나() throws Exception {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
