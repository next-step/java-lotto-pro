package step3;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import step3.common.exception.InvalidParamException;
import step3.domain.Amount;

public class AmountTest {

    @Test
    void test() {
        BigDecimal bigdecimal = new BigDecimal(1000);
        BigDecimal tmp = bigdecimal.divide(new BigDecimal(500));
        System.out.println(tmp);

    }

    @Test
    void notEnoughAmountException() {
        assertThatExceptionOfType(InvalidParamException.class)
            .isThrownBy(() -> {
                // when
                new Amount(500);
            }) // then
            .withMessageMatching(Amount.NOT_ENOUGH_MESSAGE);
    }
}
