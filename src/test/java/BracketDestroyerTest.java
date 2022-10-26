import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BracketDestroyerTest {

    @Test
    void 괄호_제외하고_사이_문자열_반환() {
        BracketDestroyer bracketDestroyer = new BracketDestroyer("(1,2)");
        assertThat(bracketDestroyer.toString()).isEqualTo("1,2");
    }

    @Test
    void 괄호_제외하고_문자열_반환_예외() {
        String onlyOpenBracket = "(1,2";
        String onlyCloseBracket = "1,2)";
        assertThat(new BracketDestroyer(onlyOpenBracket).toString()).isEqualTo("1,2");
        assertThat(new BracketDestroyer(onlyCloseBracket).toString()).isEqualTo("1,2");
    }
}
