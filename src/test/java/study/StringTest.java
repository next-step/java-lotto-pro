package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1").contains("2");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void subString() {
        String result = "(1,2)".substring(1,4);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("charAt(): StringIndexOutOfBoundsException 예외 발생 확인")
    @Test
    void charAt() {
        String exampleString = "abc";
        int index = 3;

        /* hasMessageContaining: 포함된 문자 여부 확인 */
        assertThatThrownBy(() -> {
            try {
                exampleString.charAt(index);
            }catch (Exception e){
                throw new StringIndexOutOfBoundsException("Index: " + (exampleString.length()-1) + ", Size: " + exampleString.length());
            }
            exampleString.charAt(index);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("Index: 2, Size: 3");


        /* withMessageMatching: 모든 문자 일치 여부 확인 */
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> {
            try {
                exampleString.charAt(index);
            }catch (Exception e){
                throw new StringIndexOutOfBoundsException("Index: " + (exampleString.length()-1) + ", Size: " + exampleString.length());
            }
        }).withMessageMatching("Index: \\d+, Size: \\d+");

    }
}
