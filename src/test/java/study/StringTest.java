package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    void split() {
        //given
        String sentence = "1,2";

        //when
        String[] sentenceSplitByComma = sentence.split(",");

        //then
        assertThat(sentenceSplitByComma).containsExactly("1", "2");
    }

    @Test
    void substring() {
        //given
        String sentence = "(1,2)";

        //when
        String result = sentence.substring(sentence.indexOf("(")+1, sentence.lastIndexOf(")"));

        //then
        assertThat(result).isEqualTo("1,2");
    }
}
