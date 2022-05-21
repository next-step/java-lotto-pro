package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoWinningTicketTest {
    @Test
    @DisplayName("로또 당첨번호가 정상적으로 초기화된다.")
    void checkLottoWinningNumbers() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            lottoNumbers.add(new LottoNumber(i + 1));
        }
        LottoNumber bonusNumber = new LottoNumber(45);

        assertThat(new LottoWinningTicket(new LottoTicket(lottoNumbers), bonusNumber)).isNotNull();
    }

    @Test
    @DisplayName("로또 번호를 입력하지 않을 경우 오류가 발생한다.")
    void checkInvalidNullLottoTicket() {
        assertThatThrownBy(() -> new LottoWinningTicket(null, new LottoNumber(3))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스볼을 입력하지 않을 경우 오류가 발생한다.")
    void checkInvalidNullBonusBall() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            lottoNumbers.add(new LottoNumber(i + 1));
        }

        assertThatThrownBy(() -> new LottoWinningTicket(new LottoTicket(lottoNumbers), null)).isInstanceOf(IllegalArgumentException.class);
    }
}
