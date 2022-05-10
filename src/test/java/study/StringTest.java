package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void split(){
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void splitOneElement(){
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    void substring(){
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }
}
