import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    private static final String COMMA = ",";
    private static final String OPEN_PARENTHESES = "(";
    private static final String CLOSE_PARENTHESES = ")";

    @Test
    @DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.")
    void 문자열_split_테스트(){
        String inputStr = "1,2";
        String[] splitArr = inputStr.split(COMMA);

        assertThat(splitArr).contains("1");
        assertThat(splitArr).contains("2");
        assertThat(splitArr).containsExactly("1", "2");
    }

    @Test
    @DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.")
    void 단일문자열_split_테스트(){
        String inputStr = "1";
        String[] splitArr = inputStr.split(COMMA);

        assertThat(splitArr).contains("1");
        assertThat(splitArr).containsExactly("1");
    }

    @Test
    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하도록 구현한다.")
    void 문자열_substring_테스트(){
        String inputStr = "(1,2)";
        int openPosition = inputStr.indexOf(OPEN_PARENTHESES);
        int closePosition = inputStr.indexOf(CLOSE_PARENTHESES);

        String substringStr = inputStr.substring(openPosition + 1, closePosition);

        assertThat(substringStr).isEqualTo("1,2");
    }

    @Test
    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.")
    void 문자열_charAt_테스트(){
        String inputStr = "abc";

        assertThat(inputStr.charAt(0)).isEqualTo('a');
        assertThat(inputStr.charAt(1)).isEqualTo('b');
        assertThat(inputStr.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.")
    void 문자열_charAt_예외_테스트(){
        String inputStr = "abc";

        assertThatThrownBy(() -> {
            inputStr.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
