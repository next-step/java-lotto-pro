package study.step4.helper;

import org.junit.jupiter.api.Test;
import study.step3.helper.NumbersParser;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberParserTest {
    @Test
    void 구분자가_있는_문자열_정수형_리스트로_변경() {
        List<Integer> numbers = NumbersParser.stringToListInteger("1, 2, 3, 4, 5, 6");

        assertThat(numbers).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }
}
