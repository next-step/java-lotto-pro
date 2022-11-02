package step3.ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.configuration.AppConfig;
import step3.domain.LottoSeller;
import step3.domain.PurchaseAmount;

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
