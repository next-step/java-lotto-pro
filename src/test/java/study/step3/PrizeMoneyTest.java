package study.step3;

import domain.PrizeMoney;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeMoneyTest {

    @ParameterizedTest
    @CsvSource(value = {"6:false:200000000", "5:true:30000000", "5:false:1500000", "4:flase:50000", "3:false:5000"}, delimiter = ':')
    @DisplayName("상금 가져오기")
    public void 상금_가져오기(int collectCount, boolean matchBonus, int prizeMoney) {
        int result = PrizeMoney.valueOf(collectCount, matchBonus).getPrizeMoney();

        assertThat(result).isEqualTo(prizeMoney);

    }
}
