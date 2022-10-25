package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringClassTest {

    @Test
    @DisplayName("'1,2'을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인")
    void splitTest_1() {
        String beforeString = "1,2";
        String[] afterStringArray = beforeString.split(",");

        assertThat(afterStringArray).contains("1", "2");
        assertThat(afterStringArray).hasSize(2);
        assertThat(afterStringArray).containsExactly("1", "2");
    }

    @Test
    @DisplayName("'1'을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인")
    void splitTest_2() {
        String beforeString = "1";
        String[] afterStringArray = beforeString.split(",");

        assertThat(afterStringArray).contains("1");
        assertThat(afterStringArray).hasSize(1);
        assertThat(afterStringArray).containsExactly("1");
    }

    @Test
    @DisplayName("'(1,2)' 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 '1,2'를 반환되는지 확인")
    void subStringTest() {
        String beforeString = "(1,2)";
        String afterSubString = beforeString.substring(1, beforeString.length() -1);

        assertThat(afterSubString).isEqualTo("1,2");
    }

    @Test
    @DisplayName("'abc' 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는지 확인" +
            "charAt() 메소드를 사용할 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는지 확인")
    void charAtTest() {
        String beforeString = "abc";

        assertThat(beforeString.charAt(0)).isEqualTo('a');
        assertThat(beforeString.charAt(1)).isEqualTo('b');
        assertThat(beforeString.charAt(2)).isEqualTo('c');

        assertThatThrownBy(() -> {
            beforeString.charAt(beforeString.length());
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }

}
