import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class VendorTest {
    @Test
    void 로또를_구매할_수_있다() {
        assertThat(new Vendor().buy(Vendor.LOTTO_BILL)).isInstanceOf(Lottos.class);
    }

    @Test
    void 가격_미만이면_로또를_구매할_수_없다() {
        assertThatThrownBy(() -> new Vendor().buy(Vendor.LOTTO_BILL - 1)).isInstanceOf(RuntimeException.class);
    }
}
