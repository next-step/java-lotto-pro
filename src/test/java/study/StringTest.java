package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 스트링 클래스 학습 테스트
 * */
public class StringTest {

    @Test
    @DisplayName("문자열 split 테스트")
    void split() {
        //1,2"을 ,로 split 했을 때 1과 2로 분리
        assertThat("1,2".split(",")).contains("1", "2");
        //1,2"을 ,로 split 했을 때 1로 분리
        assertThat("1".split(",")).containsExactly("1");
    }

    @Test
    @DisplayName("문자열 substring 테스트 : 괄호를 지운값만 반환한다.")
    void substring() {
        String word = "(1,2)";
        //괄호를 지우고 1,2만 반환한다.
        String result = word.substring(word.indexOf("(") + 1, word.indexOf(")"));
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정위치의 문자열을 가져오고 벗어난 문자를 찾으면 StringIndexOutOfBoundsException 발생한다.")
    void charAt(){
        String data = "abc";
        //각 값의 경계 값
        int[] boundary = {-1, 4};
        assertThat(data.charAt(0)).isEqualTo('a');

        for (int boundaryValue : boundary) {
            assertThatThrownBy(() -> data.charAt(boundaryValue))
                    .isInstanceOf(StringIndexOutOfBoundsException.class)
                    .hasMessageContaining("String index out of range");
        }
    }
}
