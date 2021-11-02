package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
class SeparatorTest {

    @DisplayName("입력값을 컴마(,)와 콜론(:)을 구분자로 구분")
    @ParameterizedTest
    @CsvSource(value = {"7,8,5$3", "5:7:2:4$4", "10,34:5,7:9$5"}, delimiter = '$')
    void split_쉼표_또는_콜론_구분자(String input, int size) {
        String[] splitInputs = Separator.split(input);

        assertThat(splitInputs.length).isEqualTo(size);
    }

    @DisplayName("\"//\"와 \"\\n\" 문자 사이에 커스텀 구분자를 입력하여 구분")
    @Test
    void split_custom_구분자() {
        String[] splitInputs = Separator.split("//;\n1;2;3");

        assertThat(splitInputs.length).isEqualTo(3);
    }

}
