package step4.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또_당첨_결과_저장_클래스")
public class RankTest {
    @DisplayName("Rank_생성_성공")
    @ParameterizedTest
    @CsvSource(value = {"0:false:MISS", "1:false:MISS", "2:false:MISS", "3:false:FIFTH", "4:false:FOURTH", "5:false:THIRD", "5:true:SECOND", "6:false:FIRST"}, delimiter = ':')
    void Rank_pass_01(int count, boolean matchBonus, String name) {
        assertThat(Rank.valueOf(count, matchBonus)).isEqualTo(Rank.valueOf(name));
    }

    @DisplayName("Rank_총_당첨금액_체크")
    @ParameterizedTest
    @CsvSource(value = {"0:1:false:MISS", "1:1:false:MISS", "2:1:false:MISS", "3:1:false:FIFTH", "4:1:false:FOURTH", "5:1:false:THIRD", "5:1:true:SECOND", "6:1:false:FIRST"}, delimiter = ':')
    void Rank_pass_02(int count, int matchCount, boolean matchBonus, String name) {
        assertThat(Rank.valueOf(count, matchBonus).getProfitTotalMoney(matchCount))
                .isEqualTo(Rank.valueOf(name).getWinningMoney() * matchCount);
    }

    @DisplayName("Rank_4이하에서는_bonus_번호_영향_없음")
    @ParameterizedTest
    @CsvSource(value = {"0:true:MISS", "1:true:MISS", "2:true:MISS", "3:true:FIFTH", "4:true:FOURTH"}, delimiter = ':')
    void Rank_pass_03(int count, boolean matchBonus, String name) {
        assertThat(Rank.valueOf(count, matchBonus)).isEqualTo(Rank.valueOf(name));
    }
}
