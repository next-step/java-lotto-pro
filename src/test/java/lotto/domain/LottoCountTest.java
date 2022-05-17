package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoCountTest {
    @Test
    @DisplayName("로또 구매 횟수가 정상적으로 생성된다.")
    void generate_test() {
        Money money = new Money("2000");
        LottoCount lottoCount = LottoCount.createValidLottoCount("1", money);
        assertThat(lottoCount).isEqualTo(LottoCount.createValidLottoCount("1", money));
    }

    @Test
    @DisplayName("로또 구매 횟수는 숫자 형식이어야 한다.")
    void format_test() {
        assertThatThrownBy(() -> {
            Money money = new Money("2000");
            LottoCount lottoCount = LottoCount.createValidLottoCount("a", money);
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContainingAll("숫자 형식으로 입력해야 합니다.");
    }

    @Test
    @DisplayName("구입 금액과 로또 횟수 비교 결과, 남은 구매 횟수를 반환한다.")
    void rest_test() {
        Money money = new Money("2000");
        LottoCount lottoCount = LottoCount.createValidLottoCount("1", money);
        assertThat(lottoCount.calculateAutoLottoCount(money)).isEqualTo(1);
    }
}
