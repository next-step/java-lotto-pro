package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("split 메소드를 이용한 기본적인 문자열 쪼개기 검증")
    public void 문자열_쪼개기_검증() throws Exception{
        String[] split = "1,2".split(",");
        assertThat(split).containsExactly("1","2");
    }

    @Test
    @DisplayName("split 메소드를 이용한 기본적인 문자열 쪼개기 검증")
    public void 문자열_쪼개기_검증2() throws Exception{
        String[] split = "1".split(",");
        assertThat(split).contains("1");
    }

}
