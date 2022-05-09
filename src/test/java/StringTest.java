import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("Comma를 이용한 숫자 분리 테스트")
    public void Split_numbers_by_using_comma() {
        String input = "1,2";
        String[] numbers = input.split(",");
        assertThat(numbers).contains("1").contains("2");
    }

    @Test
    @DisplayName("Comma를 이용한 단일 숫자 분리 테스트")
    public void Split_single_number_by_using_comma() {
        String input = "1,";
        String[] numbers = input.split(",");
        assertThat(numbers).containsExactly("1");
    }

    @Test
    @DisplayName("괄호 없는 부분 문자열 만들기")
    public void Create_substring_without_parentheses() {
        String input = "(1,2)";
        String result = input.substring(1, input.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열에서 문자 가져오기")
    public void Get_character_from_string() {
        String input = "abc";
        assertThat(input.charAt(0)).isEqualTo('a');
        assertThat(input.charAt(1)).isEqualTo('b');
        assertThat(input.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("문자열에서 문자 가져오기 인덱스 예외")
    public void Get_character_from_string_with_index_exception() {
        assertThatThrownBy(() -> {
            "abc".charAt(-1);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);

        assertThatThrownBy(() -> {
            "abc".charAt(4);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
