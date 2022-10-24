package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("String 클래스에 대한 학습테스트 요구사항 1 : , 이외로 끝나는 문자열에 대한 split 테스트")
    void split() {
        //given
        String input = "1,2";

        //when
        String[] result = input.split(",");

        //then
        assertThat(result).contains("1");
        assertThat(result).contains("2");
        assertThat(result).contains("1", "2");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("String 클래스에 대한 학습테스트 요구사항 1 : , 로 끝나는 문자열에 대한 split 테스트")
    void splitByCommaFinishedString(){
        //given
        String input = "1,2,";

        //when
        String[] result = input.split(",");

        //then
        assertThat(result).contains("1");
        assertThat(result).contains("2");
        assertThat(result).contains("1", "2");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("String 클래스에 대한 학습테스트 요구사항 2 : substring 을 통한 양 끝 소괄호 제거 테스트")
    void substring() {
        //given
        String sentence = "(1,2)";

        //when
        String result = sentence.substring(sentence.indexOf("(")+1, sentence.lastIndexOf(")"));

        //then
        assertThat(result).isEqualTo("1,2");
    }

    @ParameterizedTest
    @CsvSource(value={"0:a", "1:b", "2:c"}, delimiterString = ":")
    @DisplayName("String 클래스에 대한 학습테스트 요구사항 3 : charAt 을 통한 특정 위치의 문자를 조회하는 테스트")
    void charAtTest(int index, char result){
        assertThat("abc".charAt(index)).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "12", "king"})
    @DisplayName("String 클래스에 대한 학습테스트 요구사항 3 : charAt 을 통한 특정 위치의 문자를 조회할 때 발생하는 예외 테스트")
    void charAtTestByThrown(String input){
        assertThatThrownBy(() -> input.charAt(input.length()))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
