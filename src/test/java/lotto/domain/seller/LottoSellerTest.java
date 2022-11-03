package lotto.domain.seller;

import lotto.domain.lotto.Lotto;
import lotto.domain.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoSellerTest {

    @ParameterizedTest
    @DisplayName("전달 받은 돈을 통해 돈만큼 로또 번호 생성 및 판매")
    @MethodSource("amountAndReturnLottoCount")
    void sell_lotto(int amount, int lottoCount) {
        Money money = new Money(amount);
        List<Lotto> lottos = LottoSeller.sellAutoLotto(LottoSeller.possibleBuyLottoQuantity(money));
        assertThat(lottos).hasSize(lottoCount);
    }

    @Test
    @DisplayName("전달 받은 수동 로또 번호를 토대로 로또를 생성해서 반환")
    void sell_manual_lotto() {
        String manualTestCaseOne = "1,2,3,4,5,6";
        String manualTestCaseTwo = "7,8,9,10,11,12";
        List<String> manualLottos = Arrays.asList(manualTestCaseOne, manualTestCaseTwo);
        List<Lotto> manualLotto = LottoSeller.sellManualLotto(manualLottos);
        assertThat(manualLotto).hasSize(manualLottos.size());
    }

    @Test
    @DisplayName("전달 받은 수동 로또 번호를 토대로 로또를 생성해서 반환 (로또 번호가 겹치는게 있어서 IllegalException발생)")
    void sell_manual_lotto_exception() {
        String manualLottoNumbers = "1,2,3,4,5,5";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoSeller.sellManualLotto(Collections.singletonList(manualLottoNumbers)));

    }

    private static Stream<Arguments> amountAndReturnLottoCount() {
        return Stream.of(
                Arguments.of(5000, 5),
                Arguments.of(6000, 6)
        );
    }
}
