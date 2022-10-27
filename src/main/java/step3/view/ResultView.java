package step3.view;


import step3.model.dto.LottoStatusDto;
import step3.model.dto.LottosNumberDto;
import step3.model.dto.RankDto;

import java.util.List;

public class ResultView {

    public static void printPurchasingLottos(LottosNumberDto lottosNumberDto){
        List<List<Integer>> lottoTickets = lottosNumberDto.getLottosNumber();
        System.out.printf("%d개를 구매했습니다.\n",lottoTickets.size());
        lottoTickets.forEach(lottoTicket -> System.out.println(lottoTicket));
        System.out.println();
    }


    public static void printWinStats(LottoStatusDto statusDto){
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        List<RankDto> ranks = statusDto.getRanks();
        ranks.stream().forEach(rankDto -> {
            System.out.printf("%d개 일치 (%d원)- %d개\n",rankDto.getMatchCount(),rankDto.getWinningPrice(),rankDto.getWinningCount());
        });
        System.out.printf("총 수익률은 %.2f입니다",(Math.floor(statusDto.getWinnigPercent() * 100) / 100.0 ));
    }
}
