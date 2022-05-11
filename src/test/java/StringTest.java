import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    @DisplayName("split 1,2 분리 확인")
    public void splitTest() {
        assertThat("1,2".split(",")).contains("1", "2");
    }

    @Test
    @DisplayName("split 문자 비포함시 split 결과 확인")
    public void splitContainsExactlyTest() {
        assertThat("1".split(",")).containsExactly("1");
    }

    @Test
    @DisplayName("substring으로 ()괄호 제거 확인")
    public void subStringTest() {
        assertThat("(1,2)".substring(1, 4)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 확인")
    public void charAtTest() {
        assertThat("abc".charAt(0)).isEqualTo('a');
    }

    @Test
    @DisplayName("StringIndexOutOfBoundsExceptions 확인 테스트")
    public void StringIndexOutOfBoundsExceptionsTest() {
        assertThatThrownBy(() -> {
            "abc".charAt(4);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
