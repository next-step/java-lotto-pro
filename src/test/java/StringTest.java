import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    void split_메서드를_사용했을_때_1과_2로_문자열이_분리되어야_한다() {
        // given
        final String given = "1,2";

        // when
        final String[] result = given.split(",");

        // then
        assertThat(result).contains("1", "2");
    }
    
    @Test
    void split_메서드를_사용했을_때_1만을_포함하는_배열이_반환되어야_한다() {
        // given
        final String given = "1";
        
        // when
        final String[] result = given.split(",");
        
        // then
        assertThat(result).containsExactly("1");
    }
    
    @Test
    void substring_메서드를_사용했을_문자열_양_끝의_괄호가_제거되어야_한다() {
        // given
        final String given = "(1,2)";

        // when
        final String result = given.substring(1, 4);
        
        // then
        assertThat(result).isEqualTo("1,2");
    }
}
