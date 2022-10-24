package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void split() {
        //given
        String sentence = "1,2";

        //when
        String[] sentenceSplitByComma = sentence.split(",");

        //then
        Assertions.assertThat(sentenceSplitByComma).containsExactly("1", "2");
    }
}
