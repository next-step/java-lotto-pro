import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.Splitter;

import static org.assertj.core.api.Assertions.assertThat;

public class SplitterTest {
    @Test
    @DisplayName("쉼표(,)와 콜론(:)으로 문자열이 쪼개진다.")
    void checkStringSplitter() {
        assertThat(Splitter.split("1,2,3")).containsExactly("1", "2", "3");
    }
}
