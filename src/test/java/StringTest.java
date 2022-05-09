import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    @DisplayName("문자열 '1,2'를 ','로 split 했을 때 '1'과 '2'로 문자열이 분리되어야 한다")
    void when_split_string_should_return_array_with_two_elements() {
        // given
        final String given = "1,2";

        // when
        final String[] result = given.split(",");

        // then
        assertThat(result).contains("1", "2");
    }

    @Test
    @DisplayName("문자열 '1'을 ','로 split 했을 때 1만을 포함하는 배열이 반환되어야 한다")
    void when_split_string_should_return_array_with_only_one_element() {
        // given
        final String given = "1";

        // when
        final String[] result = given.split(",");

        // then
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("문자열 '(1,2)를 substring 했을 떄 문자열 양 끝의 괄호가 제거되어야 한다")
    void when_substring_string_should_return_string_without_braces() {
        // given
        final String given = "(1,2)";

        // when
        final String result = given.substring(1, 4);

        // then
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열 'abc'에 charAt 했을 때 파라미터와 같은 위치의 문자가 반환되어야 한다")
    void when_call_charAt_should_return_char() {
        // given
        final String given = "abc";
        final Map<Integer, Character> indexValueMap = new HashMap<>();
        indexValueMap.put(0, 'a');
        indexValueMap.put(1, 'b');
        indexValueMap.put(2, 'c');

        // when and then
        for (final int index : indexValueMap.keySet()) {
            assertThat(given.charAt(index)).isEqualTo(indexValueMap.get(index));
        }
    }

    @Test
    @DisplayName("문자열 'abc'에 charAt 했을 때 파라미터가 문자열 길이보다 크면 StringIndexOutOfBoundsException을 발생시킨다")
    void when_call_charAt_with_parameter_exceeding_length_should_throw_StringIndexOutOfBoundsException() {
        // given
        final String given = "abc";
        final int indexExceedingLength = 3;

        // when and then
        assertThatThrownBy(() -> given.charAt(indexExceedingLength))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
