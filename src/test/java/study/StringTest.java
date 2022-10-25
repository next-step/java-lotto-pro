package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("1,2 문자열을 , 로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트 구현")
    public void stringTest_split(){
        //given
        final String given = "1,2";
        final String[] expected = {"1","2"};

        //when & then
        assertThat(given.split(",")).containsExactly(expected);
    }

    @Test
    @DisplayName("(1,2) 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 1,2 반환하도록 구현")
    public void stringTest_substring(){
        //given
        final String given = "(1,2)";
        final String expected = "1,2";

        //when & then
        assertThat(given.substring(1,given.length()-1)).isEqualTo(expected);
    }
    
    @Test
    @DisplayName("abc 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트 구현")
    public void stringTest_charAt(){
        //given
        final String given = "abc";
        final char[] expected = {'a', 'b', 'c'};

        //then
        for(int i=0; i<given.length(); i++){
            assertThat(given.charAt(i)).isEqualTo(expected[i]);
        }
    }

    @Test
    @DisplayName("String의 charAt 메소드를 활용해 특정 위치 문자를 가져올 때 위치값 벗어나면 StringIndexOutOfBoundsException 발생에 대한 학습테스트 구현")
    public void stringTest_charAt_OutOfBoundsException(){
        //given
        final String given = "abc";

        //when & then
        assertThatThrownBy(
            () -> {
                given.charAt(given.length());
            }
        ).isInstanceOf(IndexOutOfBoundsException.class)
         .hasMessageContaining("out of range")
         .hasMessageContaining("Index:");
    }



}
