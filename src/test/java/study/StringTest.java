package study;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * packageName : study
 * fileName : StringTest
 * author : haedoang
 * date : 2021/11/01
 * description : String 클래스 학습 테스트
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StringTest {

    //"1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
    @Test
    @Order(1)
    @DisplayName("요구사항1_split메소드는_문자열을_분리한다")
    public void splitTest1() {
        //GIVEN
        String given = "1,2";
        //WHEN
        String[] result = given.split(",");
        //THEN
        assertThat(result).contains("1","2"); //contains 포함 여부를 확인한다.
        assertThat(result.length).isEqualTo(2);
        assertThat(result).containsExactly("1","2"); //containsExactly 배열의 순서 및 값을 확인한다.
    }

    //"1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
    @Test
    @Order(2)
    @DisplayName("요구사항1_split메소드는_문자열을_분리하여_배열로_반환한다")
    public void splitTest2() {
        //GIVEN
        String given = "1";
        //WHEN
        String[] result = given.split(",");
        //THEN
        assertThat(result).contains("1");
        assertThat(result.length).isEqualTo(1);
    }

    //"(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
    @Test
    @Order(3)
    @DisplayName("요구사항2_substring메소드는_문자열을_자른다")
    public void substringTest() {
        //GIVEN
        String given = "(1,2)";
        //WHEN
        String result = given.substring(1, given.length()-1);
        //THEN
        assertThat(result).isEqualTo("1,2");
    }

    //"abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
    @Test
    @Order(4)
    @DisplayName("요구사항3_charAt_메소드는_문자열의_인덱스값의_문자를_반환한다")
    public void charAtTest() {
        //GIVEN
        String given = "abc";
        //WHEN
        char result = given.charAt(0);
        char result2 = given.charAt(1);
        char result3 = given.charAt(2);
        //THEN
        assertThat(String.valueOf(result)).isEqualTo("a");
        assertThat(String.valueOf(result2)).isEqualTo("b");
        assertThat(String.valueOf(result3)).isEqualTo("c");
    }

    //String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
    @Test
    @Order(5)
    @DisplayName("요구사항3_charAt_메소드는_위치값을_벗어난_경우_예외가_발생한다")
    public void charAtTestError() {
        //Given
        String given = "abc";
        //THEN
        assertThatThrownBy(() -> given.charAt(4))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range:");
    }






}
