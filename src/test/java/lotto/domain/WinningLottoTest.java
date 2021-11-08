package lotto.domain;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * packageName : lotto.domain
 * fileName : WinningLottoTest
 * author : haedoang
 * date : 2021/11/07
 * description : 로또 당첨 번호(보너스 번호 있음) 클래스
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
public class WinningLottoTest {
    private int bonusNumber = 7;

    @Test
    @DisplayName("유효한 로또번호 생성하기")
    public void T1_create() {
        //GIVEN
        WinningLotto winningLotto = WinningLotto.valueOf("1,2,3,4,5,6", LottoNumber.valueOf(bonusNumber));
        //THEN
        assertThat(winningLotto.has(LottoNumber.valueOf(1))).isTrue();
        assertThat(winningLotto.has(LottoNumber.valueOf(6))).isTrue();
        assertThat(winningLotto.has(LottoNumber.valueOf(13))).isFalse();
        assertThat(winningLotto.isBonus(LottoNumber.valueOf(bonusNumber))).isTrue();
        assertThat(winningLotto.isBonus(LottoNumber.valueOf(LottoNumber.MAX_NUMBER))).isFalse();
    }


}
