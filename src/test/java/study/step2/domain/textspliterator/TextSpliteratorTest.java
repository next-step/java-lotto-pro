package study.step2.domain.textspliterator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextSpliteratorTest {

    @Test
    @DisplayName("문자열을 커스텀 구분자로 분리한다")
    void custom_delimiter_split_test() {
        String text = "//?\n1?2?3";

        TextSpliterator textSpliterator = new CustomDelimiterSpliterator();
        String[] tokens = textSpliterator.split(text);

        assertArrayEquals(tokens, new String[] {"1", "2", "3"});
    }

    @Test
    @DisplayName("문자열을 기본(쉼표 또는 콜론) 구분자로 분리한다")
    void default_delimiter_split_test() {
        String text = "1,2:3";

        TextSpliterator textSpliterator = new DefaultDelimiterSpliterator();
        String[] tokens = textSpliterator.split(text);

        assertArrayEquals(tokens, new String[] {"1", "2", "3"});
    }

    @Test
    @DisplayName("문자열이 숫자로만 구성되어있는 경우 분리하지않고 반환한다")
    void none_delimiter_split_test() {
        String text = "123";

        TextSpliterator textSpliterator = new NoneDelimiterSpliterator();
        String[] tokens = textSpliterator.split(text);

        assertArrayEquals(tokens, new String[] {"123"});
    }
}