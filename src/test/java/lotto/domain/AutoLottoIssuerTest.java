package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AutoLottoIssuerTest {

    private int numberSize;
    private AutoLottoIssuer issuer;

    @BeforeEach
    void setUp() {
        numberSize = 6;
        issuer = new AutoLottoIssuer(new LottoRandomFactory(new RandomNumberMachine(), numberSize));
    }

    @Test
    void 주문금액이_맞아_떨어지지_않으면_최대금액_주문() {
        Money input = Money.from(10100);
        assertThat(issuer.issue(input).totalPrice()).isEqualTo(Money.from(10000));
    }
}