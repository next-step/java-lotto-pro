package lotto.view;

import lotto.domain.LottoTicket;
import lotto.dto.LottoResultItem;
import lotto.dto.LottoResult;

public class ResultView {

    private ResultView() {
    }

    public static void printTicket(LottoTicket lottoTicket) {
        System.out.println(lottoTicket.size() + "개를 구매했습니다.");
        System.out.println(lottoTicket);
    }

    public static void printStats(LottoResult result) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (LottoResultItem item : result.getItems()) {
            System.out.println(item.getMatch() + "개 일치 (" + item.getPrizeMoney() + "원)- " + item.getCount() + "개");
        }
        System.out.println("총 수익률은 " + result.getEarningRatio() + "입니다. (>1: 수익, <1: 손실)");
    }
}
