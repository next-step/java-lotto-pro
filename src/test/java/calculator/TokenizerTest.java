package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TokenizerTest {

    Tokenizer customTokenizer;
    Tokenizer defaultTokenizer;

    @BeforeEach
    void setUp() {
        customTokenizer = new Tokenizer("//;\n1;2;3");
        defaultTokenizer = new Tokenizer("1,2:3");
    }

    @Test
    void 커스텀_구분자가_있으면_가져온다() {
        assertThat(customTokenizer.isDelimiter(";")).isTrue();
    }

    @Test
    void 커스텀_구분자를_통해_문자열을_나눈다() {
        assertThat(customTokenizer.split()).isEqualTo(new String[]{"1","2","3"});
    }

    @Test
    void 커스텀_구분자가_없으면_기본_구분자를_가져온다() {
        assertThat(defaultTokenizer.isDelimiter("[,:]")).isTrue();
    }

    @Test
    void 커스텀_구분자가_없으면_기본_구분자로_문자열을_나눈다() {
        assertThat(defaultTokenizer.split()).isEqualTo(new String[]{"1","2","3"});
    }
}
