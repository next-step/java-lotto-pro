package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * 스트링 클래스 학습 테스트
 * */
public class StringTest {
    private String data;

    @BeforeEach
    void setUp() {
        data = "abc";
    }


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

    @ParameterizedTest
    @CsvSource(value = {"0:a","1:b", "2:c"}, delimiter = ':')
    @DisplayName("특정위치의 문자열을 가져온다.")
    void charAt(int index, char result){
        assertThat(data.charAt(index)).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 4})
    @DisplayName("chatAt 메서드의 벗어난 문자를 찾으면 StringIndexOutOfBoundsException 발생한다.")
    void charAtNoSearch(int index) {
        assertThatThrownBy(() -> data.charAt(index))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range");
    }
}
