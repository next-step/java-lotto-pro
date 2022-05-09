package step1;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    //요구사항 1-1
    @DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 분리")
    @Test
    void split_1() {
        String str = "1,2";

        String[] result = str.split(",");

        assertThat(result).contains("1", "2");
    }

    //요구사항 1-2
    @DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열 반환")
    @Test
    void split_2() {
        String given = "1";

        String[] result = given.split(",");

        assertThat(result).containsExactly("1");
    }

    //요구사항 2
    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환")
    @Test
    void substring() {
        String given = "(1,2)";
        int beginIndex = given.indexOf("(") + 1;
        int endIndex = given.indexOf(")");

        String result = given.substring(beginIndex, endIndex);

        assertThat(result).isEqualTo("1,2");
    }

    //요구사항 3-1
    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자 가져오기")
    @Test
    void charAt_1() {
        String given = "abc";

        char result = given.charAt(1);

        assertThat(result).isEqualTo('b');
    }

    //요구사항 3-2
    @DisplayName("String의 charAt() 메소드 사용 시 위치 값을 벗어나면 StringIndexOutOfBoundsException 발생")
    @Test
    void charAt_2() {
        String given = "abc";

        assertThatThrownBy(() -> given.charAt(given.length() + 1))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range");
    }
}
