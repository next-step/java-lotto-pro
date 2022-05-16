package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputStringUtilsTest {

    private static final String BLANK_REGEX = ".*\\s.*";

    @DisplayName("입력된 문자열에 공백을 제거하고 split 해서 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:,:6", "1-2-3:-:3"}, delimiter = ':')
    void splitToNumberListByDelimiter(String inputString, String delimiter, int expectedSize) {
        List<String> numberWords = InputStringUtils.nonSpaceSplit(inputString, delimiter);
        for (String number : numberWords ){
            assertThat(number).doesNotMatch(BLANK_REGEX);
        }
        assertThat(numberWords).hasSize(expectedSize);
    }
}
