package camp.nextstep.edu.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.step3.Hit.ONE;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class HitTest {

    @DisplayName("Hit 출력시 일치 갯수와 당청금이 출력된다")
    @Test
    void printTest() {
        assertThat(ONE.toString()).isEqualTo("1개 일치 (0원)");
    }
}
