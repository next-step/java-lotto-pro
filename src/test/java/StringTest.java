import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    void 스트링_콤마_나누기_적용() {
        String str = "1,2";
        String[] token = str.split(",");
        assertThat(token).contains("1");
        assertThat(token).contains("2");
        assertThat(token).containsExactly("1", "2");
    }

    @Test
    void 스트링_콤마_나누기_하나만_적용_예외() {
        String str = "1,";
        String[] token = str.split(",");
        assertThat(token).contains("1");
        assertThat(token).containsExactly("1");
    }

    @Test
    void 스트링_특정위치_값_가져오기() {
        String str = "abc";
        assertThat(str.charAt(0)).isSameAs('a');
        assertThat(str.charAt(1)).isSameAs('b');
        assertThat(str.charAt(2)).isSameAs('c');
    }
}
