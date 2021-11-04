package step3.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LottoProviderTest {
    LottoProvider lottoProvider;

    @Test
    void 구매후_반환객체_LottoTicketVoucher_확인() {
        // given
        int purchaseCost = 5000;

        // then, when
        assertThat(LottoProvider.buyLotto(purchaseCost)).isInstanceOf(LottoTicketVoucher.class);
    }
}
