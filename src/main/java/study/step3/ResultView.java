package study.step3;

import java.util.List;

public class ResultView {
    public static void printLottos(List<Lotto> lottoList) {
        System.out.printf("%d개를 구매했습니다.\n", lottoList.size());
        for (Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
    }
}
