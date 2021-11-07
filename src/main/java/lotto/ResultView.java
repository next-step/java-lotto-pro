package lotto;

public class ResultView {
	public static void printResult(Prize prize) {
		System.out.println();
		System.out.println("당첨 통계");
		System.out.println("---------");
		LottoConstants.PRIZE_LIST.forEach((match, price) -> {
			System.out.printf("%d개 일치 (%d원)- %d개%n", match, price, prize.getCount(match));
		});
		System.out.printf("총 수익률은 %.2f입니다.%n", Math.floor(prize.rateReturn() * 100) / 100);
	}
}
