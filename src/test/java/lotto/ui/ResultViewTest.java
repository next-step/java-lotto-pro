package lotto.ui;

import lotto.configuration.AppConfig;
import lotto.domain.LottoSeller;
import lotto.domain.PurchaseAmount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultViewTest {
    private ResultView resultView;

    @BeforeEach
    void setUp() {
        resultView = AppConfig.resultView();
    }

    @DisplayName("Lottos 출력 테스트")
    @Test
    void Lottos_출력테스트() {
        resultView.printLottoTickets(new PurchaseAmount(14000));
        resultView.printLottos(LottoSeller.sellLottos(new PurchaseAmount(14000)).lottos());
    }
}
