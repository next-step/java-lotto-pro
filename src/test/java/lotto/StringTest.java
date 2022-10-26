package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringTest {

    @DisplayName("String - split 메서드 테스트")
    @Test
    void split() {
        //given:
        String source = "1,2";
        //when:
        String[] result = source.split(",");
        //then:
        assertThat(result).containsSequence("1", "2");
    }

    @DisplayName("String - substring 메서드 테스트")
    @Test
    void substring() {
        //given:
        String source = "(1,2)";
        //when:
        int beginIndex = source.indexOf("(") + 1;
        int endIndex = source.indexOf(")");
        String result = source.substring(beginIndex, endIndex);
        //then:
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("String - charAt 메소드 StringIndexOutOfBoundsException 테스트")
    @Test
    void charAt() {
        assertThatThrownBy(() ->
        {
            String source = "abc";
            source.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
