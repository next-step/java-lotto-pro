package study.step4.models;

import org.junit.jupiter.api.Test;
import study.step4.exception.LottoInputMoneyInvalidUnitException;
import study.step4.exception.LottoInputMoneyTypeException;

import static org.assertj.core.api.Assertions.*;

public class MoneyTest {
    @Test
    void 돈_객체_생성() {
        assertThatNoException().isThrownBy(() -> new Money("3000"));
    }

    @Test
    void 돈_객체_생성_예외() {
        assertThatThrownBy(() -> new Money("123$#!"))
                .isInstanceOf(LottoInputMoneyTypeException.class);
    }

    @Test
    void 구매_단위에_맞지_않은_경우_예외() {
        assertThatThrownBy(() -> new Money("0"))
                .isInstanceOf(LottoInputMoneyInvalidUnitException.class);
        assertThatThrownBy(() -> new Money("300"))
                .isInstanceOf(LottoInputMoneyInvalidUnitException.class);
        assertThatThrownBy(() -> new Money("1500"))
                .isInstanceOf(LottoInputMoneyInvalidUnitException.class);
    }

    @Test
    void 입력_값을_나누기() {
        Money money = new Money("3000");

        assertThat(money.divide(15000)).isEqualTo(5);
    }

    @Test
    void 입력_값으로_나누기() {
        Money money = new Money("3000");

        assertThat(money.dividedBy(500)).isEqualTo(6);
    }
}
