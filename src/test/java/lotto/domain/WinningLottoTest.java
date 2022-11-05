package lotto.domain;

import static lotto.domain.WinningLotto.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    private WinningLotto winningLotto;
    private Lotto lotto;

    @BeforeEach
    void beforeEach(){
        winningLotto = create(
                Lotto.create(Arrays.asList(1,2,3,4,5,6)), LottoNumber.create(7)
        );
        lotto = Lotto.create(Arrays.asList(1, 2, 3, 4, 5, 7));
    }

    @Test
    @DisplayName("당첨 로또와 구매 로또의 비교결과를 반환한다.")
    void returnResult(){
        LottoWinningRank rank = winningLotto.getLottoRank(lotto);
        assertThat(rank).isEqualTo(LottoWinningRank.SECOND);
    }

    @Test
    @DisplayName("보너스 번호 중복 예외 테스트")
    void bonusExceptionTest(){
        Lotto basic = Lotto.create(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber bonus = LottoNumber.create(6);

        assertThatIllegalArgumentException().isThrownBy(
                () -> WinningLotto.create(basic, bonus)
        );
    }
}
