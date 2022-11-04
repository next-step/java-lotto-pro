package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
public class LottoWinningMoneyTest {

    @Test
    @DisplayName("맞은 번호 갯수로 해당 ENUM 정보를 return 한다.")
    void returnEnumTest(){
        LottoWinningMoney first
                = LottoWinningMoney.findEnumByContainCountAndBonusContain(6,false);
        LottoWinningMoney second
                = LottoWinningMoney.findEnumByContainCountAndBonusContain(5,true);
        LottoWinningMoney third
                = LottoWinningMoney.findEnumByContainCountAndBonusContain(5,false);
        LottoWinningMoney fourth
                = LottoWinningMoney.findEnumByContainCountAndBonusContain(4,false);
        LottoWinningMoney fifth
                = LottoWinningMoney.findEnumByContainCountAndBonusContain(3,false);
        assertAll(
                () -> assertThat(first).isEqualTo(LottoWinningMoney.FIRST),
                () -> assertThat(second).isEqualTo(LottoWinningMoney.SECOND),
                () -> assertThat(third).isEqualTo(LottoWinningMoney.THIRD),
                () -> assertThat(fourth).isEqualTo(LottoWinningMoney.FOURTH),
                () -> assertThat(fifth).isEqualTo(LottoWinningMoney.FIFTH)
        );
    }

    @Test
    @DisplayName("맞은 번호 갯수가 3개 미만인 경우, MISS 로 처리한다.")
    void missTest(){
        LottoWinningMoney missZero
                = LottoWinningMoney.findEnumByContainCountAndBonusContain(0,false);
        LottoWinningMoney missOne
                = LottoWinningMoney.findEnumByContainCountAndBonusContain(1,false);
        LottoWinningMoney missTwo
                = LottoWinningMoney.findEnumByContainCountAndBonusContain(2,false);

        assertAll(
                () -> assertThat(missZero).isEqualTo(LottoWinningMoney.MISS),
                () -> assertThat(missOne).isEqualTo(LottoWinningMoney.MISS),
                () -> assertThat(missTwo).isEqualTo(LottoWinningMoney.MISS)
        );
    }
}
