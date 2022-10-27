package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringSplitterTest {

    @Test
    @DisplayName("숫자 한개를 커스텀 구분자를 사용한 경우에도 정상 반환하는지 테스트")
    public void stringSplitterTest(){
        //given
        String given = "//;\n1";
        String[] expected = {"1"};
        //when
        String[] actual = StringSplitter.split(given);
        //then
        assertThat(actual).isEqualTo(expected);
    }

}