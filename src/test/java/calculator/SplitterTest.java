package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SplitterTest {
    @Test
    @DisplayName("쉼표(,) 구분자로 숫자 2개 입력 시 분리 잘되는지 확인")
    public void splitNumbers_쉼표구분자() throws Exception {
        List<String> result = Splitter.splitNumbers("1,2");
        assertThat(result).contains("1", "2");
    }

    @Test
    @DisplayName("쉼표(,) 또는 콜론(:) 구분자로 숫자 입력 시 분리 잘되는지 확인")
    public void splitNumbers_쉼표_또는_콜론_구분자() throws Exception {
        List<String> result = Splitter.splitNumbers("1,2:3");
        assertThat(result).contains("1", "2", "3");
    }

    @Test
    @DisplayName("커스텀 구분자로 숫자 입력 시 분리 잘되는지 확인")
    public void splitNumbers_custom_구분자() throws Exception {
        List<String> result = Splitter.splitNumbers("//;\n1;2;3");
        assertThat(result).contains("1", "2", "3");
    }
}
