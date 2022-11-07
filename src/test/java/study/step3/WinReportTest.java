package study.step3;

import domain.PrizeMoney;
import domain.WinReport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class WinReportTest {

    @ParameterizedTest
    @CsvSource(value = {"14:3:false:0.35", "1500:5:false:1", "30000:5:true:1"}, delimiter = ':')
    @DisplayName("수익률 게산")
    public void 총_수익률_계산(int lottoTicketCount, int collectNumber, boolean matchBonus, double expectValue){
        WinReport winReport = new WinReport();
        winReport.putLottoResult(PrizeMoney.valueOf(collectNumber,matchBonus));

        double result =  winReport.calculateProfit(lottoTicketCount);

        assertThat(result).isEqualTo(expectValue);


    }
}
