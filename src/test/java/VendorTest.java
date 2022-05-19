import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class VendorTest {
    @Test
    void 수동_로또가_있으면_포함하여_구매할_수_있다() {
        Lotto manual = Lotto.empty();
        manual.add(new LottoNumbers("1, 2, 3, 4, 5, 6", Application.SEPARATOR));
        Lotto lotto = new Vendor().buyAutoContainsManual(LottoMoney.of(Vendor.LOTTO_PRICE), manual);

        assertThat(lotto).isInstanceOf(Lotto.class);
        assertThat(lotto).contains(
                new LottoNumbers(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6)
                )
        );
    }

    @Test
    void 로또를_구매할_수_있다() {
        assertThat(new Vendor().buyAutoContainsManual(LottoMoney.empty(), Lotto.empty())).isInstanceOf(Lotto.class);
    }

    @Test
    void 로또를_구매할_수_없다() {
        Lotto manual = Lotto.empty();
        manual.add(new LottoNumbers("1, 2, 3, 4, 5, 6", Application.SEPARATOR));
        manual.add(new LottoNumbers("1, 2, 3, 4, 5, 6", Application.SEPARATOR));
        assertThatThrownBy(() -> new Vendor().buyAutoContainsManual(LottoMoney.empty(), manual)).isInstanceOf(RuntimeException.class);
    }
}
