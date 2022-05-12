package camp.nextstep.edu.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class WholeNumbersTest {

    @DisplayName("create 시 WholeNumber[] 를 입력 받는다.")
    @Test
    void createTest() {
        WholeNumbers numbers = new WholeNumbers(new WholeNumber("1"), new WholeNumber("2"));
        assertThat(numbers).isNotNull();
    }

    @DisplayName("sum 메소드를 통해서 더한 결과 값을 알수 있다.")
    @Test
    void sumTest() {
        WholeNumbers numbers = new WholeNumbers(new WholeNumber("1"), new WholeNumber("2"));
        assertThat(numbers.sum()).isEqualTo(3);
    }
}
