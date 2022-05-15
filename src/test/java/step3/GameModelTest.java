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
    @CsvSource(value = {"1000:1000", "999:null", "a:null", "-1:null"}, delimiter = ':', nullValues = {"null"})
    public void buyTicketTest(String money, String expected) {
        assertThat(gameModel.buyTicket(money)).isEqualTo(expected);
    }
}


