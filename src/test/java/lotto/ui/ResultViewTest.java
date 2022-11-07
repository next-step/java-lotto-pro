package lotto.ui;

import lotto.configuration.AppConfig;
import lotto.domain.Lotto;
import lotto.domain.LottoSeller;
import lotto.domain.PurchaseAmount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ResultViewTest {
    private ResultView resultView;

    @BeforeEach
    void setUp() {
        resultView = AppConfig.resultView();
    }

    @DisplayName("Lotto List 출력 테스트")
    @Test
    void Lottos_출력테스트() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(14000);
        List<Lotto> lottos = LottoSeller.sellLottos(purchaseAmount, new ArrayList<>());

        resultView.printLottos(lottos);
    }
}
