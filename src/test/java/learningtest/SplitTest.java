package learningtest;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class SplitTest {

    String 구분자 = ",";

    @Test
    void splitTest() {
        Pattern compile = Pattern.compile(구분자);

        String 입력_숫자 = "1,2,3";

        String[] 분할된_숫자_배열 = compile.split(입력_숫자);

        assertThat(분할된_숫자_배열).containsExactly("1", "2", "3");
    }
}
