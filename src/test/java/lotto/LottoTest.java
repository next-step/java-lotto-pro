package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

@DisplayName("로또 테스트")
class LottoTest {

    @DisplayName("생성 성공")
    @Test
    void create_lotto_success() {
        assertThatNoException().isThrownBy(() -> new Lotto(new LottoNumberGenerator()));
    }

    @DisplayName("당첨 여부 제공 테스트")
    @Test
    void winningResult_lotto_success() {
        //given:
        Lotto lotto = new Lotto(LottoNumberBagTest.fromManualNumbers("1,2,3,4,5,6"));
        //when:
        WinningLottoBallBag winningLottoBallBag = new WinningLottoBallBag("1,2,3,10,20,30");
        winningLottoBallBag.add(LottoBall.fromStringBonus("45"));
        //then:
        assertThat(lotto.getResult(winningLottoBallBag)).isEqualTo(WinningResult.WIN_FOURTH);
    }

    @DisplayName("2등 당첨 여부 제공 테스트")
    @Test
    void winSecondBonus_lotto_success() {
        //given:
        Lotto lotto = new Lotto(LottoNumberBagTest.fromManualNumbers("1,2,3,4,5,6"));
        //when:
        WinningLottoBallBag winningLottoBallBag = new WinningLottoBallBag("1,2,3,4,5,45");
        winningLottoBallBag.add(LottoBall.fromStringBonus("6"));
        //then:
        assertThat(lotto.getResult(winningLottoBallBag)).isEqualTo(WinningResult.WIN_SECOND_BONUS);
    }

    @DisplayName("4등 당첨 여부 제공 테스트 - 보너스 공 일치")
    @Test
    void winThirdBonus_lotto_success() {
        //given:
        Lotto lotto = new Lotto(LottoNumberBagTest.fromManualNumbers("1,2,3,4,5,6"));
        //when:
        WinningLottoBallBag winningLottoBallBag = new WinningLottoBallBag("1,2,3,4,44,45");
        winningLottoBallBag.add(LottoBall.fromStringBonus("5"));
        //then:
        assertThat(lotto.getResult(winningLottoBallBag)).isEqualTo(WinningResult.WIN_THIRD);
    }
}
