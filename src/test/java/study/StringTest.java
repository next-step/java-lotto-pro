package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @DisplayName("split 은 구분자를 기준으로 분리한 배열을 반환한다.")
    @Test
    void splitTest() throws Exception {
        //given
        String input = "1,2";
        String delimiter = ",";
        //when
        String[] result = input.split(delimiter);
        //then
        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("split 은 단건의 데이터도 배열로 반환한다")
    @Test
    void splitSingleTest() throws Exception {
        //given
        String input = "1";
        String delimiter = ",";
        //when
        String[] result = input.split(delimiter);
        //then
        assertThat(result).containsOnly("1");
        assertThat(result).hasSize(1);
    }
}
