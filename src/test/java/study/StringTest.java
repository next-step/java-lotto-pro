package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    @DisplayName("1,2 문자열을 , 로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트 구현")
    public void StringTest(){
        //given
        String given = "1,2";
        String[] expected = {"1","2"};
        //when then
        assertThat(given.split(",")).containsExactly(expected);
    }
}
