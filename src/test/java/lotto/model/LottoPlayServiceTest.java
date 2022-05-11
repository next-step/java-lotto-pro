package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.vo.Lotto;
import lotto.vo.Lottos;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class LottoPlayServiceTest {

    private final LottoPlayService lottoPlayService = new LottoPlayService();
    private Lottos lottos;

    @BeforeEach
    void setUp(){
        lottos = new Lottos(3);
        lottos.addLotto(new Lotto(Arrays.asList(1,3,5,7,9,10)));
        lottos.addLotto(new Lotto(Arrays.asList(7,10,15,20,25,35)));
        lottos.addLotto(new Lotto(Arrays.asList(3,7,20,35,43,45)));
    }

    @DisplayName("입력받은 구매금액을 로또 개수로 변환한다.")
    @ParameterizedTest(name = "[{0}]원 -> [{1}]게임")
    @CsvSource(value = {"10000:10", "5000:5", "3000:3"}, delimiter = ':')
    void convertMoneyToLottos(int money, int expectedPlayCount) {
        Lottos lottos = lottoPlayService.convertMoneyToLottos(money);
        assertEquals(expectedPlayCount, lottos.getPlayCount());
    }

    @DisplayName("구매 금액이 1000원 미만(로또 최소 금액)인 경우")
    @ParameterizedTest
    @ValueSource(ints = {100, 0, 900})
    void convertMoneyToLottos_low_money(int money) {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoPlayService.convertMoneyToLottos(money))
                .withMessage("[ERROR] 로또 최소 가격은 1000원 입니다.");
    }

    @DisplayName("구매 금액이 10_000_000원 이상인 경우")
    @ParameterizedTest
    @ValueSource(ints = {10_000_000, Integer.MAX_VALUE})
    void convertMoneyToLottos_over_money(int money) {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoPlayService.convertMoneyToLottos(money))
                .withMessage("[ERROR] 로또 구매 최대 가격은 10_000_000원 입니다.");
    }

    @DisplayName("구매 금액이 1000원 단위가 아닌 경우")
    @ParameterizedTest
    @ValueSource(ints = {1500, 1200, 59900})
    void convertMoneyToLottos_incorrect_unit(int money) {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoPlayService.convertMoneyToLottos(money))
                .withMessage("[ERROR] 구매 금액은 1000원 단위로 입력해주세요.");
    }

    @DisplayName("로또 구매개수만큼 로또게임을 진행하고 로또목록에 등록한다.")
    @ParameterizedTest
    @ValueSource(ints = {10, 15, 5})
    void playLottoByCount(int playCount){
        Lottos lottos = lottoPlayService.playLottoByCount(playCount);
        List<Lotto> lottoList = lottos.getLottoList();
        assertThat(lottoList).hasSize(playCount);
    }

    @DisplayName("로또 게임 결과(일치한 개수, 수익률)를 확인한다.")
    @Test
    void playLottoGame(){
        List<Integer> winningNumberList = Arrays.asList(3,7,10,35,43,45);
        lottoPlayService.playLottoGame(lottos,winningNumberList);

        assertEquals(2,lottos.getResultCount(3));
        assertEquals(0,lottos.getResultCount(4));
        assertEquals(1,lottos.getResultCount(5));
        assertEquals(0,lottos.getResultCount(6));
        assertEquals((double) 1_510_000 / 3000 ,lottos.getResultProfitRate());
    }

    @DisplayName("지난주 로또 번호 숫자가 1~45 사이가 아닌 경우 검증")
    @Test
    void playLottoGame_not_lotto_number(){
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoPlayService.playLottoGame(lottos,Arrays.asList(3,7,10,35,43,46)))
                .withMessage("[ERROR] 로또 번호는 1~45 사이의 숫자여야합니다.");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoPlayService.playLottoGame(lottos,Arrays.asList(0,7,10,35,43,46)))
                .withMessage("[ERROR] 로또 번호는 1~45 사이의 숫자여야합니다.");
    }
}
