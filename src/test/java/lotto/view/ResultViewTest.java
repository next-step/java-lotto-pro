package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.view.ResultView.printPurchaseCountOutput;
import static org.assertj.core.api.Assertions.assertThat;

class ResultViewTest extends ViewTest{

    @ParameterizedTest
    @DisplayName("입력값을 활용해 구매개수 확인 메시지를 출력한다.")
    @ValueSource(ints = {10, 20, 30, 0})
    void printPurchaseCountOutput_구매개수(int input) {
        printPurchaseCountOutput(input);
        assertThat(output())
                .isEqualTo(String.format("%d개를 구매했습니다.", input));
    }

}