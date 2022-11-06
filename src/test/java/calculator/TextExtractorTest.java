package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("문자 추출기")
class TextExtractorTest {

    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void nullAndEmpty(String text) {
        assertThat(new TextExtractor(new Delimiters(), text).extract()).contains("0");
    }

    @DisplayName("커스텀 구분자를 포함할 경우 커스텀 구분자가 제외된 부분을 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3"})
    void onlyText(String text) {
        assertThat(new TextExtractor(new Delimiters(), text).extractText(text)).isEqualTo("1;2;3");
    }
}
