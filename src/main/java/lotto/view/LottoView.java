package lotto.view;

import lotto.Lottos;
import lotto.Statistics;

import java.util.Scanner;

public class LottoView {
	private final Scanner scanner = new Scanner(System.in);

	public String inputCharge() {
		System.out.println("구입금액을 입력해 주세요.");
		return scanner.nextLine();
	}

	public void showLottos(Lottos lottos) {
		System.out.printf("%d개를 구매했습니다.%n", lottos.count());
		System.out.println(lottos);
	}

	public String inputAnswer() {
		System.out.println();
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		return scanner.nextLine();
	}

	public void showStatistics(Statistics statistics) {
		System.out.println();
		System.out.println("당첨 통계");
		System.out.println("---------");
		System.out.println(statistics);
	}
}
