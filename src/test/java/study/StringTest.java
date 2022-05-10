package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    @DisplayName("요구사항 1-1. '1,2'을 ,로 split 했을 때, 1과 2로 분리된다.")
    void split_by_comma_success_test() {
        String words = "1,2";
        String[] splitWords = words.split(",");
        assertThat(splitWords).hasSize(2).contains("1", "2");
    }

    @Test
    @DisplayName("요구사항 1-2. '1'을 ,로 split 했을 때, 1만을 포함하는 배열이 반환된다.")
    void split_by_comma_test() {
        String words = "1";
        String[] splitWords = words.split(",");
        assertThat(splitWords).hasSize(1).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항 2. '(1,2)' 값이 주어졌을 때, String 의 substring() 메소드를 활용해 () 을 제거하고 '1,2' 를 반환한다.")
    void substring_test() {
        String words = "(1,2)";
        String subWords = words.substring(1, words.length() - 1);
        assertThat(subWords).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항 3-1. 'abc' 값이 주어졌을 때 charAt() 활용해서 특정 위치의 문자를 가져온다.")
    void charAt_test() {
        String words = "abc";
        char firstChar = words.charAt(0);
        char secondChar = words.charAt(1);
        char lastChar = words.charAt(2);
        assertThat(firstChar).isEqualTo('a');
        assertThat(secondChar).isEqualTo('b');
        assertThat(lastChar).isEqualTo('c');
    }

    @Test
    @DisplayName("요구사항 3-2. charAt() 활용해서 특정 위치의 문자를 가져올 때, 위치 값이 벗어나면 StringIndexOutOfBoundsException 이 발생한다.")
    void indexOutOfBoundsException_test() {
        assertThatThrownBy(() -> {
            String words = "abc";
            char indexOutOfBounds = words.charAt(words.length());
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
