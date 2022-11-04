package study.lotto.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.lotto.domain.LottoStatus;
import study.message.LottoExceptionCode;
import study.message.NumberExceptionCode;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LottoService 테스트")
class LottoServiceTest {

    private final OrderService orderService = new OrderService();
    private final LottoService lottoService = new LottoService(orderService);

    @BeforeEach
    void setUp() {
        orderService.createOrder("10000");
        orderService.addManualQuantity(2);
        orderService.addManualLotto("1, 2, 3, 4, 5, 6");
        orderService.addManualLotto("1, 2, 3, 4, 5, 6");

        lottoService.createLottos();
    }

    @Test
    void OrderType별_로또_개수를_검증() {
        assertEquals("2,8", lottoService.countByOrderType());
    }

    @ParameterizedTest
    @ValueSource(strings = { "1,2,3", "1,2", "1", "1,2,3,4", "1,2,3,4,5" })
    void 지난주_당첨번호_입력시_숫자_개수가_6개가_아니면_IllegalArgumentException(String winningNumbers) {
        assertThatThrownBy(() -> {
            lottoService.createWinningLotto(winningNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoExceptionCode.NOT_MATCH_LOTTO_SIZE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = { "1,2,3,4,5,-", "(,1,2,3,4,5" })
    void 지난주_당첨번호_입력시_변경할_수_없는_문자가_포함되면_IllegalArgumentException(String winningNumbers) {
        assertThatThrownBy(() -> {
            lottoService.createWinningLotto(winningNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NumberExceptionCode.INVALID_NUMBER_STRING.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = { "0,1,2,3,4,5", "-1,2,3,4,5" })
    void 지난주_당첨번호_입력시_0이하의_숫자가_포함되면_IllegalArgumentException(String winningNumbers) {
        assertThatThrownBy(() -> {
            lottoService.createWinningLotto(winningNumbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_추첨_테스트() {
        lottoService.createWinningLotto("1, 2, 3, 4, 5, 11");
        lottoService.addBonusBall(6);

        lottoService.drawLots();

        Map<LottoStatus, Long> countsByLottoStatus =
                lottoService.getPrintDataWithCountsByLottoStatus();
        assertAll(
                () -> assertEquals(2L, countsByLottoStatus.get(LottoStatus.SECOND_PLACE)),
                () -> assertEquals("6000.00", lottoService.getPrintDataWithProfitRate())
        );
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3, 4, 5, 11 })
    void 보너스볼_입력시_winningNumbers에_포함된_숫자가_보너스볼로_입력되는_경우(int num) {
        lottoService.createWinningLotto("1, 2, 3, 4, 5, 11");

        assertThatThrownBy(() -> {
            lottoService.addBonusBall(num);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoExceptionCode.INVALID_BONUS_BALL.getMessage());
    }
}
