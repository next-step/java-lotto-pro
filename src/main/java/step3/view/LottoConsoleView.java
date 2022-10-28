package step3.view;

import step3.model.dto.LottoResultDto;
import step3.model.dto.LottosNumberDto;
import step3.model.dto.RankDto;

import java.util.List;
import java.util.Scanner;

public class LottoConsoleView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int printPurchasingAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public static String printWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return SCANNER.next();
    }

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
        List<RankDto> ranks = statusDto.getRanks();
        ranks.forEach(rankDto -> System.out.printf("%d개 일치 (%d원)- %d개\n", rankDto.getMatchCount(), rankDto.getWinningPrice(), rankDto.getWinningCount()));
        double priceRatio = (Math.floor(statusDto.getPriceRatio() * 100) / 100.0);
        System.out.printf("총 수익률은 %.2f입니다.", priceRatio);
        printMinusStatus(priceRatio);
    }

    public static void printMinusStatus(double priceRatio) {
        if (priceRatio < 1.0) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }

    }

}
