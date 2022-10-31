package step3.view;

import step3.model.dto.LottoResultDto;
import step3.model.dto.LottosNumberDto;
import step3.model.dto.RankDto;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LottoOutputView {

    public static void printPurchasingLottos(LottosNumberDto lottosNumberDto) {
        List<List<Integer>> lottoTickets = lottosNumberDto.getLottosNumber();
        System.out.printf("%d개를 구매했습니다.\n", lottoTickets.size());
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
        getSortedRank(resultDto).forEach(rankDto -> {
            if (rankDto.isRankTwo()) {
                System.out.printf("%d개 일치, 보너스 볼 일치(%d원)- %d개\n", rankDto.getMatchCount(), rankDto.getWinningPrice(), rankDto.getWinningCount());
                return;
            }
            System.out.printf("%d개 일치 (%d원)- %d개\n", rankDto.getMatchCount(), rankDto.getWinningPrice(), rankDto.getWinningCount());
        });
    }

    public static void printMinusStatus(double priceRatio) {
        if (priceRatio < 1.0) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }

    public static List<RankDto> getSortedRank(LottoResultDto resultDto) {
        return resultDto.getRanks()
                .stream()
                .filter(rankDto -> rankDto.isWin())
                .sorted(Comparator.comparingInt(RankDto::getWinningPrice))
                .collect(Collectors.toList());


    }
}
