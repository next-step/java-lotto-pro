package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PlayerTest {

    @ParameterizedTest
    @CsvSource(value = {"0,0", "1111,1", "2222,2", "500,0","10200,10"}
            ,delimiterString = ",")
    @DisplayName("금액이 가능한 만큼 구매를 한다.")
    public void buyLotto(int money, int qty) {
        Player player = new Player(money);
        assertThat(player.getLottos()).hasSize(qty);
    }


}