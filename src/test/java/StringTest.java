import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void split_one_and_two_test(){
        Assertions.assertThat("1,2".split(","))
            .hasSize(2)
            .containsExactly("1", "2");
    }

    @Test
    void split_one_only_test(){
        Assertions.assertThat("1".split(","))
            .hasSize(1)
            .containsExactly("1");
    }

    @Test
    void remove_parentheses_test(){
        Assertions.assertThat("(1,2)".substring(1,4)).isEqualTo("1,2");
    }

    @Test
    void char_at_test(){
        Assertions.assertThat(charAt("abc", 1)).isEqualTo('b');
    }

    @Test
    @DisplayName("charAt 위치가 벗어나면 Exception 발생하는 부분 테스트")
    void char_at_index_out_of_bound_exception_test(){
        Assertions.assertThatThrownBy(() -> charAt("abc", 5))
            .isInstanceOf(IndexOutOfBoundsException.class)
            .hasMessage("String index out of range: 5");
    }

    private char charAt(final String string, final int index){
        return string.charAt(index);
    }
}
