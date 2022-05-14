package step3;

import static step3.LottoConstant.LOTTO_PRICE;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.model.GameModel;

public class GameModelTest {

    private GameModel gameModel;

    @BeforeEach
    public void init() {
        gameModel = new GameModel();
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000, 12000})
    @DisplayName("금액에 맞춰 로또를 생성한다")
    public void createTicketByMoney(int money) {
        Assertions.assertThat(gameModel.buyTicket(money)).isEqualTo(money / LOTTO_PRICE);

    }

}
