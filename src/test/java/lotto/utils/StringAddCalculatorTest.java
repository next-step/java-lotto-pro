package lotto.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.*;

public class StringAddCalculatorTest {

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
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(inputString);
        String customRegex = ",|:";
        if (matcher.find()) {
            customRegex = matcher.group(1);
            inputString = matcher.group(2);
        }
        String[] strings = inputString.split(customRegex);
        int sum = Arrays.asList(strings).stream().mapToInt(Integer::parseInt).sum();

        assertThat(sum).isEqualTo(6);
    }



}