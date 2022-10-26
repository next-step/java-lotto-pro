package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void split(){
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    void 괄호제거(){
        String result = "(1,2)".replaceAll("\\(","");
        result=result.replaceAll("\\)","");
        assertThat(result).isEqualTo("1,2");
    }
}
