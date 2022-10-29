package study.step3;

import java.util.List;

public class ResultView {
    public static void printLottos(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
    }
}
