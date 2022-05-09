package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * String 클래스에 대한 학습 테스트
 */
public class StringTest {

    @Test
    @DisplayName("contains, containsExactly 를 활용한 split 메소드 테스트")
    public void split() {
        String regex = ",";

        assertThat("1,2".split(regex)).contains("1", "2");

        assertThat("1".split(regex)).containsExactly("1");
    }

    @Test
    @DisplayName("substring 메소드를 활용해 ()을 제거한 값이 정확한지 테스트")
    public void subString() {
        String word = "(1,2)";

        String result = word.substring(word.indexOf('(') + 1, word.indexOf(')'));

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt IndexOutOfBoundsException 테스트")
    public void charAt() {
        String word = "a,b,c";
        int[] borderIndex = {-1, word.length()};

        for (int index : borderIndex) {
            Assertions.assertThatThrownBy(() -> {
                        word.charAt(index);
                    })
                    .isInstanceOf(IndexOutOfBoundsException.class)
                    .hasMessageContaining("String index out of range: " + index);
        }
    }
}
