import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("1,2를 콤마로 split하면 1과 2를 가진 배열이 반환되어야 함")
    void test1() {
        String[] split = "1,2".split(",");

        assertThat(split).contains("1","2");
    }

    @Test
    @DisplayName("1, 을 콤마로 split하면 요소로 1 하나만 가진 배열이 반환되어야 함")
    void test2() {
        String[] split = "1,".split(",");

        assertThat(split).containsExactly("1");
    }

    @Test
    @DisplayName("1,2를 추출해야 함")
    void test3() {
        String s = "(1,2)";
        String substring = s.substring(s.indexOf("(")+1, s.indexOf(")"));

        assertThat(substring).isEqualTo("1,2");
    }

    @ParameterizedTest
    @CsvSource(value = {"0,a","1,b","2,c"},delimiter = ',')
    @DisplayName("문자열 범위 안에서 인덱스를 접근하면 정상적으로 문자를 가져옴")
    void test4(Integer index, Character answer) {
        assertThat("abc".charAt(index)).isEqualTo(answer);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1,3})
    @DisplayName("문자열 범위를 벗어나면 StringIndexOutOfBoundsException 이 발생함")
    void test5(Integer index) {

        assertThatThrownBy(()-> "abc".charAt(index)).isInstanceOf(StringIndexOutOfBoundsException.class).
                hasMessageContaining("String index out of range:");
    }


}
