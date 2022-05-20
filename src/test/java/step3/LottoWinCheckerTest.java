package step3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.domain.LottoTicket;
import step3.enums.LottoReward;
import step3.model.LottoWinChecker;

public class LottoWinCheckerTest {

    private LottoWinChecker lottoWinChecker;

    @BeforeEach
    public void init() {
        lottoWinChecker = new LottoWinChecker();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:false", "2:false", "40:false", "3:true", "-a:true", "-1:true"}, delimiter = ':')
    public void setBonusTest(String bonusElement, boolean isThrowable) {
        lottoWinChecker.setWinnerLottoTicket(new LottoTicket("3,4,5,6,7,8"));
        if (isThrowable) {
            assertThatThrownBy(() -> lottoWinChecker.setBonusNumber(bonusElement)).isInstanceOf(IllegalArgumentException.class);
        } else {
            assertDoesNotThrow(() -> lottoWinChecker.setBonusNumber(bonusElement));
        }
    }

    @Test
    @DisplayName("각 로또별 매칭 갯수를 HashMap으로 반환한다")
    public void checkWinTest() {
        lottoWinChecker.setWinnerLottoTicket(new LottoTicket("1,2,3,4,5,6"));
        lottoWinChecker.setBonusNumber("7");
        List<LottoTicket> lottoTickets = new ArrayList<>();

        lottoTickets.add(new LottoTicket("1,2,3,4,5,6")); //6
        lottoTickets.add(new LottoTicket("1,2,3,4,5,8")); //5
        lottoTickets.add(new LottoTicket("1,2,11,12,13,14")); //MISS
        lottoTickets.add(new LottoTicket("1,2,3,4,7,5")); //5_bonus
        lottoTickets.add(new LottoTicket("11,12,13,14,15,16")); // MISS
        assertThat(lottoWinChecker.checkWin(lottoTickets)).containsEntry(LottoReward.MISS, 2).containsEntry(LottoReward.FIVE_BONUS, 1)
            .containsEntry(LottoReward.FIVE, 1).containsEntry(LottoReward.SIX, 1);
    }


}
