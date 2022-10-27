package lotto.domain;

import lotto.ui.Input;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGameTest {


    @DisplayName("LottoGame 이 정상적으로 수행된다.")
    @Test
    void integration_test() {

        LottoGame lottoGame = new LottoGame(new Input() {
            @Override
            public String nextLine() {
                return "10000";
            }

            @Override
            public String[] inputNumbers() {
                return new String[]{"1", "2", "3", "4", "5", "6"};
            }
        },
                System.out::println);

        lottoGame.run();
    }
}
