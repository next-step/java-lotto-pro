package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.constants.CalculatorConstants.DEFAULT_SPLIT_REGEX;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class StringAddCalculatorTest {

    private static Pattern pattern = Pattern.compile("//(.)\n(.*)");

    @ParameterizedTest
    @ValueSource(strings = "1,2:3")
    @DisplayName("문자열을 분리하여 숫자를 합산")
    public void getSumNumber(String inputString) {
        String[] strings = inputString.split(",|:");

        int sum = Arrays.asList(strings).stream().mapToInt(Integer::parseInt).sum();

        assertThat(sum).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = "//,\n1,2,3")
    @DisplayName("문자열을 커스텀 regex 를 이용하여 분리 후 숫자를 합산")
    public void getCustomRegexSumNumber(String inputString) {
        // given
        String customRegex = ",|:";
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(inputString);
        if (matcher.find()) {
            customRegex = matcher.group(1);
            inputString = matcher.group(2);
        }
        String[] strings = inputString.split(customRegex);

        // when
        int sum = Arrays.asList(strings).stream().mapToInt(Integer::parseInt).sum();


        // then
        assertThat(sum).isEqualTo(6);
    }


    static Stream<Arguments> listProvide() {
        List<String> strings = Arrays.asList("1", "2", "3", "-3");
        return Stream.of(arguments(strings));
    }

    @ParameterizedTest
    @MethodSource("listProvide")
    @DisplayName("숫자를 제외한 값 또는 음수 값이 있는지 검증")
    public void validationNumber(List<String> strings) {
        assertThatThrownBy(() -> {
            validateNumberFormatTest(strings);
        }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("[ERROR]");
    }


    public void validateNumberFormatTest(List<String> strings) {
        String joinString = String.join("", strings);
        if (!isNumberTest(joinString)) {
            System.out.println("[ERROR] 잘못된 입력 값입니다.");
            throw new IllegalArgumentException("[ERROR] 잘못된 입력 값입니다.");
        }
    }

    public boolean isNumberTest(String checkValue) {
        return checkValue.matches("^[0-9]+$");
    }


    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3;4"})
    public void stringCalculator(String inputString) {
        StringAddCalculator stringAddCalculator = new StringAddCalculator();
        int sum = stringAddCalculator.getNumberList(inputString);
        assertThat(sum).isEqualTo(10);
    }

}