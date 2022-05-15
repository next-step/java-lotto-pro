package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Player;

public class ResultView {

    public static void createLotto(Player player) {
        List<Lotto> lottos = player.getLottos();
        System.out.println(lottos.size() + "를 구매했습니다.");

        printLotto(lottos);
    }


    private static void printLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
