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

    @Test
    @DisplayName("양끝 문자열 제거")
    public void 문자열_제거() {
        // given
        String str = "(1,2)";
        //  when
        str = str.substring(1, str.length() - 1);
        // then
        assertThat(str).isEqualTo("1,2");
    }
}
