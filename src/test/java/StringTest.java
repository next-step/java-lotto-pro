import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    @DisplayName("String을 ,로 split했을 때 문자열이 배열로 잘 구분된다.")
    void checkSplit() {
        String separator = ",";

        assertThat("1,2".split(separator)).containsExactly("1", "2");
        assertThat("1,".split(separator)).containsExactly("1");
    }
}
