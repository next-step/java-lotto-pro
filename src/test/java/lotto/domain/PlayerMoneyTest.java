package lotto.domain;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerMoneyTest {

    @ParameterizedTest
    @ValueSource(ints = {500, 900, 999})
    @DisplayName("사용자의 돈은 1000원 미만로 가질 수 없다")
    void limitMoney(int money) {
        assertThatIllegalArgumentException().isThrownBy(() -> PlayerMoney.of(money));
    }


    @Test
    @DisplayName("잔액보다 뺄돈이 적을수 없다")
    void remainMoneyIsBigDeduction() {
        PlayerMoney playerMoney = PlayerMoney.of(2000);
        playerMoney.deduction(1000);

        assertThatIllegalArgumentException().isThrownBy(()-> playerMoney.deduction(1002));
    }


    @Test
    @DisplayName("플레이어의 잔액을 가져온다")
    void deductionMoney() {
        PlayerMoney playerMoney = PlayerMoney.of(5000);
        playerMoney.deduction(1000);
        Assertions.assertThat(playerMoney.remainMoney()).isEqualTo(4000);
    }

    @Test
    @DisplayName("가진돈으로 살 수 있는 로또 갯수")
    void buyAbleMaxLottoQty(){
        assertAll(()-> {
            assertThat(PlayerMoney.of(20000).buyAbleMaxLottoQty()).isEqualTo(20);
            assertThat(PlayerMoney.of(10000).buyAbleMaxLottoQty()).isEqualTo(10);
        });
    }

}