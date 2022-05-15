package step3;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @CsvSource(value = {"1,2,3,4,5,6:true", "1,2,3,4,5,-1:true", "1,2,3,4,a,-1:true", "1,2,3,4,4,-1:true", "1,1,3,4,5,-1:true",
        "1,1,3,4,-1:false",}, delimiter = ':')
    @DisplayName("로또 정보 입력시 검증 결과 확인. 갯수가 6개인지만 확인한다")
    public void validLottoInputTest(String lottoInfo, boolean expected) {
        if (expected) {
            Assertions.assertDoesNotThrow(() -> gameModel.validInput(lottoInfo, InputStatus.LOTTO));
        }
        if (!expected) {
            assertThatThrownBy(() -> gameModel.validInput(lottoInfo, InputStatus.LOTTO)).isInstanceOf(IllegalArgumentException.class);
        }
    }







}
