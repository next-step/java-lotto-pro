import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void split() {
        //요구사항 1번
        String one = "1";
        String oneAndTwo = "1,2";

        String [] arraysForOne = one.split(",");
        assertThat(arraysForOne).contains("1");
        assertThat(arraysForOne).containsExactly("1"); // 순서 포함해서 정확하게 일치

        String [] arraysForOneAndTwo = oneAndTwo.split(",");
        assertThat(arraysForOneAndTwo).contains("1", "2");
        assertThat(arraysForOneAndTwo).containsExactly("1", "2"); // 순서 포함해서 정확하게 일치
    }

    @Test
    void substring() {
        //요구사항 2번
        String example = "(1,2)";
        example = example.substring(1, 4);
        assertThat(example).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt Throw IndexOutOfBoundsException Test")
    void charAt_Exception() {
        //요구사항 3번
        assertThatThrownBy(() -> {
            String example = "abc";
            example.charAt(4); //StringIndexOutOfBoundsException: String index out of range: 4
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
            .hasMessageContaining("index");
    }
}
