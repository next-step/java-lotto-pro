package study;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("문자열을 ,로 split하여 분리 되는지 검증")
    public void split_test() {
        //given
        String given = "1,2";
        String[] expectValue = {"1", "2"};
        //when
        String[] result = given.split(",");
        //then
        assertThat(result).contains("1","2");
        assertThat(result).containsExactly(expectValue);
    }

    @Test
    @DisplayName("(1,2)값이 주어 졌을때 subString()을 이용하여 ()을 제거")
    public void subString_test(){
        //given
        String given = "(1,2)";
        String expectValue = "1,2";
        //when
        String result = given.substring(1,given.length()-1);
        //then
        assertThat(result).isEqualTo(expectValue);
    }

    @Test
    @DisplayName("abc 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는지 검증")
    public void charAt_test(){
        //given
        String given = "abc";
        char[] expectValue = {'a', 'b', 'c'};

        //then & when
        assertThat(given.charAt(0)).isEqualTo(expectValue[0]);
        assertThat(given.charAt(1)).isEqualTo(expectValue[1]);
        assertThat(given.charAt(2)).isEqualTo(expectValue[2]);

    }
    @Test
    @DisplayName("charAt() 사용 시 StringIndexOutOfBoundsException 검증")
    public void charat_StringindexOutOfBoundsException_test(){
        //given
        String given = "abc";

        //when & then
        assertThatThrownBy(
                () -> {
                    given.charAt(given.length());
                }
        ).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("index out of range");
    }

}
