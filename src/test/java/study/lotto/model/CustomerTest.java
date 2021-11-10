package study.lotto.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.junit.jupiter.api.Assertions.assertAll;

class CustomerTest {

    @Test
    void 금액과_주문할_수동로또복권뭉치로_구매자를_생성할_수있다() {
        assertThatNoException().isThrownBy(() -> {
            Customer.valueOf(3000, Arrays.asList(
                    new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                    new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 7))
            ));
        });

    }

    @Test
    void 구매자는_스토어를통해_로또복권을_구매할_수_있다() {
        final Customer customer = Customer.valueOf(3000, Arrays.asList(
                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 7))
        ));
        customer.buy(LottoStore.getInstance());
        assertAll(() -> {
            assertThat(customer.getAutoTicketSize()).isEqualTo(1);
            assertThat(customer.getManualTicketSize()).isEqualTo(2);
        });
    }
}