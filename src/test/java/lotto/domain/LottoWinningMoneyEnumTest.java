package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
public class LottoWinningMoneyEnumTest {

    @Test
    @DisplayName("맞은 번호 갯수로 해당 ENUM 정보를 return 한다.")
    void returnEnumTest(){
        LottoWinningMoneyEnum moneyEnumFirst
                = LottoWinningMoneyEnum.findEnumByContainCountAndBonusContain(6,false);
        LottoWinningMoneyEnum moneyEnumSecond
                = LottoWinningMoneyEnum.findEnumByContainCountAndBonusContain(5,true);
        LottoWinningMoneyEnum moneyEnumThird
                = LottoWinningMoneyEnum.findEnumByContainCountAndBonusContain(5,false);
        LottoWinningMoneyEnum moneyEnumFourth
                = LottoWinningMoneyEnum.findEnumByContainCountAndBonusContain(4,false);
        LottoWinningMoneyEnum moneyEnumFifth
                = LottoWinningMoneyEnum.findEnumByContainCountAndBonusContain(3,false);
        assertAll(
                () -> assertThat(moneyEnumFirst).isEqualTo(LottoWinningMoneyEnum.FIRST),
                () -> assertThat(moneyEnumSecond).isEqualTo(LottoWinningMoneyEnum.SECOND),
                () -> assertThat(moneyEnumThird).isEqualTo(LottoWinningMoneyEnum.THIRD),
                () -> assertThat(moneyEnumFourth).isEqualTo(LottoWinningMoneyEnum.FOURTH),
                () -> assertThat(moneyEnumFifth).isEqualTo(LottoWinningMoneyEnum.FIFTH)
        );
    }

    @Test
    @DisplayName("맞은 번호 갯수가 3개 미만인 경우, MISS 로 처리한다.")
    void missTest(){
        LottoWinningMoneyEnum moneyEnumMissZero
                = LottoWinningMoneyEnum.findEnumByContainCountAndBonusContain(0,false);
        LottoWinningMoneyEnum moneyEnumMissOne
                = LottoWinningMoneyEnum.findEnumByContainCountAndBonusContain(1,false);
        LottoWinningMoneyEnum moneyEnumMissTwo
                = LottoWinningMoneyEnum.findEnumByContainCountAndBonusContain(2,false);

        assertAll(
                () -> assertThat(moneyEnumMissZero).isEqualTo(LottoWinningMoneyEnum.MISS),
                () -> assertThat(moneyEnumMissOne).isEqualTo(LottoWinningMoneyEnum.MISS),
                () -> assertThat(moneyEnumMissTwo).isEqualTo(LottoWinningMoneyEnum.MISS)
        );
    }
}
