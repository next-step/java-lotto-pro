package step3.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import step3.controller.LottoController;

public class LottoProviderTest {
    LottoProvider lottoProvider;

    @Test
    void 구매후_반환객체_LottoTicketBundle_확인() {
        // given
        int purchaseCost = 5000;

        // then, when
        assertThat(LottoProvider.buyLotto(purchaseCost)).isInstanceOf(LottoTicketBundle.class);
    }

        // then
        LottoTicketVoucher lottoTicketVoucher = lottoProvider.buyLotto();
    }

}
