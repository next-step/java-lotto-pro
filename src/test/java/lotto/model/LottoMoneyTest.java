package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
}
