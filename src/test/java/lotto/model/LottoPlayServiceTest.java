package lotto.model;

import lotto.vo.Lottos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class LottoPlayServiceTest {

    private LottoPlayService lottoPlayService;

    @BeforeEach
    void init() {
        lottoPlayService = new LottoPlayService();
    }

    @DisplayName("입력받은 구매금액을 로또 개수로 변환한다.")
    @ParameterizedTest(name = "[{0}]원 -> [{1}]게임")
    @CsvSource(value = {"10000:10", "5000:5", "3000:3"}, delimiter = ':')
    void convertMoneyToLottos(int money, int expectedPlayCount) {
        Lottos lottos = lottoPlayService.convertMoneyToLottos(money);
        assertEquals(expectedPlayCount, lottos.getPlayCount());
    }

}
