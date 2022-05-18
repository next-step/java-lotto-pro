package lotto.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoStoreTest {


    @DisplayName("입력받은 구매금액을 로또종이로 변환한다.")
    @ParameterizedTest(name = "[{0}]원 -> [{1}]게임")
    @CsvSource(value = {"10000:10", "5000:5", "3000:3"}, delimiter = ':')
    void issueLottoPaper(String moneyWord, int expectedPlayCount) {
        LottoStore lottoStore = new LottoStore(new Money(moneyWord));
        assertEquals(new LottoPaper(expectedPlayCount), lottoStore.issueLottoPaper());
    }

    @DisplayName("수동 로또 수가 입력받은 금액보다 큰 경우 검증")
    @Test
    void lottoStroe_not_number() {
        Money money = new Money("3000");
        LottoSelfCount lottoSelfCount = new LottoSelfCount("5");
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoStore(money, lottoSelfCount))
                .withMessage("[ERROR] 구매 금액이 부족합니다.");
    }
}
