import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}
