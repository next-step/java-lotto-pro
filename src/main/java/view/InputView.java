package view;

import static domain.LottoWinning.NONE;

import domain.Lotto;
import domain.LottoPurchaser;
import domain.LottoWinning;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int askInputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다\n", lottos.size());
        lottos.forEach(System.out::println);
        System.out.print("\n");
    }

    public static List<Integer> askInputWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        scanner.nextLine();
        String s = scanner.nextLine();
        List<Integer> winningNumber = Arrays.stream(s.split(","))
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
        System.out.print("\n");
        return winningNumber;
    }

    public static void printLottoResult(LottoPurchaser lottoPurchaser) {
        printLottoResultPrefix();
        printWinningResult(lottoPurchaser);
        printEarningRate(lottoPurchaser.getEarningRate());
    }

    private static void printLottoResultPrefix() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    private static void printWinningResult(LottoPurchaser lottoPurchaser) {
        Arrays.stream(LottoWinning.values())
            .filter(lottoWinning -> !lottoWinning.equals(NONE))
            .forEach(lottoWinning -> System.out.printf("%d개 일치 (%d)- %d개\n",
                lottoWinning.getMaxNumberMatched(),
                lottoWinning.getPrize(),
                lottoPurchaser.findWinning(lottoWinning)));
    }

    private static void printEarningRate(float earningRate) {
        System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)\n",
            earningRate);
    }
}
