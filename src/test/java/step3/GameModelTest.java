package step3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.domain.LottoManager;
import step3.model.GameModel;

public class GameModelTest {

    private GameModel gameModel;

    @BeforeEach
    public void init() {
        gameModel = new GameModel(new LottoManager());
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:true", "999:false", "a:false", "-1:false"}, delimiter = ':')
    public void buyTicketTest(String money, boolean expected) {
        assertThat(gameModel.buyTicket(money)).isEqualTo(expected);
    }
}


