package teststudy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    @DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.")
    void splitBasic() {
        String input = "1,2";
        String[] split = input.split(",");
        assertThat(split).contains("1", "2");
    }

    @Test
    @DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.")
    void splitOnlyOne() {
        String input = "1";
        String[] split = input.split(",");
        assertThat(split).containsExactly("1");
    }

    @Test
    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하도록 구현한다.")
    void subStringTest() {
        String input = "(1,2)";
        String substring = input.substring(1, 4);
        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트")
    void charAtBasicTest() {
        String input = "abc";
        assertThat(input.charAt(0)).isEqualTo('a');
        assertThat(input.charAt(1)).isEqualTo('b');
        assertThat(input.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생")
    void charAtOutOfBoundTest() {
        String input = "abc";
        int outOfIndex = 4;

        assertThatThrownBy(() -> {
            input.charAt(outOfIndex);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: " + outOfIndex);

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                            input.charAt(outOfIndex);
                        }).withMessageMatching("String index out of range: \\d+");
    }


}
