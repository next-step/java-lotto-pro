package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PlayerTest {
    List<Lotto> userLottoList;
    Player player;

    @BeforeEach
    public void setup() {
        player = new Player(10000);
        userLottoList = Arrays.asList(
                Lotto.createCustomLotto(Arrays.asList(1, 2, 3, 4, 5, 6))  // three
                , Lotto.createCustomLotto(Arrays.asList(1, 15, 20, 30, 40, 41)) //fail
                , Lotto.createCustomLotto(Arrays.asList(1, 3, 4, 5, 20, 21)) //fail
                , Lotto.createCustomLotto(Arrays.asList(1, 2, 3, 4, 5, 6))); // three
    }

    @ParameterizedTest
    @CsvSource(value = {"1000,1", "1111,1", "2222,2", "3500,3","10200,10"}
            ,delimiterString = ",")
    @DisplayName("금액이 가능한 만큼 구매를 한다.")
    void buyLotto(int money, int qty) {
        Player player = new Player(money);
        player.buyAutoLottos();
        assertThat(player.getLottos()).hasSize(qty);
    }

    @Test
    @DisplayName("로또를 맞춰본 결과")
    void matchWinnerLotto() {
        Player player = new Player(10000);
        player.buyCustomLottos(userLottoList);

        Lotto winnerLottoNumber = Lotto.createCustomLotto(Arrays.asList(1, 2, 3, 42, 43, 44));
        WinnerLotto winnerLotto = new WinnerLotto(winnerLottoNumber, LottoNumber.of(45));

        LottoReport lottoReport = player.matchWinnerLotto(winnerLotto);

        assertAll(() -> {
            assertThat(lottoReport.rewordTotalMoney()).isEqualTo(10000);
            assertThat(lottoReport.lottoResultCount(LottoRank.FIFTH)).isEqualTo(2);
        });
    }

    @Test
    @DisplayName("수동으로 로또를 구매를 한다.")
    void buyCustomLotto() {
        Player player = new Player(10000);
        player.buyCustomLotto(Lotto.createCustomLotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        player.buyCustomLotto(Lotto.createCustomLotto(Arrays.asList(1, 2, 3, 4, 5, 7)));

        assertThat(player.getLottos().get(1)).isEqualTo(Lotto.createCustomLotto(Arrays.asList(1, 2, 3, 4, 5, 7)));
        assertThat(player.getLottos()).hasSize(2);
    }

    @Test
    @DisplayName("플레이어가 로또 수량만큼 가능한지 여부")
    void limitLottoQty() {
        assertAll(() -> {
            assertThat(player.isBuyAble(4)).isTrue();
            assertThat(player.isBuyAble(11)).isFalse();
            assertThat(player.isBuyAble(3)).isTrue();
        });

    }

    @Test
    @DisplayName("플레이어가 가진 로또 갯수")
    void lottQty() {
        Player player = new Player(10000);
        player.buyCustomLotto(Lotto.createCustomLotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        player.buyCustomLotto(Lotto.createCustomLotto(Arrays.asList(1, 2, 3, 4, 5, 7)));

        assertThat(player.lottoQty()).isEqualTo(2);
    }

}