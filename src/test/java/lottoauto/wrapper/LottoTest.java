package lottoauto.wrapper;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoTest {
    Lotto lotto = new Lotto();
    @Test
    void 숫자_생성_테스트() {
        assertThat(lotto.getLotto()).hasSize(6);
    }
}
