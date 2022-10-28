package lotto.domain.seller;

import lotto.domain.money.Money;
import lotto.dto.LottoBill;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoSellerTest {

    @ParameterizedTest
    @DisplayName("전달 받은 돈을 통해 돈만큼 로또 번호 생성 및 판매")
    @MethodSource("amountAndReturnLottoCount")
    void sell_lotto(int amount, int lottoCount) {
        Money money = new Money(amount);
        LottoSeller lottoSeller = new LottoSeller();
        LottoBill lottoBill = lottoSeller.sellAutoLotto(money);
        assertThat(lottoBill.getLottoPiece()).isEqualTo(lottoCount);
    }

    private static Stream<Arguments> amountAndReturnLottoCount() {
        return Stream.of(
                Arguments.of(5000, 5),
                Arguments.of(6000, 6)
        );
    }
}
