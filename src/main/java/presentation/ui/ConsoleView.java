package presentation.ui;

import domain.*;
import dto.CreateWinningCommand;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public final class ConsoleView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private ConsoleView () {}

    public static void printTicket(Ticket ticket) {
        List<Lotto> lottos = ticket.getElements();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println("[" + toJoinString(lotto) + "]");
        }

    }

    private static String toJoinString(Lotto lotto) {
        return lotto.getSortedNumbers().stream()
                .map(LottoNumber::value)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    public static void printRewards(Rewards rewards) {
        System.out.println("당첨 통계\n---------");
        System.out.println("3개 일치(5,000원)-" + rewards.count(Reward.FOURTH) + "개");
        System.out.println("4개 일치(50,000원)-" + rewards.count(Reward.THIRD) + "개");
        System.out.println("5개 일치(1,500,000원)-" + rewards.count(Reward.SECOND) + "개");
        System.out.println("6개 일치(2,000,000,000원)-" + rewards.count(Reward.FIRST) + "개");
        System.out.println("총 수익률은 " + rewards.calculateRateOfReturn() + "입니다.");
    }

    public static CreateWinningCommand askWinning() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return Arrays.stream(SCANNER.nextLine().split(","))
                .map(Integer::valueOf)
                .collect(Collectors.collectingAndThen(Collectors.toSet(), CreateWinningCommand::new));
    }

    public static long askPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Long.parseLong(SCANNER.nextLine());
    }
}
