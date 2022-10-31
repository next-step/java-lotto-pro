package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("문자 추출기")
class TextExtractorTest {

    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void customDelimiter(String text) {
        TextExtractor extractor = new TextExtractor(text);
        assertThat(extractor.extract()).isEqualTo("0");
    }
}
