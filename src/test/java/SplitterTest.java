import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import calculator.utils.Splitter;

import static org.assertj.core.api.Assertions.assertThat;

public class SplitterTest {
    @Test
    @DisplayName("기본 구분자인 쉼표(,)와 콜론(:)으로 문자열이 쪼개진다.")
    void checkStringSplitter() {
        assertThat(Splitter.splitString("1,2,3")).containsExactly("1", "2", "3");
        assertThat(Splitter.splitString("1:2")).containsExactly("1", "2");
        assertThat(Splitter.splitString("1:2,3:4")).containsExactly("1", "2", "3", "4");
    }

    @Test
    @DisplayName("커스텀 구분자(//커스텀구분자\\n)로 문자열이 쪼개진다.")
    void checkStringSplitterWithCustomDelimiters() {
        assertThat(Splitter.splitString("//-\n1-2-3")).containsExactly("1", "2", "3");
        assertThat(Splitter.splitString("//#\n1#2#3")).containsExactly("1", "2", "3");
    }
}
