package lotto.model;

import lotto.util.GameRule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoMoneyTest {


    @DisplayName("[정상]로또구입금액 입력값 테스트")
    @ParameterizedTest
    @CsvSource(value = {"14000:3000:3500"}, delimiter = ':')
    void 로또구입금액_입력값_테스트_정상(String buyPrice) {
        assertAll(
                () -> new LottoMoney(buyPrice)
        );
    }

    @DisplayName("[ERROR]로또구입금액 입력값 테스트")
    @ParameterizedTest
    @CsvSource(value = {"가나:800:-2000"}, delimiter = ':')
    void 로또구입금액_입력값_테스트_예외(String buyPrice) {

        assertThrows(IllegalArgumentException.class, () -> new LottoMoney(buyPrice));
    }

    @DisplayName("[정상]로또 수동구입 입력값 테스트")
    @ParameterizedTest
    @CsvSource(value = {"14000:2","3000:3"}, delimiter = ':')
    void 로또수동구입_입력값_테스트_정상(String money, String count) {

        LottoMoney lottoMoney = new LottoMoney(money);
        int manualLottoPaperCount = lottoMoney.parseManualLottoPaperCount(count);

        assertThat(lottoMoney.isMoneySame((manualLottoPaperCount + lottoMoney.getLottoPaperCount()) * GameRule.LOTTO_PAPER_PRICE)).isEqualTo(true);
    }

    @DisplayName("[ERROR]로또 수동구입 입력값 테스트")
    @ParameterizedTest
    @CsvSource(value = {"14000:-20","14000:15"}, delimiter = ':')
    void 로또수동구입_입력값_테스트_예외(String money, String count) {

        assertThrows(IllegalArgumentException.class, () -> new LottoMoney(money).parseManualLottoPaperCount(count));
    }
}
