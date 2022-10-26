package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @DisplayName("splitAndSum_null_또는_빈문자_0_반환")
    @ParameterizedTest
    @CsvSource(value = {"NIL:0", ":0"}, nullValues = "NIL", delimiter = ':')
    public void splitAndSum_null_or_empty(String text, int expectedData) {
        Number result = StringAddCalculator.splitAndSum(text);
        assertThat(result).isEqualTo(new Number(expectedData));
    }

    @DisplayName("splitAndSum_숫자만_있으면_숫자반환")
    @ParameterizedTest
    @CsvSource(value = {"0:0", "100:100"}, delimiter = ':')
    public void splitAndSum_only_number(String text, int expectedData) throws Exception {
        Number result = StringAddCalculator.splitAndSum(text);
        assertThat(result).isEqualTo(new Number(expectedData));
    }

    @DisplayName("splitAndSum_쉼표구분자_파싱_성공")
    @Test
    public void splitAndSum_쉼표구분자_파싱_성공() throws Exception {
        String[] result = StringAddCalculator.parseText("1,2");
        assertThat(result).isEqualTo(new String[]{"1", "2"});
    }

    @DisplayName("splitAndSum_쉼표_또는_콜론_구분자_파싱_성공")
    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자_파싱_성공() throws Exception {
        String[] result = StringAddCalculator.parseText("1,2:3");
        assertThat(result).isEqualTo(new String[]{"1", "2", "3"});
    }

    @DisplayName("splitAndSum_custom_구분자_파싱_성공")
    @Test
    public void splitAndSum_custom_구분자_파싱_성공() throws Exception {
        String[] result = StringAddCalculator.parseText("//;\n1;2;3");
        assertThat(result).isEqualTo(new String[]{"1", "2", "3"});
    }

    @DisplayName("splitAndSum_custom_구분자_없을경우_기본_구분자_파싱")
    @Test
    public void splitAndSum_custom_구분자_없을경우_기본_구분자_파싱() throws Exception {
        String[] result = StringAddCalculator.parseText("//\n1:2:3");
        assertThat(result).isEqualTo(new String[]{"//\n1", "2", "3"});
    }

    @DisplayName("splitAndSum_custom_구분자_기본_구분자_모두_없을_때_파싱_안됨")
    @Test
    public void splitAndSum_custom_구분자_기본_구분자_모두_없을_때_파싱_안됨() throws Exception {
        String[] result = StringAddCalculator.parseText("//\n1;2;3");
        assertThat(result).isEqualTo(new String[]{"//\n1;2;3"});
    }

    @DisplayName("splitAndSum_쉼표구분자")
    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        Number result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(new Number(3));
    }

    @DisplayName("splitAndSum_쉼표_또는_콜론_구분자")
    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        Number result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(new Number(6));
    }

    @DisplayName("splitAndSum_custom_구분자")
    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        Number result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(new Number(6));
    }

    @DisplayName("splitAndSum_custom_구분자_없을경우_에러")
    @Test
    public void splitAndSum_custom_구분자_없을때_에러() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("//\n1;2;3"))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("splitAndSum_음수_포함일때_에러")
    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3", "1,-2,3", "1,2,-3"})
    public void splitAndSum_negative(String text) throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(text))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("splitAndSum_파싱_후_숫자_아닐때_에러")
    @ParameterizedTest
    @ValueSource(strings = {"-a,2,3", "1,a,3", "1,2,a"})
    public void splitAndSum_contain_word_after_parsing(String text) throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(text))
                .isInstanceOf(RuntimeException.class);
    }
}
