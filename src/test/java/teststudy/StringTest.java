package teststudy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void splitBasic() {
        String input = "1,2";
        String[] split = input.split(",");
        assertThat(split).contains("1", "2");
    }

    @Test
    void splitOnlyOne() {
        String input = "1";
        String[] split = input.split(",");
        assertThat(split).containsExactly("1");
    }

    @Test
    void subStringTest() {
        String input = "(1,2)";
        String substring = input.substring(1, 4);
        assertThat(substring).isEqualTo("1,2");
    }


}
