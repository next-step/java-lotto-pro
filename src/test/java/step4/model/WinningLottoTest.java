package step4.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step4.exception.LottoFormatException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("당첨_로또_클래스")
public class WinningLottoTest {
    @DisplayName("WinningLotto_생성_성공")
    @Test
    void winningLotto_pass_01() {
        String lotto = "1,2,3,4,5,6";
        String bonusNo = "7";
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNo);
        assertThat(winningLotto).isEqualTo(new WinningLotto(lotto, bonusNo));
    }

    @DisplayName("WinningLotto_보너스_번호는_당첨_번호들과_중복이면_에러")
    @Test
    void winningLotto_fail_01() {
        String lotto = "1,2,3,4,5,6";
        String bonusNo = "6";
        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNo))
                .isInstanceOf(LottoFormatException.class);
    }


    @DisplayName("WinningLotto_다른_로또와_매칭_테스트")
    @ParameterizedTest
    @CsvSource(
            value = {"1,2,3,4,5,6:7:FIRST", "1,2,3,4,5,7:7:SECOND", "1,2,3,4,5,8:7:THIRD", "1,2,3,4,8,9:7:FOURTH",
                    "1,2,3,7,8,9:7:FIFTH", "1,2,7,8,9,10:7:MISS", "1,2,7,8,9,10:7:MISS", "1,11,7,8,9,10:7:MISS",
                    "12,11,7,8,9,10:7:MISS", "12,11,13,8,9,10:7:MISS"}, delimiter = ':'
    )
    void winningLotto_match_pass_01(String lottoText, String bonus, String rankName) {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6", bonus);
        Lotto lotto = new Lotto(lottoText);

        assertThat(winningLotto.match(lotto)).isEqualTo(Rank.valueOf(rankName));
    }
}
