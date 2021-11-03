package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringTest {

    @Test
    @DisplayName("1,2를 ,로 String::split() 메소드를 활용해 1과 2로 분리할 수 있다.")
    void split() {
        final String given = "1,2";
        final String delimiter = ",";
        assertThat(given.split(delimiter)).containsExactly("1", "2");
    }

    @Test
    @DisplayName("1을 ,로 String::split() 메소드를 활용해 1로 분리할 수 있다.")
    void split2() {
        final String given = "1";
        final String delimiter = ",";
        assertThat(given.split(delimiter)).containsExactly("1");
    }

    @Test
    @DisplayName("(1,2)를 String::substring() 메소드를 활용해 \"()\"를 제거할 수 있다.")
    void substring() {
        final String given = "(1,2)";
        assertThat(given.substring(1, given.length() - 1)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("abc를 String::charAt() 메소드를 활용해 특정 위치의 문자를 가져올 수 있다.")
    void charAt() {
        final String given = "abc";
        assertThat(given.charAt(0)).isEqualTo('a');
        assertThat(given.charAt(1)).isEqualTo('b');
        assertThat(given.charAt(2)).isEqualTo('c');
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 3})
    @DisplayName("String::charAt() 메소드 인자로 음수나 해당 문자열 길이보다 큰 수를 사용할 수 없다.")
    void charAt2(final int index) {
        final String given = "abc";
        assertThatThrownBy(() -> given.charAt(index)).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
