package lotto.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoWinningTicketTest {
    private static List<LottoNumber> autoLottoNumbers1; // 5등
    private static List<LottoNumber> autoLottoNumbers2; // 4등
    private static List<LottoNumber> autoLottoNumbers3; // 낙첨(NONE)
    private static LottoWinningTicket lottoWinningTicket;

    @BeforeAll
    static void initialize() {
        autoLottoNumbers1 = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            autoLottoNumbers1.add(new LottoNumber(i + 1));
        }
        autoLottoNumbers2 = new ArrayList<>();
        for (int i = 4; i < 10; i++) {
            autoLottoNumbers2.add(new LottoNumber(i + 1));
        }
        autoLottoNumbers3 = new ArrayList<>();
        for (int i = 10; i < 16; i++) {
            autoLottoNumbers3.add(new LottoNumber(i + 1));
        }

        List<LottoNumber> winningLottoNumbers = new ArrayList<>();
        winningLottoNumbers.add(new LottoNumber(4));
        winningLottoNumbers.add(new LottoNumber(5));
        winningLottoNumbers.add(new LottoNumber(6));
        winningLottoNumbers.add(new LottoNumber(9));
        winningLottoNumbers.add(new LottoNumber(10));
        winningLottoNumbers.add(new LottoNumber(15));
        lottoWinningTicket = new LottoWinningTicket(new LottoTicket(winningLottoNumbers), new LottoNumber(45));
    }

    @Test
    @DisplayName("로또 당첨번호가 정상적으로 초기화된다.")
    void checkLottoWinningNumbers() {
        LottoNumber bonusNumber = new LottoNumber(45);
        assertThat(new LottoWinningTicket(new LottoTicket(autoLottoNumbers1), bonusNumber)).isNotNull();
    }

    @Test
    @DisplayName("로또 번호를 입력하지 않을 경우 오류가 발생한다.")
    void checkInvalidNullLottoTicket() {
        assertThatThrownBy(() -> new LottoWinningTicket(null, new LottoNumber(3))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스볼을 입력하지 않을 경우 오류가 발생한다.")
    void checkInvalidNullBonusBall() {
        assertThatThrownBy(() -> new LottoWinningTicket(new LottoTicket(autoLottoNumbers1), null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 결과를 분석한다.")
    void checkAnalyzeResult() {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        lottoTickets.add(new LottoTicket(autoLottoNumbers1));
        lottoTickets.add(new LottoTicket(autoLottoNumbers2));
        lottoTickets.add(new LottoTicket(autoLottoNumbers3));

        List<LottoRank> lottoResult = lottoWinningTicket.analyzeResult(lottoTickets).getLottoRanks();
        for (LottoRank lottoRank : lottoResult) {
            System.out.println(lottoRank.getMatch());
        }

        assertAll(
            () -> assertThat(lottoResult.get(0)).isEqualTo(LottoRank.FIFTH),
            () -> assertThat(lottoResult.get(1)).isEqualTo(LottoRank.FOURTH),
            () -> assertThat(lottoResult.get(2)).isEqualTo(LottoRank.NONE)
        );
    }
}
