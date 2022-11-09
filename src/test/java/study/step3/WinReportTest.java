package study.step3;

import domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinReportTest {

    private List<LottoNumber> lottoNumbers;
    private Lotto lotto;
    private Lottos lottos;
    WinReport winReport;

    @BeforeEach
    public void inputLottoSetup() {

        lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(45));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(18));
        lottoNumbers.add(new LottoNumber(20));

        lotto = new Lotto(lottoNumbers);
        lottos = new Lottos(new ArrayList<>());

        lottos.add(lotto);

    }

    @ParameterizedTest
    @CsvSource(value = {"14:3:false:0.35", "1500:5:false:1", "30000:5:true:1"}, delimiter = ':')
    @DisplayName("수익률 게산")
    public void 총_수익률_계산(int lottoTicketCount, int collectNumber, boolean matchBonus, double expectValue) {
        winReport = new WinReport();
        winReport.putLottoResult(PrizeMoney.valueOf(collectNumber, matchBonus));

        double result = winReport.calculateProfit(lottoTicketCount);

        assertThat(result).isEqualTo(expectValue);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,10,3,4,7,19:3", "1,45,3,4,7,19:4", "1,45,3,4,18,19:5", "1,45,3,4,18,20:6"}, delimiter = ':')
    @DisplayName("로또번호 맞춘 갯수 검증")
    public void 로또번호_맞춘개수_검증(String given, int collectNumber) {
        WinLotto winLotto = new WinLotto(given, new LottoNumber(41));
        winReport = new WinReport();

        winReport.findWinner(winLotto, lottos);
        assertThat(winReport.getLottoResult(PrizeMoney.valueOf(collectNumber, false))).isEqualTo(1);
    }
}
