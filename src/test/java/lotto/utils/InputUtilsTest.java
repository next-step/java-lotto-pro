package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static lotto.utils.InputUtils.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputUtilsTest {

    @ParameterizedTest
    @CsvSource(value = {"10000:10000", "13000:13000", "5000:5000", "0:0"}, delimiter = ':')
    @DisplayName("입력받은 문자열 숫자를 Integer 타입으로 변환한다.")
    void convertToInteger_string타입_숫자(String input, int expected) {
        assertThat(convertToInteger(input))
                .isExactlyInstanceOf(Integer.class)
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("입력받은 문자열을 구분자로 쪼개 List 타입으로 변환한다.")
    void splitWithDelimiter_구분자_분할() {
        assertThat(splitWithDelimiter("1, 2, 3, 4, 5, 6"))
                .isInstanceOf(List.class)
                .hasOnlyElementsOfType(String.class)
                .hasSize(6)
                .containsExactly("1", "2", "3", "4", "5", "6");
    }

    @Test
    @DisplayName("입력받은 String 리스트를 Integer 리스트로 변환한다.")
    void convertToIntegerList_리스트_변환() {
        List<String> inputList = Arrays.asList("1", "2", "3", "4", "5", "6");

        assertThat(convertToIntegerList(inputList))
                .isInstanceOf(List.class)
                .hasOnlyElementsOfType(Integer.class)
                .hasSize(6)
                .containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("타입 변환 시 입력값에 숫자가 아닌 값이 존재하면 예외를 발생시킨다.")
    void convertToIntegerList_예외발생() {
        List<String> input = Arrays.asList("1", "2", "A", "4", "5", "6");

        assertThatThrownBy(() -> convertToIntegerList(input))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자만 입력이 가능합니다!");
    }


}