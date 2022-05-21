package lotto.view;

import lotto.domain.LottoCharge;
import lotto.domain.Lottos;
import lotto.domain.Count;
import lotto.domain.Statistics;

import java.util.Scanner;

public class LottoView {
    private static final Scanner scanner = new Scanner(System.in);

    public String inputCharge() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextLine();
    }

    public String inputManualCount() {
        System.out.println();
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextLine();
    }

    public void inputManualNumbersMessage() {
        System.out.println();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

    public String inputManualNumbers() {
        return scanner.nextLine();
    }

    public void showLottos(Count manualCount, Count autoCount, Lottos lottos) {
        System.out.println();
        System.out.printf("수동으로 %s장, 자동으로 %s개를 구매했습니다.%n", manualCount, autoCount);
        System.out.println(lottos);
    }

    public String inputAnswer() {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public String inputBonus() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextLine();
    }

    public void showStatistics(Statistics statistics) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(statistics);
    }
}
