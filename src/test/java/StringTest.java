import org.assertj.core.api.Assertions;
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
}
