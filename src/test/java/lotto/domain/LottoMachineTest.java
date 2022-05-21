package lotto.domain;

import static lotto.LottoTestUtils.lotto;
import static lotto.LottoTestUtils.lottos;
import static lotto.LottoTestUtils.purchaseLottos;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.InputPurchaseDto;
import lotto.InputWinningNumbersDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoMachineTest {

    @Test
    @DisplayName("발급 성공 테스트")
    void 발급_테스트() {
        // when & then
        assertThat(LottoMachine.purchase(InputPurchaseDto.of("2000", new String[]{"1,2,3,4,5,6"}))).isInstanceOf(
                PurchaseLottos.class);
    }

    @Test
    @DisplayName("숫자형식이 아닌 사용자 입력")
    void 발급_실패_숫자형식() {
        // when & then
        assertThatThrownBy(() -> LottoMachine.purchase(InputPurchaseDto.of("test", new String[]{"1,2,3,4,5,6"})))
                .isInstanceOf(NumberFormatException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "500", "1000.5"})
    @DisplayName("구매가 불가능한 금액 입력")
    void 발급_실패_구매불가(String price) {
        // when & then
        assertThatThrownBy(() -> LottoMachine.purchase(InputPurchaseDto.of(price, new String[]{"1,2,3,4,5,6"})))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("수동 구매 테스트")
    void 수동으로_구매_테스트() {
        // when & then
        final PurchaseLottos actual = LottoMachine.purchase(InputPurchaseDto.of("1000", new String[]{"1,2,3,4,5,6"}));
        assertThat(actual).isEqualTo(purchaseLottos(lottos(lotto(1, 2, 3, 4, 5, 6)), lottos()));
    }

    @Test
    @DisplayName("수동을 0장 구매할떄 테스트")
    void 수동으로_구매_0_테스트() {
        // when & then
        final PurchaseLottos purchaseLottos = LottoMachine.purchase(InputPurchaseDto.of("1000", new String[]{}));
        assertThat(purchaseLottos).isInstanceOf(PurchaseLottos.class);
    }

    @Test
    @DisplayName("수동 구매 수량이 구입 금액을 넘었을때")
    void 수동으로_구매_실패_테스트() {
        // when & then
        assertThatThrownBy(() -> LottoMachine.purchase(InputPurchaseDto.of("1000", new String[]{"1,2,3,4,5,6", "1,2,3,4,5,6,7"})))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 종료시 당첨 번호를 숫자가 아닌 입력을 했을 때")
    void 로또_종료_실패_숫자가_아님() {
        // when & then
        assertThatThrownBy(() -> LottoMachine.winningLottoNumbers(InputWinningNumbersDto.of("1,2,a,4,b,6", "7")))
                .isInstanceOf(NumberFormatException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"-1, 1, 2,3,4,500;7", "2,3,4,5;7", "1,1,1,2,2,2;7"}, delimiterString = ";")
    @DisplayName("로또 종료시 당첨 번호를 로또 번호를 벗어난 입력을 했을 때 혹은 6개를 입력 하지 않았을 떄")
    void 로또_종료_실패_로또_번호가_아님(String winningNumber, String bonusNumber) {
        // when & then
        assertThatThrownBy(() -> LottoMachine.winningLottoNumbers(InputWinningNumbersDto.of(winningNumber, bonusNumber)))
                .isInstanceOf(IllegalArgumentException.class);
    }

}