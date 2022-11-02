package step3.view;

import step3.model.Rank;
import step3.model.dto.LottoResultDto;
import step3.model.dto.LottoStatusDto;

import java.util.Arrays;
import java.util.List;

public class LottoOutputView {

    public static void printPurchasingLottos(LottoStatusDto lottoStatusDto) {
        List<List<Integer>> lottoTickets = lottoStatusDto.getLottosNumber();
        System.out.printf("\n수동으로 %d장, 자동으로 %d개를 구매했습니다.\n", lottoStatusDto.getManualLottoCount(), lottoStatusDto.getAutoLottoCount());
        lottoTickets.forEach(System.out::println);
        System.out.println();
    }

    public static void printWinStats(LottoResultDto statusDto) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        printRankStats(statusDto);
        double priceRatio = (Math.floor(statusDto.getPriceRatio() * 100) / 100.0);
        System.out.printf("총 수익률은 %.2f입니다.", priceRatio);
        printMinusStatus(priceRatio);
    }

    private static void printRankStats(LottoResultDto resultDto) {
        Rank[] ranks = new Rank[]{Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST};
        Arrays.stream(ranks).forEach(rank -> {
            if (rank == Rank.SECOND) {
                System.out.printf("%d개 일치, 보너스 볼 일치(%d원)- %d개\n", rank.getMatchCount(), rank.getWinningPrice(), resultDto.getWinningCount(rank));
                return;
            }
            System.out.printf("%d개 일치 (%d원)- %d개\n", rank.getMatchCount(), rank.getWinningPrice(), resultDto.getWinningCount(rank));
        });
    }

    public static void printMinusStatus(double priceRatio) {
        if (priceRatio < 1.0) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }

}
