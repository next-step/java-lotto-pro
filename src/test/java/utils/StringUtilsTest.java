package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("String 클래스에 대한 학습 테스트")
class StringUtilsTest {

    @DisplayName("1,2를 ,로 split 하여 1,2로 분리한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2"})
    void splitText(String text) {
        String[] splitText = StringUtils.split(text);
        assertAll(
                () -> assertThat(splitText).contains("1"),
                () -> assertThat(splitText).contains("2"),
                () -> assertThat(splitText).containsExactly("1", "2")
        );

    }
}
