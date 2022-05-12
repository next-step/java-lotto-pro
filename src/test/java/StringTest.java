import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    @DisplayName("구분자가 있는 문자열을 split하기")
    void splitTest(){
        String input = "1,2";
        assertThat(input.split(",")).contains("1","2");
    }

    @Test
    @DisplayName("구분자가 없는 문자열을 split하기")
    void splitWithNoDelimiter(){
        String input = "1";
        assertThat(input.split(",")).containsExactly("1");
    }

    @Test
    @DisplayName("복수의 구분자를 통해 문자열을 split하기")
    void splitWithMultiDelimiter(){
        String input = "1,2:3";
        assertThat(input.split(",|:")).contains("1","2","3");
    }

    @Test
    @DisplayName("substring 테스트")
    void substringTest(){
        String input = "(1,2)";
        assertThat(input.substring(1,4)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 테스트")
    void charAtTest(){
        String input = "abc";
        assertThat(input.charAt(1)).isEqualTo('b');
    }

    @Test
    @DisplayName("charAt StringIndexOutOfBoundsException 발생 테스트")
    void charAtTestThrowsStringIndexOutOfBoundsException(){
        String input = "abc";
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(()->{
                    input.charAt(5);
        });
    }
}
