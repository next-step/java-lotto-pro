package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import org.junit.jupiter.api.Test;

class LottoFactoryTest {
    @Test
    void 로또_생성() {
        Lotto lotto = LottoFactory.create(() -> new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(lotto).isEqualTo(new Lotto(new LottoNumbers("1, 2, 3, 4, 5, 6")));
    }
}
