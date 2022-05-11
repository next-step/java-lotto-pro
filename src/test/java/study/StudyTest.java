package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;

import static org.assertj.core.api.Assertions.assertThat;

public class StudyTest {

    @Test
    @DisplayName("요구사항 1-1. \"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인한다.")
    void splitMultipleValuesWithCommaTest() {
        assertThat("1,2".split(","))
                .isInstanceOf(String[].class)
                .hasOnlyElementsOfType(String.class)
                .hasSize(2)
                .containsExactly("1", "2");
    }

    @Test
    @DisplayName("요구사항 1-2. \"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인한다.")
    void splitSingleValueWithCommaTest() {
        assertThat("1,".split(","))
                .isInstanceOf(String[].class)
                .hasOnlyElementsOfType(String.class)
                .hasSize(1)
                .containsExactly("1");
    }

    @Test
    @DisplayName("요구사항 2. \"(1,2)\"이 주어졌을 때 substring()을 활용해 \"1,2\"를 반환한다.")
    void substringTest() {
        String value = "(1,2)";
        assertThat(value.substring(1, value.length() - 1))
                .isEqualTo("1,2");
    }
}
