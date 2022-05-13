package study.lotto.automatic.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoDrawTest {
    @Test
    @DisplayName("당첨 번호를 자동으로 생성한다.")
    void 당첨_번호_생성() {
        LottoDraw lottoDraw = new LottoDraw(new AutomaticLottoGenerator());
        assertThat(lottoDraw).isNotNull();
    }

    @Test
    @DisplayName("당첨 번호를 사용자가 생성한다.")
    void 당첨_번호_사용자_생성() {
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoDraw lottoDraw = new LottoDraw(lottoNumbers);
        assertThat(lottoDraw).isNotNull().isEqualTo(new LottoDraw(lottoNumbers));
    }
}
