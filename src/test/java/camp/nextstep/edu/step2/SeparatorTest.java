package camp.nextstep.edu.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SeparatorTest {

    @DisplayName("differentiate 함수를 통해서 구분자를 기준으로 값을 분리한다.")
    @Test
    void differentiateTest() {
        String[] strNumbers = Separator.differentiate("1,2");
        assertThat(strNumbers).containsExactly("1","2");
    }
}
