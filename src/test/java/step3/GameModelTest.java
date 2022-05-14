package step3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static step3.LottoConstant.FOUR_NUMBER_MATCH;
import static step3.LottoConstant.LOTTO_PRICE;
import static step3.LottoConstant.SIX_NUMBER_MATCH;
import static step3.LottoConstant.THREE_NUMBER_MATCH;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step3.domain.LottoTicket;
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
        assertThat(gameModel.buyTicket(money)).isEqualTo(money / LOTTO_PRICE);
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

    @ParameterizedTest
    @CsvSource(value = {"1000:true", "10001:true", "2050:true", "1050:true", "900:false", "-1:false",}, delimiter = ':')
    public void validMoneyInputTest(String money, boolean expected) {
        if (expected) {
            Assertions.assertDoesNotThrow(() -> gameModel.validInput(money, InputStatus.MONEY));
        }
        if (!expected) {
            assertThatThrownBy(() -> gameModel.validInput(money, InputStatus.MONEY)).isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    @DisplayName("각 로또별 매칭 갯수를 HashMap으로 반환한다")
    public void testCheckWin() {
        GameModel testModel = initTestModel();

        assertThat(testModel.checkWin("1,2,3,4,5,6"))
            .containsEntry(THREE_NUMBER_MATCH, 2)
            .containsEntry(FOUR_NUMBER_MATCH, 1)
            .containsEntry(SIX_NUMBER_MATCH, 1);
    }

    @Test
    @DisplayName("로또 번호를 가져올수 있어야한다")
    public void getLottoNumbersTest() {
        GameModel testModel = initTestModel();
        assertThat(testModel.getLottoNumbers().toString())
            .isEqualTo("[[1, 2, 3, 4, 5, 6], [1, 2, 3, 4, 5, 6], [1, 2, 3, 4, 7, 8], [1, 2, 3, 7, 8, 9], [1, 2, 3, 7, 8, 9], [1, 2, 7, 8, 9, 10]]");

    }

    private GameModel initTestModel() {
        List<LottoTicket> tickets = new ArrayList<>();
        List<List<String>> lottoSources = new ArrayList<>();
        lottoSources.add(Arrays.asList("1", "2", "3", "4", "5", "6"));
        lottoSources.add(Arrays.asList("1", "2", "3", "4", "5", "6"));
        lottoSources.add(Arrays.asList("1", "2", "3", "4", "7", "8"));
        lottoSources.add(Arrays.asList("1", "2", "3", "7", "8", "9"));
        lottoSources.add(Arrays.asList("1", "2", "3", "7", "8", "9"));
        lottoSources.add(Arrays.asList("1", "2", "7", "8", "9", "10"));

        for (int i = 0; i < lottoSources.size(); i++) {
            tickets.add(LottoTicket.create(lottoSources.get(i)));
        }

        return new GameModel(tickets);
    }

}
