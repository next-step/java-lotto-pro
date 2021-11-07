package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @Test
    @DisplayName("해당 로또가 얼마가 당첨되는지 확인")
    void 로또번호_결과() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        lotto.judgeRank(LottoNumbers.valueOf(Arrays.asList(3,4,5,6,7,8)));
        assertThat(lotto.getWinningRank().getReward()).isEqualTo(50000);
    }

}
