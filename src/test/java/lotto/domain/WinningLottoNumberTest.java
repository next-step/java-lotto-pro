package lotto.domain;

import lotto.common.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoNumberTest {
    @Test
    @DisplayName("보너스_번호_중복_채크")
    void 보너스_번호_중복_채크() {
        String lottoNumbers = "1,2,3,4,5,6";
        int bonusNumber = 1;
        assertThatThrownBy(() -> new WinningLottoNumber(lottoNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_LOTTO_BONUS_NUMBER_DUPLICATION);
    }

    @Test
    @DisplayName("당첨_등수_확인")
    void 당첨_등수_확인() {
        WinningLottoNumber winningLottoNumber = new WinningLottoNumber("1,2,3,4,5,6", 7);
        LottoTicket thirdTicket = new LottoTicket("1,2,3,4,5,8");
        LottoTicket secondTicket = new LottoTicket("1,2,3,4,5,7");
        assertThat(winningLottoNumber.check(thirdTicket)).isEqualTo(Rank.THIRD);
        assertThat(winningLottoNumber.check(secondTicket)).isEqualTo(Rank.SECOND);
    }
}

