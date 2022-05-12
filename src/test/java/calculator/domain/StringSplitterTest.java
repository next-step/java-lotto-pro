package calculator.domain;

import java.util.regex.Pattern;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringSplitterTest {

    private String delimiter = ",|:";
    private Pattern pattern = Pattern.compile("//(.)\n(.*)");
    private StringSplitter splitter;

    @BeforeEach
    void setUp() {
        splitter = new StringSplitter(",|:", Pattern.compile("//(.)\n(.*)"));
    }

    @Test
    @DisplayName("쉼표 구분자 테스트")
    void 쉼표_구분자() {
        assertThat(splitter.split("1,2")).containsExactly("1", "2");
    }

    @Test
    @DisplayName("콜론 구분자 테스트")
    void 콜론_구분자() {
        assertThat(splitter.split("1:2")).containsExactly("1", "2");
    }

    @Test
    @DisplayName("커스텀 구분자 테스트")
    void 커스텀_구분자() {
        assertThat(splitter.split("//;\n1;2;3")).containsExactly("1", "2", "3");
    }

    
}