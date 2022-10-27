package calculator.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalculateParserTest {

    @Test
    @DisplayName("쉼표(,) 로 계산식을 파싱한다.")
    void commaParsingTest(){
        assertAll(
                () -> assertThat(StringCalculateParser.parseStringToArray("1,2")).containsExactly("1","2"),
                () -> assertThat(StringCalculateParser.parseStringToArray("1,")).containsExactly("1"),
                () -> assertThat(StringCalculateParser.parseStringToArray("1")).containsExactly("1")
        );
    }

    @Test
    @DisplayName("콜론(:) 으로 계산식을 파싱한다.")
    void colonParsingTest(){
        assertAll(
                () -> assertThat(StringCalculateParser.parseStringToArray("1:2")).containsExactly("1","2"),
                () -> assertThat(StringCalculateParser.parseStringToArray("1:")).containsExactly("1"),
                () -> assertThat(StringCalculateParser.parseStringToArray("1")).containsExactly("1")
        );
    }

    @Test
    @DisplayName("특정 구분자로 계산식을 파싱한다.")
    void customDelimiterParsingTest(){
        assertThat(StringCalculateParser.parseStringToArray("//;\n1;2;3")).containsExactly("1","2","3");
    }
}
