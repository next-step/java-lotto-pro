package lotto.domain;

import java.io.ByteArrayInputStream;
import java.util.Scanner;
import lotto.ui.Input;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGameTest {

    @DisplayName("LottoGame 이 정상적으로 수행된다.")
    @Test
    void integration_test() {

        System.setIn( new ByteArrayInputStream("2000\n1\n7".getBytes()));
        Scanner scanner = new Scanner(System.in);

        LottoGame lottoGame = new LottoGame(new Input() {
            @Override
            public String nextLine() {
                return scanner.nextLine();
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
