package calculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringSplitterTest {


    @Test
    void 쉼표_구분자() {
        assertThat(StringSplitter.split("1,2")).containsExactly("1", "2");
    }

    @Test
    void 콜론_구분자() {
        assertThat(StringSplitter.split("1:2")).containsExactly("1", "2");
    }

    @Test
    void 커스텀_구분자() {
        assertThat(StringSplitter.split("//;\n1;2;3")).containsExactly("1", "2", "3");
    }


}