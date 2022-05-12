package camp.nextstep.edu.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {

    @DisplayName("1부터 45까지 정수 값만 가진다")
    @Test
    void createTest() {
        LottoNumber one = new LottoNumber(1);
        assertThat(one).isEqualTo(new LottoNumber(1));
    }
}
