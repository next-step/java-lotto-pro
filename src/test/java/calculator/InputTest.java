package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
class InputTest {

    @DisplayName("null 또는 빈 문자일 경우 true 반환")
    @ParameterizedTest
    @NullAndEmptySource
    void isNullOrEmpty(String inputs) {
        Input input = new Input(inputs);

        assertThat(input.isNullOrEmpty()).isTrue();
    }

    @DisplayName("입력값을 컴마(,)와 콜론(:)을 구분자로 구분")
    @ParameterizedTest
    @CsvSource(value = {"7,8,5$3", "5:7:2:4$4", "10,34:5,7:9$5"}, delimiter = '$')
    void split_쉼표_또는_콜론_구분자(String inputs, int size) {
        Input input = new Input(inputs);

        assertThat(input.split().length).isEqualTo(size);
    }

}
