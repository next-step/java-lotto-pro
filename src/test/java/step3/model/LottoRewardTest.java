package step3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또_당첨_결과_저장_클래스")
public class LottoRewardTest {
    @DisplayName("LottoReward_생성_성공")
    @ParameterizedTest
    @CsvSource(value = {"0:ZERO", "1:ONE", "2:TWO", "3:THREE", "4:FOUR", "5:FIVE", "6:SIX"}, delimiter = ':')
    void LottoReward_pass_01(int count, String name) {
        assertThat(LottoReward.getLottoReward(count)).isEqualTo(LottoReward.valueOf(name));
    }

    @DisplayName("LottoReward_총_당첨금액_체크")
    @ParameterizedTest
    @CsvSource(value = {"0:0:ZERO", "1:1:ONE", "2:1:TWO", "3:1:THREE", "4:1:FOUR", "5:1:FIVE", "6:1:SIX"}, delimiter = ':')
    void LottoReward_pass_02(int count, int matchCount, String name) {
        assertThat(LottoReward.getLottoReward(count).getTotMoney(matchCount))
                .isEqualTo(LottoReward.valueOf(name).getMoney() * matchCount);
    }
}
