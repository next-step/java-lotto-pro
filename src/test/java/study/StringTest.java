package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    @DisplayName("문자열분리 문자 2개 이상")
    public void 문자열_분리_문자_2개_이상() {
        // given //  when
        String[] result = "1,2".split(",");
        // then
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("문자열분리 문자 1개 이상")
    public void 문자열_분리_문자_1개() {
        // given //  when
        String[] result = "1,".split(",");
        // then
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1");
    }
}
