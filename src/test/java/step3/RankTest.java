package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.domain.Rank;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    
    @Test
    @DisplayName("로또 매칭 개수에 따라 몇등 당첨인지가 결정됨")
    void rank_match_count() {
        assertThat(Rank.valueOf(3,false)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.FORTH.getCount()).isEqualTo(4);
    }
    
    @ParameterizedTest
    @CsvSource(value = {"0:NONE","2:NONE","3:FIFTH","6:FIRST"}, delimiter = ':')
    @DisplayName("변수와 예상값 입력하여 검증")
    void rank_match_count_multi(Integer input, Rank expected) {
        assertThat(Rank.valueOf(input,false)).isEqualTo(expected);
    }
    
    @Test
    @DisplayName("순위에 따른 당첨금")
    void rank_prize() {
        assertThat(Rank.FIFTH.getPrize()).isEqualTo(5000);
    }
    
    @ParameterizedTest
    @CsvSource(value = {"0:0","5:1500000","6:2000000000"}, delimiter = ':')
    @DisplayName("로또 매칭 개수에 따른 당첨금 검증")
    void rank_match_count_multi(int input, long expected) {
        assertThat(Rank.valueOf(input, false).getPrize()).isEqualTo(expected);
    }
    
    @Test
    @DisplayName("순위권 밖 체크")
    void rank_is_none() {
        assertThat(Rank.NONE.isNone()).isEqualTo(true);
    }
    
    @Test
    @DisplayName("순위에 보너스번호 개념 추가")
    void rank_match_bonus() {
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.SECOND.getCount()).isEqualTo(5);
        //assertThat(Rank.SECOND.isBonus()).isEqualTo(true);
    }
    
}
