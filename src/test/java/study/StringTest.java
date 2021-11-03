package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("String 클래스에 대한 학습 테스트")
public class StringTest {

    final static String SEPARATOR = ",";

    @DisplayName("요구사항 1-1 - \"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.")
    @ParameterizedTest
    @ValueSource(strings = "1,2")
    public void 요구사항1_1(String input) {
        assertThat(input.split(SEPARATOR)).containsExactly("1", "2");
    }

    @DisplayName("요구사항 1-2 - \"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.")
    @ParameterizedTest
    @ValueSource(strings = "1")
    public void 요구사항1_2(String input) {
        assertThat(input.split(SEPARATOR))
                .contains("1")
                .containsExactly("1");
    }

    @DisplayName("요구사항 2 - \"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하도록 구현한다.")
    @ParameterizedTest
    @ValueSource(strings = "(1,2)")
    public void 요구사항2(String input) {
        assertThat(input.substring(1, input.length() - 1)).isEqualTo("1,2");
    }

    @DisplayName("요구사항 3 - \"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.\n" +
            "String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.\n" +
            "JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.")
    @ParameterizedTest
    @ValueSource(strings = "abc")
    public void 요구사항3(String input) {
        for (int i = 0; i <= input.length(); i++) {
            int index = i;

            if (index < input.length()) {
                assertThat(input.charAt(index)).isEqualTo((char) (97 + index));
            } else {
                assertThatThrownBy(() -> input.charAt(index))
                        .isInstanceOf(StringIndexOutOfBoundsException.class)
                        .hasMessageContaining("String index out of range");
            }
        }
    }

}
