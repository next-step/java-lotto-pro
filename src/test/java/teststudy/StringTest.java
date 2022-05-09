package teststudy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void splitBasic() {
        String[] split = "1,2".split(",");
        assertThat(split).contains("1", "2");
    }

    @Test
    void splitOnlyOne() {
        String[] split = "1".split(",");
        assertThat(split).containsExactly("1");
    }
}
