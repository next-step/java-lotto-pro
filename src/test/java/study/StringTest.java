package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    @DisplayName("\"1,2\"을 , 로 split 했을 때 1과 2로 잘 분리되는지 확인하는 테스트")
    public void split_successForMoreThanOneElements() {
        String testStr = "1,2";
        String[] testArr = testStr.split(",");

        assertThat(testArr).containsExactly("1", "2");
        assertThat(testArr).contains("2", "1");
    }

    @Test
    @DisplayName("\"1\"을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 테스트")
    public void split_successForOneElements() {
        String testStr = "1";
        String[] testArr = testStr.split(",");

        assertThat(testArr).containsExactly("1");
        assertThat(testArr).contains("1");
    }

    @Test
    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 () 을 제거하고 \"1,2\"를 반환하는지에 대한 테스트")
    public void substring_success() {
        String testStr = "(1,2)";

        String resultStr = testStr.substring(1, testStr.length() - 1);
        assertThat(resultStr).isEqualTo("1,2");
    }

    @Test
    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 테스트")
    public void chatAt_successForValidIndex() {
        String testStr = "abc";

        assertThat(testStr.charAt(0)).isEqualTo('a');
        assertThat(testStr.charAt(1)).isEqualTo('b');
        assertThat(testStr.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 테스트")
    public void chatAt_ThrowsStringIndexOutOfBoundsExceptionForInvalidIndex() {
        String testStr = "abc";

        assertThatThrownBy(() -> testStr.charAt(3)).isInstanceOf(StringIndexOutOfBoundsException.class)
            .hasMessage("String index out of range: 3");

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> testStr.charAt(-1))
            .withMessage("String index out of range: -1");
    }

}
