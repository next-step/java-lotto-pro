package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {
    @Test
    void 로또_번호_확인() {
        assertThat(new LottoNumber(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)))
                .countHit(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)))).isEqualTo(6);
    }

    @Test
    void 로또_번호_확인_2() {
        assertThat(new LottoNumber(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)))
                .countHit(new ArrayList<>(Arrays.asList(1, 2, 3, 10, 20, 40)))).isEqualTo(3);
    }
}
