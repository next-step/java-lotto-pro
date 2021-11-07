package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * packageName : lotto.domain
 * fileName : RankEnumTest
 * author : haedoang
 * date : 2021/11/06
 * description : 랭크Enum Test
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
public class RankTest {

    @Test
    @DisplayName("enum을 활용한 로또 당첨 개수 구하기")
    public void T1_countOfMatch() {
        //THEN
        assertThat(Rank.FIRST.getCountOfMatch()).isEqualTo(6);
        assertThat(Rank.SECOND.getCountOfMatch()).isEqualTo(Rank.THIRD.getCountOfMatch());
    }

    @Test
    @DisplayName("enum을 활용한 로또 당첨 금액 구하기")
    public void T2_getWinningMoney() {
        //THEN
        assertThat(Rank.FIRST.getWinningMoney()).isEqualTo(2_000_000_000);
    }

    @Test
    @DisplayName("1등")
    public void T3_1등() {
        //THEN
        assertThat(Rank.valueOf(6, false)).isEqualTo(Rank.FIRST);
        assertThat(Rank.valueOf(6, true)).isEqualTo(Rank.FIRST);
    }

    @Test
    @DisplayName("2등")
    public void T4_2등() {
        //THEN
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("3등")
    public void T5_3등() {
        //THEN
        assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD);
    }
    @Test
    @DisplayName("4등")
    public void T6_4등() {
        //THEN
        assertThat(Rank.valueOf(4, false)).isEqualTo(Rank.FOURTH);
    }
    @Test
    @DisplayName("5등")
    public void T7_5등() {
        //THEN
        assertThat(Rank.valueOf(3, false)).isEqualTo(Rank.FIFTH);
    }
    @Test
    @DisplayName("꽝")
    public void T8_꽝() {
        //THEN
        assertThat(Rank.valueOf(0, true)).isEqualTo(Rank.MISS);
        assertThat(Rank.valueOf(1, false)).isEqualTo(Rank.MISS);
        assertThat(Rank.valueOf(2, true)).isEqualTo(Rank.MISS);
    }


}
