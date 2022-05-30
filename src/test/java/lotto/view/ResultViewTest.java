package lotto.view;

import lotto.model.Purchase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.view.ResultView.printPurchaseCountView;
import static org.assertj.core.api.Assertions.assertThat;

class ResultViewTest extends ViewTest {

    @Test
    @DisplayName("입력값을 활용해 구매개수 확인 메시지를 출력한다.")
    void printPurchaseCountView_구매개수() {
        Purchase purchase = Purchase.createPurchase(10000, 3);
        printPurchaseCountView(purchase);
        assertThat(output())
                .isEqualTo(String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다.", 3, 7));
    }

}
