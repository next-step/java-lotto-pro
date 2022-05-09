import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    @DisplayName("Comma를 이용한 숫자 분리 테스트")
    public void Split_numbers_by_using_comma() {
        String[] numbers = "1,2".split(",");
        assertThat(numbers).contains("1").contains("2");
    }

    @Test
    @DisplayName("Comma를 이용한 단일 숫자 분리 테스트")
    public void Split_single_number_by_using_comma() {
        String[] numbers = "1,".split(",");
        assertThat(numbers).containsExactly("1");
    }
}
