package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AutoLottoIssuerTest {

    private int numberSize;
    private double lottoPrice;
    private AutoLottoIssuer issuer;

    @BeforeEach
    void setUp() {
        numberSize = 6;
        lottoPrice = 1000;
        issuer = new AutoLottoIssuer(new LottoRandomFactory(new RandomNumberMachine(), lottoPrice, numberSize));
    }

    @Test
    void 주문금액_예외() {
        Money input = Money.from(10100);
        assertThatThrownBy(() -> issuer.issue(input)).isInstanceOf(IllegalArgumentException.class);
    }
}