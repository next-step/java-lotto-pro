package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class StringTest {

    @Test
    @DisplayName("요구사항 1-1 : 1,2가 잘 분리 되는지 확인하는 테스트")
    public void divideTest() {
        String inputText = "1,2";
        String[] resultTexts = inputText.split(",");
        assertThat(resultTexts).contains("1", "2");
    }

    @Test
    @DisplayName("요구사항 1-2 : 1을 ,로 split 하였을 때 분리 되는지 확인하는 테스트")
    public void divideTest2() {
        String inputText = "1";
        String[] resultTexts = inputText.split(",");
        assertThat(resultTexts).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항 2 : (1,2)을 substring() method를 활용해 () 제거하고 1,2을 반환하는 테스트")
    public void removeBracketTest() {
        String inputText = "(1,2)";
        String result = inputText.substring(1, inputText.indexOf(')'));
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항 3-1 : abc에서 charAt()을 활용해 특정 위치 문자를 찾는 테스트")
    public void findTextTest() {
        String inputText = "abc";
        assertAll(
                () -> assertThat(inputText.charAt(0)).isEqualTo('a'),
                () -> assertThat(inputText.charAt(1)).isEqualTo('b'),
                () -> assertThat(inputText.charAt(2)).isEqualTo('c')
        );
    }

    @Test
    @DisplayName("요구사항 3-2 : abc에서 charAt()을 활용해 허용하는 범위 밖의 문자를 찾는 테스트")
    public void findTextErrorTest() {
        String inputText = "abc";
        int index = 4;
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    inputText.charAt(index);
                }).withMessageContaining("String index out of range: 4");
    }

}
