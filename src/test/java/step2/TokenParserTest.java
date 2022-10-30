package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TokenParserTest {
    @Test
    @DisplayName("쉼표 구분자로 문자열 분리")
    void split_쉼표구분자() throws Exception {
        String[] data = TokenParser.split("1,2,3");
        assertThat(data).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("쉼표 또는 콜론 구분자로 문자열 분리")
    void split_쉼표_또는_콜론_구분자() throws Exception {
        String[] data = TokenParser.split("1,2:3");
        assertThat(data).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자로 문자열 분리")
    void split_custom_구분자() throws Exception {
        String[] data = TokenParser.split("//@\n1@2@3");
        assertThat(data).containsExactly("1", "2", "3");
    }
}
