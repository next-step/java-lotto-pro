package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
public class LottoWinningRankTest {

    @Test
    @DisplayName("맞은 번호 갯수로 해당 ENUM 정보를 return 한다.")
    void returnEnumTest(){
        LottoWinningRank first
                = LottoWinningRank.findRankByContainCountAndBonusContain(6,false);
        LottoWinningRank second
                = LottoWinningRank.findRankByContainCountAndBonusContain(5,true);
        LottoWinningRank third
                = LottoWinningRank.findRankByContainCountAndBonusContain(5,false);
        LottoWinningRank fourth
                = LottoWinningRank.findRankByContainCountAndBonusContain(4,false);
        LottoWinningRank fifth
                = LottoWinningRank.findRankByContainCountAndBonusContain(3,false);
        assertAll(
                () -> assertThat(first).isEqualTo(LottoWinningRank.FIRST),
                () -> assertThat(second).isEqualTo(LottoWinningRank.SECOND),
                () -> assertThat(third).isEqualTo(LottoWinningRank.THIRD),
                () -> assertThat(fourth).isEqualTo(LottoWinningRank.FOURTH),
                () -> assertThat(fifth).isEqualTo(LottoWinningRank.FIFTH)
        );
    }

    @Test
    @DisplayName("맞은 번호 갯수가 3개 미만인 경우, MISS 로 처리한다.")
    void missTest(){
        LottoWinningRank missZero
                = LottoWinningRank.findRankByContainCountAndBonusContain(0,false);
        LottoWinningRank missOne
                = LottoWinningRank.findRankByContainCountAndBonusContain(1,false);
        LottoWinningRank missTwo
                = LottoWinningRank.findRankByContainCountAndBonusContain(2,false);

        assertAll(
                () -> assertThat(missZero).isEqualTo(LottoWinningRank.MISS),
                () -> assertThat(missOne).isEqualTo(LottoWinningRank.MISS),
                () -> assertThat(missTwo).isEqualTo(LottoWinningRank.MISS)
        );
    }
}
