import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    @DisplayName("문자열을 쉼표(,)로 스플릿 하여 배열을 리턴한다.")
    void splitString() {
        String input1 = "1,2";
        String[] result1 = input1.split(",");
        Assertions.assertThat(result1).containsExactly("1", "2");

        String input2 = "1";
        String[] result2 = input2.split(",");
        Assertions.assertThat(result2).contains("1");

    }

}
